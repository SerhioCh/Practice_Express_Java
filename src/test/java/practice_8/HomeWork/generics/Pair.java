package practice_8.HomeWork.generics;

public class Pair <T,U>{
    T first;
    U second;

    public T getFirst() {
        return this.first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return this.second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
