package CleanCode.practice_1.Task8;

public class Main {
    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        NotificationService notificationService = new NotificationService(emailSender);
        notificationService.sendNotification("Not One");
    }

}
