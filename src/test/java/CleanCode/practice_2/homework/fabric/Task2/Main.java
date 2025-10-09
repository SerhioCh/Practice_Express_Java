package CleanCode.practice_2.homework.fabric.Task2;

public class Main {
    public static void main(String[] args) {
        WeaponFactory weaponFactory;
        weaponFactory = new GunFactory();
        weaponFactory.printWeapon();

        weaponFactory = new BowFactory();
        weaponFactory.printWeapon();

        weaponFactory = new SwordFactory();
        weaponFactory.printWeapon();
    }
}
