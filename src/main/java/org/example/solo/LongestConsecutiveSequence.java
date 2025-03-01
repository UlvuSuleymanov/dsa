package org.example.solo;


import java.util.Set;

public class LongestConsecutiveSequence {
    /*
    Input: nums = [14,76,43,77,87,334,78,434,79]
    Output: 4
    Explanation: Longest sequence: **[76, 77, 78, 79]** (length: 4).
    */
    private static final Set<Integer> numberSet = Set.of(14, 76, 43, 77, 87, 334, 78, 434, 79);

    public static void main(String[] args) {
        int max = 0;
        int subMax = 0;
        for (int i = 0; i < 1000; i++) {
            if (numberSet.contains(i)) {
                subMax=subMax+1;
            }
            else {
              max = Math.max(max, subMax);
              subMax=0;
            }
        }
        System.out.println(max);
    }
}
