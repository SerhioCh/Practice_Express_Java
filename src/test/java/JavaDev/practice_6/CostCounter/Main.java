package JavaDev.practice_6.CostCounter;

public class Main {
    public static void main(String[] args) {
        CostCounter costCounter = new CostCounter();
        costCounter.addCost(1,123.51);
        costCounter.addCost(2,1233.52);
        costCounter.addCost(3,2233.52);
        costCounter.addCost(4,5233.52);
        costCounter.addCost(5,6233.52);
        System.out.println(costCounter.getCosts(3));
        System.out.println(costCounter.minCostMoth());
    }
}
