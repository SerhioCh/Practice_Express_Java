package CleanCode.practice_2.homework.builder.Task2;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Character character1 = new Character.CharacterBuilder()
                .setArmor(100.0)
                .setHealth(98.2)
                .setMagic(12.3)
                .build();
        Character character2 = new Character.CharacterBuilder()
                .setMagic(12.3)
                .build();
        game.addCharacter(character1);
        game.addCharacter(character2);
    }
}
