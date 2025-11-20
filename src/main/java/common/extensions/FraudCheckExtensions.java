package common.extensions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import common.annotations.FraudCheckMock;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import practice_middle.models.FraudCheckResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class FraudCheckExtensions  implements BeforeEachCallback , AfterEachCallback {
    private WireMockServer wireMockServer;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        FraudCheckMock mockConfig = extensionContext.getTestMethod()
                .map(m -> m.getAnnotation(FraudCheckMock.class))
                .orElseGet(() -> extensionContext.getTestClass()
                        .map(clazz -> clazz.getAnnotation(FraudCheckMock.class))
                        .orElse(null));
        if (mockConfig!=null){
            setUpWireMock(mockConfig);
        }
    }

    private void setUpWireMock (FraudCheckMock config) throws JsonProcessingException {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(config.port()));
        wireMockServer.start();
        WireMock.configureFor("0.0.0.0",config.port());
        FraudCheckResponse response = FraudCheckResponse.builder()
                .status(config.status())
                .decision(config.decision())
                .riskScore(config.riskScore())
                .reason(config.reason())
                .requiresManualReview(config.requiresManualReview())
                .additionalVerificationRequired(config.additionalVerificationRequired())
                .build();

        String responseBody = mapper.writer().writeValueAsString(response);

        stubFor(post(urlPathMatching(config.endpoint()))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseBody)));
    }



    @Override
    public void afterEach(ExtensionContext context) {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }
    public String getBaseUrl() {
        return wireMockServer != null
                ? "http://host.docker.internal:" + wireMockServer.port()
                : null;
    }

}
