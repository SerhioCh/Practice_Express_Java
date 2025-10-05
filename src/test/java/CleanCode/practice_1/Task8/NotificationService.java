package CleanCode.practice_1.Task8;

public class NotificationService {
    MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    public  void  sendNotification (String message){
        messageSender.send(message);
    }
}
