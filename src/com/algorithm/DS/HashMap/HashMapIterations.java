package com.algorithm.DS.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterations {
    public static void main(String[] args) {
        Map<String,String>map=new HashMap<>();
        map.put("name","John");
        map.put("Age","35");
        map.put("Hobbies","football");
        map.put("Likes","Coding");

        System.out.println("1 Iteration Method using EntrySet");
        for (Map.Entry<String,String>entry:map.entrySet()){
            System.out.print("Keys="+entry.getKey());
            System.out.print(" Value="+entry.getValue());
            System.out.println("\t");
        }

        System.out.println("\n2 Iteration Method using keysSet and values\t");

        for (String key :
                map.keySet()) {
            System.out.print(key+" ");
        }
        System.out.println("\t");
        for (String val :
                map.values()) {
            System.out.print(val+" ");
        }

        System.out.print("\n\n3 Iteration Method using Iterator");
        Iterator<Map.Entry<String,String>>itr=map.entrySet().iterator();

        while (itr.hasNext()){
            Map.Entry<String,String >entry=itr.next();
            System.out.println("Key="+entry.getKey()+" value="+entry.getValue());
        }

    }
}
