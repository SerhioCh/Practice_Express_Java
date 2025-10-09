package CleanCode.practice_2.homework.fabric.Task2;

public class SwordFactory extends  WeaponFactory{
    @Override
    Weapon createWeapon() {
        return new Sword();
    }
}
