package JavaDev.practice_6.CostCounter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class CostCounter {
    //массив , индекс  = номер месяца
    private ArrayList<Double> costPerMonth  = new ArrayList<>();



    public  void addCost(int month, Double costs){
        costPerMonth.add(month-1,costs);
    }
    // метод получения значения расхода по месяцу
    public  Double getCosts(int month){
        return  costPerMonth.get(month-1);
    }
    //считать месяц с минимальным расходом
    public Double minCostMoth(){
        AtomicReference<Double> min = new AtomicReference<>(costPerMonth.get(0));
        costPerMonth.forEach(
                cost -> {
                    if(cost < min.get()){
                        min.set(cost);
                    }
                } 
        );

        return  min.get();
    }
}
