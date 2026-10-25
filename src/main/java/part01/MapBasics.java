package part01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class demonstrates the basic operations of a Map. Implement each method
 * in this class. You may assume that all given keys and values are non-null.
 *
 * Do not change the method signatures or fields, as these will be used by the
 * automated tests.
 *
 * Resources:
 * https://dev.java/learn/api/collections-framework/working-with-keys-and-values/
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html
 * https://doc.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html
 */
public class MapBasics {

    /**
     * Create and return a new Map that maps String keys to String values.
     */
    public Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();

        // Hint: you can not instantiate a Map directly, but you can instantiate a class
        // that *implements* the Map interface.
        return map;
    }

    /**
     * Add the given key/value pair to the given map.
     */
    public void addEntry(Map<String, String> map, String key, String value) {
        // Hint: use the put method
        map.put(key, value);
    }

    /**
     * Returns a map that maps the names of the Nordic countries to their
     * populations. The countries and their populations are:
     *
     * Denmark 5 894 687
     * Finland 5 587 442
     * Iceland 354 234
     * Norway 5 509 591
     * Sweden 10 261 767
     *
     * Source: https://en.wikipedia.org/wiki/Nordic_countries, 9.8.2023
     */
    public Map<String, Integer> getPopulations() {
        // Hint: Make sure to write the names of the countries exactly as they are
        // written above, otherwise the tests will fail.
        Map<String, Integer> populations = new HashMap<>();
        populations.put("Denmark", 5_894_687);
        populations.put("Finland", 5_587_442);
        populations.put("Iceland", 354_234);
        populations.put("Norway", 5_509_591);
        populations.put("Sweden", 10_261_767);

        return populations;
    }

    /**
     * Return the value associated with the given key in the given map. If the key
     * is not in the map, return null.
     */
    public String getValue(Map<String, String> map, String key) {
        // Hint: use the get method
        ;
        return map.getOrDefault(key, null);
    }

    /**
     * Return true if the given map contains the given key, false otherwise.
     */
    public boolean hasKey(Map<String, String> map, String key) {
        // Hint: see the resources above for a method that does this and the rest of
        //String s = map.get(key);
        if(map.get(key) == null){
            return false;}
        return true;
    }

    /**
     * Return true if the given map contains the given value, false otherwise.
     */
    public boolean hasValue(Map<String, String> map, String value) {
        if(map.containsValue(value)){
            return true;}
        return false;
    }

    /**
     * Add the given key/value pair to the given map if the key is not already in
     * the map.
     */
    public void addIfNotPresent(Map<String, String> map, String key, String value) {
        map.putIfAbsent(key, value);
    }

    /**
     * Remove the entry with the given key from the given map.
     *
     * @param map the map to remove the entry from
     * @param key the key of the entry to remove
     */
    public void removeEntry(Map<String, String> map, String key) {
        map.remove(key);
    }

    /**
     * Return the number of entries (key/value pairs) in the given map.
     *
     * @param map the map to count the entries in
     * @return the number of entries in the map
     */
    public int countEntries(Map<String, String> map) {
        return map.size();
    }

    /**
     * Return true if the given map is empty, false otherwise.
     */
    public boolean isEmpty(Map<String, String> map) {
        if (map.isEmpty()) {
           return true;
        }
        return false;
    }

    /**
     * Return the largest Integer value in the map. If the map is empty, return
     * null.
     */
    public Integer largestValue(Map<String, Integer> map) {
        Set<String> avaimetMaat = map.keySet();
        if (map.isEmpty()) {
            return null;
        }
        int suurinVakiluku = 0;
        for (String avainMaa : avaimetMaat){
            int vakiluku = map.get(avainMaa);
            if (vakiluku > suurinVakiluku) {
                suurinVakiluku = vakiluku;
            }
        }
        return suurinVakiluku;
    }

    /**
     * Return the sum of all the Integer values in the map. If the map is empty,
     * return 0.
     */
    public int sumOfValues(Map<String, Integer> map) {
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
            
        }
        return sum;
    }

    /**
     * Combines the two maps into a single map. If a key is in both maps, the value
     * from the first map is used.
     *
     * The method must create and return a new map. Neither of the two given
     * maps should be modified.
     */
    // lähteet:
    // https://www.baeldung.com/java-merge-maps
    // https://stackoverflow.com/questions/4299728/how-can-i-combine-two-hashmap-objects-containing-the-same-types
    public Map<String, String> combineMaps(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> map3 = new HashMap<>();
        // map3.putAll(map2);
        // map3.putAll(map1);
        // eka mappi tulee kakkosena et se ylikirjoittaa saman valuen
        // stackoverflow kommenteissa vielä lyhyempi kirjoitustapa
        map3 = new HashMap<>(map2);
        map3.putAll(map1);
        return map3;
    }

    /**
     * Increments all the values in the given map by the given amount. This method
     * should modify the given map, not create a new one.
     */
    // lähteet:
    // https://www.geeksforgeeks.org/java/hashmap-replaceallbifunction-method-in-java-with-examples/
    public void incrementValues(Map<String, Integer> map, int amount) {
        map.replaceAll((k, v) -> v + amount);
    
    }
}
