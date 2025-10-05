package CleanCode.practice_1.Task4;

public class Order {
    EmailSender emailSender = new EmailSender();
    InvoceGenerator invoceGenerator = new InvoceGenerator();
    OrderProcessor orderProcessor = new OrderProcessor();

    public Order(EmailSender emailSender, InvoceGenerator invoceGenerator, OrderProcessor orderProcessor) {
        this.emailSender = emailSender;
        this.invoceGenerator = invoceGenerator;
        this.orderProcessor = orderProcessor;
    }

    public  void orderComplete(){
        orderProcessor.processOrder();
        emailSender.sendEmailConfirmation();
        invoceGenerator.generateInvoice();
    }

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        InvoceGenerator invoceGenerator = new InvoceGenerator();
        OrderProcessor orderProcessor = new OrderProcessor();
        Order firstOrder = new Order(emailSender,invoceGenerator,orderProcessor);
        firstOrder.orderProcessor.processOrder();
        firstOrder.emailSender.sendEmailConfirmation();
        firstOrder.invoceGenerator.generateInvoice();
    }
}
