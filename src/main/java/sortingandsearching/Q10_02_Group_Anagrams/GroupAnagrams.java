package sortingandsearching.Q10_02_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(final String[] strings) {

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(final String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedstring = new String(chars);

            if (!map.containsKey(sortedstring)) {
                map.put(sortedstring, new ArrayList<String>());
            }
            map.get(sortedstring).add(s);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(final String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }

    public static void main(String args[]) {
        String[] s = {"dog", "elvis", "forest", "fortes", "foster", "goat", "god", "heros", "horse", "lives", "shore", "softer"};
        List<List<String>> result =  GroupAnagrams.groupAnagrams(s);
        for(List<String> list :result) {
            System.out.println(list);
        }
    }
}
