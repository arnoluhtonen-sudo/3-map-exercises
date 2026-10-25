package part02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class contains a set of methods that you need to implement.
 *
 * Do not change the method signatures or fields, as these will be used by the
 * automated tests.
 *
 * These exercises have been applied from the course material of the MOOC
 * programming course (https://ohjelmointi-23.mooc.fi/osa-5). CC BY-NC-SA 4.0
 */
public class MapExperts {

    /**
     * Returns a Map containing the letters of the given word as keys and the
     * number of occurrences of each letter as values.
     *
     * For example, if the word is "hello", the returned Map contains the
     * following key-value pairs: { h -> 1, e -> 1, l -> 2, o -> 1 }
     *
     * You can assume that all letters are in lower case and that the given word
     * contains only letters.
     */
    /*
     * Hint: you can get the characters of a String using either the charAt() method
     * or the toCharArray() method. charAt() returns a single character and
     * toCharArray() returns an array of characters.
     */
    // omat lähteet:
    // https://www.javathinking.com/blog/hashmap-implementation-to-count-the-occurrences-of-each-character-in-java/
    // Integer::sum https://www.geeksforgeeks.org/java/java-method-references/
    public Map<Character, Integer> countLetters(String word) {
        
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : word.toCharArray()){
            charCountMap.merge(c, 1, Integer::sum);
        }
        return charCountMap;
    }

    /**
     * Returns a new map that has the keys and values of the given map swapped.
     *
     * For example, if the given map contains the key-value pairs
     * { "one" -> 1, "two" -> 2, "three" -> 3 }
     * then the returned map contains the key-value pairs
     * { 1 -> "one", 2 -> "two", 3 -> "three" }
     */
    /*
    * The keys of a map are always unique, so we can't have two keys with the same
    * value. However, there is no such restriction for the values of a map:
    *
    * { "apples" -> 1, "oranges" -> 1 }
    *
    * If the given map contains multiple keys with the same value, as above, you
    * can choose any of the keys to be the value of the reversed map. So either
    * { 1 -> "apples" } or { 1 -> "oranges" } will be accepted.
    */
   // aika pitkä keskustelu stackoverflowissa
   // olisin muuten tehnyt sen for(teksti : teksti){} lauseella, mutta mutta tuolta löyty forEach()
   // https://stackoverflow.com/questions/20412354/reverse-hashmap-keys-and-values-in-java
   // Java 8+ forEach() https://www.geeksforgeeks.org/java/iterable-foreach-method-in-java-with-examples/
   
   // löysin ton "yksi -> kaksi" youtube videosta kun kertasin uusinta kokeeseen
   // https://youtu.be/xTtL8E4LzTQ?si=lb_kBfx2U00T3NU1&t=17080
   // Java 8+ https://www.geeksforgeeks.org/java/lambda-expressions-java-8/

    public Map<Integer, String> reverseMap(Map<String, Integer> map) {


        Map<Integer, String> newMap = new HashMap<>();
        map.forEach((k, v) -> newMap.put(v, k));
        return newMap;
    }

    /**
     * Creates a new map from the given list of Course objects. The keys of the map
     * are the course codes and the values are the Course objects. You can assume
     * that the course codes are unique.
     *
     * For example, if the list contains the following Course objects:
     * [Course("SOF001AS3A", "Ohjelmointi 2"),
     * Course("SOF004AS2A", "Python-ohjelmointi")]
     *
     * Then the returned map contains the following key-value pairs:
     *
     * "SOF001AS3A" -> Course("SOF001AS3A", "Ohjelmointi 2")
     * "SOF004AS2A" -> Course("SOF004AS2A", "Python-ohjelmointi")
     */
    /*
     * Each Course object has a code and a name. You can access them using the
     * code() and name() methods:
     *
     * String code = course.code();
     * String name = course.name(); // you won't need this in the exercise
     */

    // luin https://www.javathinking.com/blog/how-to-convert-list-to-map-in-java/
    // kokeilin mutta se palo punasta niin en tehnyt Collectors.toMap
    // Toi for() oli helpoin ja tuttu tapa

    
    public Map<String, Course> createMapFromList(List<Course> list) {
        Map<String, Course> newMap = new HashMap<>();
        for(Course course : list) {
            newMap.put(course.code(), course);
        }

        return newMap;
    }
}
