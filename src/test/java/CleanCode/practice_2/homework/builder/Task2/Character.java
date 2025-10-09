package CleanCode.practice_2.homework.builder.Task2;

public class Character {
    double health;
    double damage;
    double armor;
    double magic;

    public Character(double health, double damage, double armor, double magic) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.magic = magic;
    }

    public Character(CharacterBuilder characterBuilder) {
        this.health = characterBuilder.health;
        this.damage = characterBuilder.damage;
        this.armor = characterBuilder.armor;
        this.magic = characterBuilder.magic;
    }

    @Override
    public String toString() {
        return
                "health=" + health +
                ", damage=" + damage +
                ", armor=" + armor +
                ", magic=" + magic;
    }

    static class CharacterBuilder{
        double health;
        double damage;
        double armor;
        double magic;

        public CharacterBuilder setHealth(double health) {
            this.health = health;
            return this;
        }

        public CharacterBuilder setDamage(double damage) {
            this.damage = damage;
            return this;
        }

        public CharacterBuilder setArmor(double armor) {
            this.armor = armor;
            return this;
        }

        public CharacterBuilder setMagic(double magic) {
            this.magic = magic;
            return this;
        }
        public  Character build(){
            return new  Character(this);
        }
    }
}
