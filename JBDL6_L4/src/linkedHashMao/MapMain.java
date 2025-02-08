package linkedHashMao;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapMain {


    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new
                LinkedHashMap<>();

        linkedHashMap.put("Robin","singh");
        linkedHashMap.put("Preeti", "awasthi");
        linkedHashMap.put("Aakash","kumar");
        linkedHashMap.put("kumar","Singh");


        for (String key: linkedHashMap.keySet()){
            System.out.println(key+" : "+linkedHashMap.get(key));
        }

        System.out.println("=========================================");

        HashMap<String,String> map = new HashMap<>();
        map.put("Robin","singh");
        map.put("Preeti", "awasthi");
        map.put("Aakash","kumar");
        map.put("kumar","Singh");

        for (String key: map.keySet()){
            System.out.println(key+" : "+map.get(key));
        }

    }
}
