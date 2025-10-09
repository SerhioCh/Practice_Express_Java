package CleanCode.practice_2.homework.fabric.Task2;

public class BowFactory extends  WeaponFactory{
    @Override
    Weapon createWeapon() {
        return new Bow();
    }
}
