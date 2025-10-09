package CleanCode.practice_2.homework.fabric.Task2;

public class GunFactory extends  WeaponFactory{
    @Override
    Weapon createWeapon() {
        return new Gun();
    }
}
