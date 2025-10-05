package CleanCode.practice_1;

/**
 Убрал поле которое никогда не будет использоваться
 Поля которые не передались в конструктор не удалял, т.к они могут использоваться
 */
public class Task3 {
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isPremiumMember;
    private int rewardPoints;
    private String preferredLanguage;
    private String homeAddress;
    private String workAddress;

    public Task3(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
