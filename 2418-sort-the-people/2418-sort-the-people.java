import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create an array of pairs (name, height)
        int n = names.length;
        String[][] people = new String[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = names[i];
            people[i][1] = Integer.toString(heights[i]);
        }

        // Sort the array based on heights in descending order
        Arrays.sort(people, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1]));
            }
        });

        // Extract the sorted names
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i][0];
        }

        return sortedNames;
    }
}
