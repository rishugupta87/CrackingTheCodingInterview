package recursiondynamicprogramming.Q8_04_Power_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method to return all subsets of a set.
 */
public class SubsetsOfSet {

    public static void main(String[] args) {
        final List<List<Integer>> allSubsets = powerSet(Arrays.asList(1, 2, 3));
        for (List<Integer> subsets : allSubsets) {
            System.out.println(subsets);
        }
    }

    /**
     *
     will give you an example to explain how the algorithm works for the powerset of {1, 2, 3}:

     Remove {1}, and execute powerset for {2, 3};
     Remove {2}, and execute powerset for {3};
     Remove {3}, and execute powerset for {};
     Powerset of {} is {{}};

     Powerset of {3} is 3 combined with {{}} = { {}, {3} };
     Powerset of {2, 3} is {2} combined with { {}, {3} } = { {}, {3}, {2}, {2, 3} };
     Powerset of {1, 2, 3} is {1} combined with { {}, {3}, {2}, {2, 3} } = { {}, {3}, {2}, {2, 3}, {1}, {3, 1}, {2, 1}, {2, 3, 1} }.

     Note no of sets for n elements = 2^n

     Time complexity: O(n*2^n)

     * @param values
     * @return
     */
    private static List<List<Integer>> powerSet(final List<Integer> values) {
        if (values.isEmpty()) {
            List<List<Integer>> returnList = new ArrayList<>();
            returnList.add(new ArrayList<>());
            return returnList;
        }
        List<List<Integer>> subsetList = powerSet(values.subList(1, values.size())); //remove first item and pass remaining list
        int val = values.get(0); //element to be appended

        List<List<Integer>> returnList = new ArrayList<>();
        returnList.addAll(subsetList); //add previous subset

        List<List<Integer>> newList = new ArrayList<>();

        for (final List<Integer> subset1 : subsetList) {
            List<Integer> list = new ArrayList<>(); //new list will contain the element to be appended + items in original sublist
            list.add(val);
            list.addAll(subset1); //items in original sublist
            newList.add(list); //new List to consolidate these modified lists
        }

        returnList.addAll(newList); //consolidated list added to the final list.

        return returnList;
    }

    private static List<List<String>> powerSet2(final List<Integer> values) {
        if (values.isEmpty()) {
            List<List<String>> returnList = new ArrayList<>();
            returnList.add(new ArrayList<>());
            return returnList;
        }
        List<List<String>> subset = powerSet2(values.subList(1, values.size()));
        int val = values.get(0);

        List<List<String>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(String.valueOf(val)));
        returnList.addAll(subset);
        for (final List<String> subsetValues : subset) {
            for (final String subsetValue : subsetValues) {
                returnList.add(Arrays.asList(val + "," + subsetValue));
            }
        }
        return returnList;
    }
}
