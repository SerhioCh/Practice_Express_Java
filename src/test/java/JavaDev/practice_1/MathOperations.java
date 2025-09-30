package JavaDev.practice_1;

public class MathOperations {

    static int  add(int x, int y){
        return  x+y;
    }
    static int subtract(int x, int y){
        return  x-y;
    }
    static int  multiply(int x, int y){
        return  x*y;
    }
    static double divide(int x, int y) {
        return  (double) x/y;
    }

   static int  findMax(int a, int b) {
     return    Math.max(a,b);
   }

   static int  difference(int x, int y){
        return Math.abs(x-y);
   }


    static int  squareArea(int side) {
        return side*side;
    }

    static int  squarePerimeter(int side) {
        return  4*side;
   }

    static double  convertSecondsToMinutes(int seconds) {
       if (seconds<=0){
          throw  new IllegalArgumentException("Введите корректное значение секунд, не может быть 0 и отрицательным значением");
       }
        return  (double)seconds/60.0;
    }
    static double averageSpeed(double distance, double time) {
        if (time==0){
            throw new IllegalArgumentException("Время не должно равняться 0");
        }
        return   (double) distance/time;
    }
    static  double findHypotenuse(double a, double b){
        return  Math.sqrt(a*a+b*b);
    }
    static double circleCircumference(double radius){
        return 2* Math.PI * radius;
    }
    static  double  calculatePercentage(double total, double part) {
        return  (part/total)*100;
    }
    static  double celsiusToFahrenheit(double c){
        return  c * 9 / 5 + 32;
    }
    static  double fahrenheitToCelsius(double f) {
        return  (f-32)*5/9;
    }


    public static void main(String[] args) {
        System.out.println("Результат сложения: " + MathOperations.add(1,2));
        System.out.println("Результат вычитания: " + MathOperations.subtract(3,2));
        System.out.println("Результат умножения: " + MathOperations.multiply(2,2));
        System.out.println("Результат деления: " + MathOperations.divide(2,5));
        System.out.println("Результат нахождения большего значения: " + MathOperations.findMax(19,5));
        System.out.println("Результат нахождения разницы между двумя числами: " + MathOperations.difference(6,5));
        System.out.println("Результат нахождения площади: " + MathOperations.squareArea(6));
        System.out.println("Результат нахождения периметра: " + MathOperations.squarePerimeter(6));
        System.out.println("Результат нахождения cредней скорости " + MathOperations.averageSpeed(8,6));
        System.out.println("Результат нахождения Гипотенузы: " + MathOperations.findHypotenuse(5,4));
        System.out.println("Результат нахождения Длины окружности: " + MathOperations.circleCircumference(10));
        System.out.println("Результат нахождения процента: " + MathOperations.calculatePercentage(4,10));
        System.out.println("Результат нахождения градусов  Фаренгейтов из Цельсия: " + MathOperations.celsiusToFahrenheit(23));
        System.out.println("Результат нахождения градусов из  Цельсия в Фаренгейты: " + MathOperations.fahrenheitToCelsius(125));
        try {
            System.out.println("Результат нахождения минут из секунд: " + MathOperations.convertSecondsToMinutes(-1));
        }
        catch (IllegalArgumentException e){
            System.err.println("Ошибка: "+ e.getMessage());
        }


    }
}


//1. Напишите класс JavaDev.practice_1.MathOperations
//        Условие:
//        Создайте класс JavaDev.practice_1.MathOperations с методами:
//        add(int x, int y) — возвращает сумму двух чисел
//        subtract(int x, int y) — разницу
//        multiply(int x, int y) — произведение
//        divide(int x, int y) — результат деления в double
//        В main вызовите каждый метод с произвольными числами и выведите результат. +
//
//        2. Реализуйте метод для нахождения максимума двух чисел +
//        Условие:
//        Создайте метод findMax(int a, int b), который возвращает большее из двух чисел.
//        Вызовите метод в main и выведите результат.
//
//        3. Метод для нахождения разницы между двумя числами +
//        Условие:
//        Создайте метод difference(int x, int y), который возвращает модуль разности двух чисел.
//        Проверьте метод в main.
//
//        4. Методы для площади и периметра квадрата +
//        Условие:
//        Создайте два метода:
//        squareArea(int side) — возвращает площадь квадрата
//        squarePerimeter(int side) — возвращает периметр
//        Вызовите оба метода в main с примером.
//
//        5. Метод для перевода секунд в минуты +
//        Условие:
//        Создайте метод convertSecondsToMinutes(int seconds), который возвращает количество минут (целых или дробных).
//        Вызовите метод в main и выведите результат.
//
//        6. Метод для вычисления средней скорости +
//        Условие:
//        Создайте метод averageSpeed(double distance, double time), который возвращает среднюю скорость (distance / time).
//        Вызовите метод с разными значениями.
//
//        7. Метод для нахождения гипотенузы +
//        Условие:
//        Создайте метод findHypotenuse(double a, double b) для вычисления гипотенузы по теореме Пифагора:
//        √(a² + b²)
//        Вызовите метод с несколькими наборами чисел.
//
//        8. Метод для длины окружности +
//        Условие:
//        Создайте метод circleCircumference(double radius), который возвращает длину окружности по формуле 2πr.
//        Проверьте работу на нескольких значениях.
//
//        9. Метод для вычисления процентов +
//        Условие:
//        Создайте метод calculatePercentage(double total, double part) — возвращает, какой процент от общего составляет часть.
//        Пример: 25 из 200 → 12.5%
//
//        10. Методы перевода температуры +
//        Условие:
//        Создайте два метода:
//        celsiusToFahrenheit(double c) — перевод в Фаренгейты: C × 9 / 5 + 32
//        fahrenheitToCelsius(double f) — перевод в Цельсий: (F − 32) × 5 / 9
//        Проверьте оба метода в main.














//Подсказки:
//        Класс JavaDev.practice_1.MathOperations: создай отдельные методы. Для деления обязательно использовать double-преобразование (x / (double)y), чтобы не было целочисленного деления.
//        Метод для нахождения максимума двух чисел: используй встроенную функцию Math.max(a, b). Верни результат напрямую или через переменную.
//        Метод для нахождения разницы между двумя числами: используй Math.abs(x - y), чтобы получить положительное значение независимо от порядка аргументов.
//        Методы для площади и периметра квадрата: формулы: площадь = side * side, периметр = 4 * side.
//        Метод для перевода секунд в минуты: деление: seconds / 60.0 — результат лучше вернуть как double, особенно если нужно точное значение.
//        Метод для вычисления средней скорости: проверь, чтобы time не было равно нулю. Можно добавить условие или просто протестировать с корректными значениями.
//        Метод для нахождения гипотенузы: используй Math.sqrt(a*a + b*b) для вычисления. Убедись, что аргументы положительные.
//        Метод для длины окружности: используй Math.PI для числа π. Формула: 2 * Math.PI * radius.
//        Метод для вычисления процентов: формула: (part / total) * 100. Убедись, что total не ноль, иначе деление вызовет ошибку.
//        Методы перевода температуры: возвращай результат как double, чтобы сохранить точность вычислений.
