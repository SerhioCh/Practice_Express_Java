package JavaDev.sobes.oop;

/**
 Реализовать систему бронирования в отеле
 Есть номера разных типов standart ,lux, apartments
 У каждого есть свой уникальный id , цена, статус (Свободен,занят)
 Каждый номер можно забронировать , либо снять бронь
 Система должна хранить все номера и выдавать функциональность прос статус всех  доступных номеров
 Распечатка (Тип номера, цена)
 Пример:
 разные типы с разными ценами,   вернуть только свободные типы

 */
public class Main {
    public static void main(String[] args) {
        Room r1 = new Apartments(3,777.23,"Available");
        Room r2 = new Apartments(2,777.23,"Booked");
        Room r3 = new Lux(5,1111,"Available");
        Room r4 = new Standart(10,565461,"Available");

        Hotel h = new Hotel();
        h.addRoom(r1);
        h.addRoom(r2);
        h.addRoom(r3);
        h.addRoom(r4);
        h.findRooms();


    }

}
