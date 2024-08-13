package patterns.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();

        for(List<String> cities : paths) {
            set.add(cities.getFirst());
        }

        for(List<String> cities : paths) {
            if(!set.contains(cities.getLast())) {
                return cities.getLast();
            };
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
