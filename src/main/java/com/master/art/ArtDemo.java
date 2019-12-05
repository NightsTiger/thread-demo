package com.master.art;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : dingwenqiang
 * @date : 2019/7/13 18:20
 */
public class ArtDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            int rd = Math.random() > 0.5 ? 1 : 0;
            System.out.println("\'" + UUID.randomUUID() + "\'," + rd + ",");

            //'5b9b6c7bddf84ed2a0b9a32008ef34af', 0,
        }




        Map<String, Object> map = new HashMap<>();
        map.put("aaa", new Person("aaa",1));
        map.put("bbb", new Person("bbb",2));
        map.put("ccc", new Person("ccc",3));

        System.out.println(map);



        ArtDemo a = new ArtDemo();
        System.out.println(a.getClass().getSimpleName());
        System.out.println(a.getClass().getCanonicalName());
        System.out.println(a.getClass().getTypeName());

    }
}
