package com.example.challenge.util;

import java.util.List;
import java.util.Map;

/**
 * @author German Magana
 * <p>
 * This class has methods to print to the console
 */
public class ConsoleUtil {

    /**
     * This method prints to the console
     * @param value
     */
    public static void print(String value) {
        System.out.println(value);
    }

    /**
     * This method prints to the console a list of values
     * @param list
     */
    public static void print(List<String> list) {
        list.forEach(System.out::println);
    }

    /**
     * This method prints to the console a map object
     * @param map
     */
    public static void printMap(Map<String, Integer> map) {
        int index = 1;
        for (String key : map.keySet()) {

            System.out.println(index + ". " + key + ", " + map.get(key) + " pts");
            index++;
        }
    }
}
