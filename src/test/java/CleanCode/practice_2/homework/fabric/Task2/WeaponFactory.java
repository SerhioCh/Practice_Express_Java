package CleanCode.practice_2.homework.fabric.Task2;

abstract class WeaponFactory {
    abstract  Weapon createWeapon();

    public  void printWeapon(){
        Weapon weapon = createWeapon();
        weapon.checkWeapon();
    }
}
