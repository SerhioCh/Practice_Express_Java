package JavaDev.practice_6.user_monitor;

public class Main {
    public static void main(String[] args) {
        UserMonitor userMonitor = new UserMonitor();

        userMonitor.addNewSession("177");
        userMonitor.addNewSession("222");
        userMonitor.addNewSession("66643");
        userMonitor.addNewSession("177");
userMonitor.printSessions();


    }
}
