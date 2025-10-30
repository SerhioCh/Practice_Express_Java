package practice_middle.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseSpecs {
   private   ResponseSpecs (){}


    private  static ResponseSpecBuilder getDefaultResponseBuilder(){
       return  new ResponseSpecBuilder();
    }

    public  static ResponseSpecification ignoreErrors(){
        return  getDefaultResponseBuilder().build();

    }

    public  static ResponseSpecification entityWasCreated(){
       return  getDefaultResponseBuilder()
               .expectStatusCode(HttpStatus.SC_CREATED)
               .build();
    }

    public  static ResponseSpecification requestReturnsOK(){
        return  getDefaultResponseBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public  static ResponseSpecification requestReturnsBAD(){
        return  getDefaultResponseBuilder()
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }
}
