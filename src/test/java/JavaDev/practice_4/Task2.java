package JavaDev.practice_4;

import static JavaDev.practice_4.Season.SUMMER;

public class Task2 {
    public static String dayOfWeek (int day){
        String dayOfWeek ="";
        switch (day){
            case 1:
                dayOfWeek = "Понедельник";
                break;
            case 2:
                dayOfWeek = "Вторник";
                break;
            default:
                dayOfWeek="Несуществующий день";
        }
        return  dayOfWeek;
    }

    public  static String  describeSeason(Season season){
        String describeSeasonLam="";
        switch (season) {
            case WINTER -> describeSeasonLam = "Зима - холодно и снежно";

            case SUMMER -> describeSeasonLam = "Лето-жарко";
        }
        return describeSeasonLam;
    }

    public static void main(String[] args) {
        System.out.println(Task2.dayOfWeek(3));
        System.out.println(Task2.describeSeason(SUMMER));
    }
}
