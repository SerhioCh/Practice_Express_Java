package practice_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Taks10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        names.removeIf(n ->n.startsWith("A"));
        System.out.println(names);
        }
    }

