package JavaDev.practice_3;

public class GameSettings {
    static int maxPlayers;
    final String gameName;
    int currentPlayers;

    public GameSettings(String gameName, int currentPlayers) {
        this.gameName = gameName;
        this.currentPlayers = currentPlayers;
    }
    static void  setMaxPlayers(int max){
         maxPlayers = max;
    }
     void  addPlayer(){
        if (currentPlayers<maxPlayers){
            currentPlayers++;
        }
        else {
            System.out.println("Кол-во игроков превышено");
        }
    }
    void  printGameStatus ()
    {
        System.out.println("Название: "+  gameName + " Текущее кол-во игроков: " +currentPlayers +  " Максимальное кол-во игроков: "+ maxPlayers);
    }

    public static void main(String[] args) {
        setMaxPlayers(20);
        GameSettings g1 = new GameSettings("GTA",12);
        g1.addPlayer();
        g1.printGameStatus();

        GameSettings g2 = new GameSettings("COD",18);
        g2.addPlayer();
        g2.printGameStatus();

        GameSettings g3 = new GameSettings("COD",22);
        g3.printGameStatus(); // Показываю что нельзя добавить ещё 1 игрока, т.к превышен  max 20 , можно было так же сделать эксепшен
        g3.addPlayer();

    }
}
