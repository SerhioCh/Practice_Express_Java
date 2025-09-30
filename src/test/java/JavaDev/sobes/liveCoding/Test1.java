package JavaDev.sobes.liveCoding;

/**
 Дана строка  , дан символ
 Задача , сколько раз повторился заданный символ

 Пример
 String s = "pasha" target =a  result = 2
 Алгоритм решения:
 Разбить строку по чарам
 Посчитать кол-во повторяющихся чаров
 Найти из повторяющихся значений только target
 */
public class Test1 {
    public static int findCountElements (String str, char target) {
        if(str.length()<3 || str.length()>25){
            throw  new IllegalArgumentException("В строке должно быть от 3-х до 25 символов");
        }
        char [] ch = str.toLowerCase().replace(" ","").toCharArray();
         int count =0;
         for (Character c: ch){
             if (target==c){
                 count++;
             }
         }
         return count;
    }

    public static void main(String[] args) {
     //   System.out.println(findCountElements("pasha",'a'));
     //   System.out.println(findCountElements("1",'a'));
     //   System.out.println(findCountElements("1453 54353424325436436436436346346364",'a'));

    }

}
/*
Регистрозависимость - (нужно обрабатывать)
Пробелы, символы  - (нужно обрабатывать)
Ограничение строки в 3 символа  max [3;25]



 */