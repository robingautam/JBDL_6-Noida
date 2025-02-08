package map;

import java.util.*;

public class MapMain {

    public static void main(String[] args) {
      /*  Map<String,Integer> map = new HashMap<>();

        map.put("Robin",23);
        map.put("aakash",45);
        map.putIfAbsent("Robin",67); // it is not going to add the data in map
      //  map.remove("Robin"); // IT will remove the key
        System.out.println(map.getOrDefault("Robin", 34));

      /*  for (Map.Entry<String,Integer> es: map.entrySet()){
            System.out.println(es.getKey()+" : "+es.getValue());
        }*/

        /*for (String s:map.keySet()){
            System.out.println(s+" : "+map.get(s));
        }*/

      /*  Map<String,Integer> map = new LinkedHashMap<>();

        map.put("Robin",23);
        map.put("aakash",45);
        for (Map.Entry<String,Integer> es: map.entrySet()){
            System.out.println(es.getKey()+" : "+es.getValue());
        }*/
        Map<String,Integer> treemap = new TreeMap<>();
        treemap.put("b",12);
        treemap.put("c",23);
        treemap.put("a",2);
        for (Map.Entry<String,Integer> es: treemap.entrySet()){
            System.out.println(es.getKey()+" : "+es.getValue());
        }

    }
}
