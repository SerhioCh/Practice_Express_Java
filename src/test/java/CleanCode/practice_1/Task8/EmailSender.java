package CleanCode.practice_1.Task8;

public class EmailSender implements MessageSender{
    @Override
    public void send(String message) {
        System.out.println("Отправка email: " + message);
    }
}
