package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: ArraysAndStringsSolutions
 *
 *   This file contains the solutions for the Arrays and Strings exercises in
 *   the DS & Algos Primer. If you have not already attempted these exercises,
 *   we highly recommend you complete them before reviewing the solutions here.
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArraysAndStringsSolutions {

    private static final Logger LOGGER =
            Logger.getLogger(ArraysAndStringsSolutions.class.getName());

    /*
     * Exercise 1.1: Write a function that takes an integer array and reverses
     * the values in place
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static void reverseArray(int[] arr) {
        // handle null, empty and one element array
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            // swap numbers
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    /*
     * Exercise 1.2: Write a function that takes in a string and removes every
     * even-indexed character
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(s.length())
     */
    public static String removeEven(String s) {
        // handle null, empty and one element array
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        // Increment by 2 each time to visit only odd indices.
        for (int i = 0; i < s.length(); i = i + 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*
     * Exercises 1.3: Zig Zag Conversion
     * Full Problem Definition: https://leetcode.com/problems/zigzag-conversion/
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(s.length())
     *
     * Explaining to the interviewer:
     *
     * By observing the example, we can find the rule to rearrange the string.
     * Example1: s = "PAYPALISHIRING", numRows = 3
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PAHNAPLSIIGYIR"
     * Explanation:
     *
     * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     * | P | A | Y | P | A | L | I | S | H | I | R | I | N | G |
     * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     * | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 0 | 1 | 2 | 3 |
     * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     *
     * +---+---+---+---+---+---+---+
     * | P |   | A |   | H |   | N |
     * +---+---+---+---+---+---+---+
     * | A | P | L | S | I | I | G |
     * +---+---+---+---+---+---+---+
     * | Y |   | I |   | R |
     * +---+---+---+---+---+
     *
     * We need to rearrange the string in this way:
     *
     * +----+----+----+----+----+----+----+
     * | 0  |    | 4  |    | 8  |    | 12 |
     * +----+----+----+----+----+----+----+
     * | 1  | 3  | 5  | 7  | 9  | 11 | 13 |
     * +----+----+----+----+----+----+----+
     * | 2  |    | 6  |    | 10 |    |    |
     * +----+----+----+----+----+----+----+
     *
     * So we can create an array of StringBuilder,
     * put the chars in the array vertically down and obliquely up. Like this:
     *
     * +------+----+----+----+----+----+----+----+
     * | sb0: | 0  |    | 4  |    | 8  |    | 12 |
     * +------+----+----+----+----+----+----+----+
     * | sb1: | 1  | 3  | 5  | 7  | 9  | 11 | 13 |
     * +------+----+----+----+----+----+----+----+
     * | sb2: | 2  |    | 6  |    | 10 |    |    |
     * +------+----+----+----+----+----+----+----+
     *
     * Example2:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     * | P | A | Y | P | A | L | I | S | H | I | R | I | N | G |
     * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     * | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 0 | 1 | 2 | 3 |
     * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+
     *
     * +---+---+---+---+---+---+---+
     * | P |   |   | I |   |   | N |
     * +---+---+---+---+---+---+---+
     * | A |   | L | S |   | I | G |
     * +---+---+---+---+---+---+---+
     * | Y | A |   | H | R |   |   |
     * +---+---+---+---+---+---+---+
     * | P |   |   | I |   |   |   |
     * +---+---+---+---+---+---+---+
     *
     * We need to rearrange the string in this way:
     *
     * +----+----+----+----+----+----+----+
     * | 0  |    |    | 6  |    |    | 12 |
     * +----+----+----+----+----+----+----+
     * | 1  |    | 5  | 7  |    | 11 | 13 |
     * +----+----+----+----+----+----+----+
     * | 2  | 4  |    | 8  | 10 |    |    |
     * +----+----+----+----+----+----+----+
     * | 3  |    |    | 9  |    |    |    |
     * +----+----+----+----+----+----+----+
     *
     * So we can create an array of StringBuilder,
     * put the chars in the array vertically down and obliquely up. Like this:
     *
     * +------+----+----+----+----+----+----+----+
     * | sb0: | 0  |    |    | 6  |    |    | 12 |
     * +------+----+----+----+----+----+----+----+
     * | sb1: | 1  |    | 5  | 7  |    | 11 | 13 |
     * +------+----+----+----+----+----+----+----+
     * | sb2: | 2  | 4  |    | 8  | 10 |    |    |
     * +------+----+----+----+----+----+----+----+
     * | sb3: | 3  |    |    | 9  |    |    |    |
     * +------+----+----+----+----+----+----+----+
     */
    public static String zigZag(String s, int numRows) {
        // INSERT YOUR SOLUTION HERE
        // We'll compute each row and then merge them all together at the end
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0;
        while (i < len) {
            // vertically down
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }
            // obliquely up
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }

    /*
     * Exercise 1.4: Given a 2D matrix, write a function to print the values
     * going back and forth across each row
     *
     * Time Complexity: O(arr.length * arr[0].length), or,
     *                  O(R*C) [ where R = number of rows,
     *                                 C = number of columns ]
     * Space Complexity: O(1)
     */
    public static int[] printBackAndForth(int[][] arr) {
        int[] result = new int[arr.length * arr[0].length];
        int counter = 0;
        // Iterate 2 rows at a time and go across and back
        for (int i = 0; i < arr.length; i = i + 2) {
            for (int j = 0; j < arr[i].length; j++) {
                // System.out.println(arr[i][j]);
                LOGGER.log(Level.INFO, String.valueOf(arr[i][j]));
                result[counter] = arr[i][j];
                counter++;
            }

            // If iterating across to the right was the last row, end, otherwise
            // iterate back across to the right
            if (i + 1 < arr.length) {
                for (int j = arr[i + 1].length - 1; j >= 0; j--) {
                    // System.out.println(arr[i+1][j]);
                    LOGGER.log(Level.INFO, String.valueOf(arr[i + 1][j]));
                    result[counter] = arr[i + 1][j];
                    counter++;
                }
            }
        }
        return result;
    }

    /*
     * Exercise 1.5: Given a 2D matrix, write a function to print the values in
     * the matrix in a clockwise spiral from outside to inside
     *
     * Time Complexity: O(arr.length * arr[0].length), or,
     *                  O(R*C) [ where R = number of rows,
     *                                 C = number of columns ]
     * Space Complexity: O(1)
     */
    public static int[] printSpiral(int[][] arr) {
        int[] result = new int[arr.length * arr[0].length];
        // We need to keep track of the boundaries of the current layer of the
        // spiral that we are traversing
        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;
        int counter = 0;

        // Once the mins and maxes converge, we are at the center of the spiral.
        // The spiral follows a fixed set of steps. We go left, down, right, up.
        // For each of these, we just interate to the bounds, so we express each
        // one explicitly.
        while (minRow < maxRow && minCol < maxCol) {
            // Go across the top
            for (int col = minCol; col <= maxCol; col++) {
                // System.out.println(arr[minRow][col]);
                LOGGER.log(Level.INFO, String.valueOf(arr[minRow][col]));
                result[counter] = arr[minRow][col];
                counter++;
            }
            minRow++;

            // Go down the right side
            for (int row = minRow; row <= maxRow; row++) {
                // System.out.println(arr[row][maxCol]);
                LOGGER.log(Level.INFO, String.valueOf(arr[row][maxCol]));
                result[counter] = arr[row][maxCol];
                counter++;
            }
            maxCol--;

            // Go across the bottom
            for (int col = maxCol; col >= minCol; col--) {
                // System.out.println(arr[maxRow][col]);
                LOGGER.log(Level.INFO, String.valueOf(arr[maxRow][col]));
                result[counter] = arr[maxRow][col];
                counter++;
            }
            maxRow--;

            // Go up the left side
            for (int row = maxRow; row >= minRow; row--) {
                // System.out.println(arr[row][minCol]);
                LOGGER.log(Level.INFO, String.valueOf(arr[row][minCol]));
                result[counter] = arr[row][minCol];
                counter++;
            }
            minCol++;
        }
        return result;
    }

    /*
     * Exercise 1.6: Given a 2D matrix, write a function to print the values in
     * the matrix in a zig-zag order
     *
     * Time Complexity: O(arr.length * arr[0].length), or,
     *                  O(R*C) [ where R = number of rows,
     *                                 C = number of columns ]
     * Space Complexity: O(1)
     */
    public static int[] printDiagonals(int[][] arr) {
        int[] result = new int[arr.length * arr[0].length];
        int counter = 0;
        int row = 0;
        int col = 0;

        // Like the spiral, we have clearly defined directions we need to go. In
        // this case we either go up to the right or down to the left. We define
        // each of these explicitly and just go back and forth between doing one
        // and the other
        while (true) {
            // Go up to the right
            while (row > 0 && col < arr[0].length - 1) {
                // System.out.println(arr[row][col]);
                LOGGER.log(Level.INFO, String.valueOf(arr[row][col]));
                result[counter] = arr[row][col];
                counter++;
                row--;
                col++;
            }
            // Without this we won't print the final value in the diagonal
            // System.out.println(arr[row][col]);
            LOGGER.log(Level.INFO, String.valueOf(arr[row][col]));
            result[counter] = arr[row][col];
            counter++;

            // Check whether we're at the bottom right corner
            if (row == arr.length - 1 && col == arr[0].length - 1) break;

            // We need to update our positiion differently depending on whether
            // we're still going along the top of the matrix or down the
            // righthand side
            else if (col + 1 < arr[0].length) col++;
            else row++;

            // Go down to the left
            while (row < arr.length - 1 && col > 0) {
                // System.out.println(arr[row][col]);
                LOGGER.log(Level.INFO, String.valueOf(arr[row][col]));
                result[counter] = arr[row][col];
                counter++;
                row++;
                col--;
            }
            // Without this we won't print the final value in the diagonal
            // System.out.println(arr[row][col]);
            LOGGER.log(Level.INFO, String.valueOf(arr[row][col]));
            result[counter] = arr[row][col];
            counter++;

            // Check whether we're at the bottom right corner
            if (row == arr.length - 1 && col == arr[0].length - 1) break;

            // Are we going along the lefthand side or the bottom?
            else if (row + 1 < arr.length) row++;
            else col++;
        }
        return result;
    }

    /*
     * Exercise 2.1: Given a string, print out all of the substrings
     *
     * Time Complexity: O(s.length()^2)
     * Space Complexity: O(1)
     */
    public static List<String> printSubstrings(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // System.out.println(s.substring(i,j));
                LOGGER.log(Level.INFO, s.substring(i, j));
                result.add(s.substring(i, j));
            }
        }
        return result;
    }

    /*
     * Exercise 2.2: Write a function to find all duplicates in an array. The
     * array will contain exactly 1 duplicated value
     *
     * Time Complexity: O(arr.length^2)
     * Space Complexity: O(1)
     */
    public static int findDuplicates(int[] arr) {
        // Use 2 pointers to compare each pair of values
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return arr[i];
            }
        }

        // We should never get here
        return -1;
    }

    /*
     * Exercise 2.3: Given a sorted array, find every pair of values in the
     * array that sum up to a given target
     *
     * Time Complexity: O(arr.length)
     * Space Complexity: O(1)
     */
    public static int[][] twoSum(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();

        // We start our pointers at the beginning and move towards the center
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            // If we found the target, we add it to the result. Then we either
            // increment i or decrement j. It doesn't matter which we do
            if (sum == target) {
                result.add(new int[] {arr[i], arr[j]});

                // We want to avoid including the same pair multiple times so we
                // skip the pointer ahead to the next unique value. Since our
                // array is sorted, we just keep incrementing until we see a
                // new value
                while (arr[i] == arr[i + 1]) i++;
                i++;
            }

            // We can find a larger sum by incrementing i. This makes the
            // smaller value in our pair larger so the sum is larger
            if (sum < target) i++;

            // If it's too big, we do the opposite by decrementing j
            if (sum > target) j--;
        }

        // return result;
        return result.toArray(new int[result.size()][]);
    }

    /*
     * Exercise 2.3: Given a sorted array, find every pair of values in the
     * array that sum up to a given target
     *
     * Time Complexity: O(arr.length)
     * Space Complexity: O(1)
     */
    public static List<int[]> twoSumLst(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();

        // We start our pointers at the beginning and move towards the center
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            // If we found the target, we add it to the result. Then we either
            // increment i or decrement j. It doesn't matter which we do
            if (sum == target) {
                result.add(new int[] {arr[i], arr[j]});

                // We want to avoid including the same pair multiple times so we
                // skip the pointer ahead to the next unique value. Since our
                // array is sorted, we just keep incrementing until we see a
                // new value
                while (arr[i] == arr[i + 1]) i++;
                i++;
            }

            // We can find a larger sum by incrementing i. This makes the
            // smaller value in our pair larger so the sum is larger
            if (sum < target) i++;

            // If it's too big, we do the opposite by decrementing j
            if (sum > target) j--;
        }

        return result;
    }

    /*
     * Exercise 3.1: Given two arrays, compare them to see if they are equal
     *
     * Time Complexity: O(arr1.length)
     * Space Complexity: O(1)
     */
    public static boolean arraysAreEqual(int[] arr1, int[] arr2) {
        // If they're not the same length they can't be equal
        if (arr1.length != arr2.length) return false;

        // Compare each value. If they're not equal then the arrays are unequal
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    /*
     * Exercise 3.2: Given two strings, determine if one string is the reverse
     * of the other string
     *
     * Time Complexity: O(s1.length())
     * Space Complexity: O(1)
     */
    public static boolean stringsAreOpposite(String s1, String s2) {
        // If they're not the same length they can't be opposites
        if (s1.length() != s2.length()) return false;

        // Compare the opposing characters in each string. We could also just
        // reverse one of the strings and compare them, but that takes extra
        // space whereas this does not
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(s2.length() - i - 1)) return false;
        }

        return true;
    }

    /*
     * Exercise 3.3: Given two strings, determine whether they are anagrams of
     * each other
     *
     * Time Complexity: O(s1.length())
     * Space Complexity: O(s1.length())
     */
    public static boolean areAnagrams(String s1, String s2) {
        // If they're not the same length they can't be anagrams
        if (s1.length() != s2.length()) return false;

        // Count the number of occurrences of each character in s1
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int count = 1;
            if (chars.containsKey(c)) {
                count = chars.get(c) + 1;
            }
            chars.put(c, count);
        }

        // Subtract the chars in s2 from the count. We should end up with 0 of
        // each character left over
        for (char c : s2.toCharArray()) {
            if (!chars.containsKey(c)) return false;
            int count = chars.get(c);
            if (count == 0) return false;
            chars.put(c, count - 1);
        }

        return true;
    }

    /*
     * Exercise 4.1: Given an array, compute the sum of each length-k subarray
     *
     * Time Complexity: O(arr.length)
     * Space Complexity: O(1)
     */
    public static int[] subarraySums(int[] arr, int k) {
        // The size of our result will be arr.length - k + 1
        int[] result = new int[arr.length - k + 1];

        // Compute the sum of the initial length-k subarray
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        result[0] = sum;

        // Use a sliding window to go through the remainder of the array without
        // recomputing the sum for every subarray
        int left = 0;
        int right = k - 1;
        while (right < arr.length - 1) {
            // The value at right+1 needs to be added to the sum and the value
            // at left needs to be subtracted
            sum += arr[++right];
            sum -= arr[left++];
            result[left] = sum;
        }

        return result;
    }

    /*
     * Exercise 4.2: Given a string, find the longest substring of the string
     * that does not contain any repeated characters
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(1)
     */
    public static int noRepeatedChars(String s) {
        // Track the characters in our current substring
        Set<Character> inSubstring = new HashSet<>();

        int maxSubstring = 0;
        int left = 0;
        int right = 0;

        // We expand right out as much as we can without getting duplicate
        // chars. If we end up with duplicates, we increment left to shrink the
        // substring until we no longer have duplicates
        while (right < s.length()) {
            // We have a duplicate character, so increment left until the
            // substring no longer contains duplicates
            while (inSubstring.contains(s.charAt(right))) {
                inSubstring.remove(s.charAt(left++));
            }

            // We have a valid substring so is it the longest one?
            maxSubstring = Math.max(maxSubstring, right - left + 1);

            // Try expanding the substring again
            inSubstring.add(s.charAt(right++));
        }

        return maxSubstring;
    }

    /*
     * Exercise 4.3: Given two strings, s and p, find all occurrences of
     * anagrams of p in s. The output is the starting index of each anagram
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(1)
     */
    public static List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Storing character counts. We can also use a HashMap like in the
        // solution for 3.3 but if we know that all of our characters are
        // English letters, this is easier for us to work with
        int[] chars = new int[256];
        for (char c : p.toCharArray()) chars[c]++;

        // Do our sliding window
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // Add in the right character to our current window. We account for
            // this by removing it from the character count we have for p
            char rightChar = s.charAt(right++);
            chars[rightChar]--;

            // If the value is negative, then we have too many of rightChar in
            // our substring so we need to make it smaller until we no longer
            // have too many of that character
            while (chars[rightChar] < 0) {
                chars[s.charAt(left)]++;
                left++;
            }

            // If we have the exact right number of occurrences of the character
            // AND the substring is the right length, then this is a valid
            // substring
            if (chars[rightChar] == 0 && right - left == p.length()) result.add(left);
        }

        return result;
    }

    /*
     * Exercise 4.4: Given two strings, s and p, find the smallest substring of
     * s that contains all the characters in p
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(1)
     */
    public static String smallestSubstring(String s, String p) {
        // Same as 4.3, we use an array to store character count
        int[] chars = new int[256];
        for (char c : p.toCharArray()) chars[c]++;

        int left = 0;
        int right = 0;

        // In addition to tracking left and right, we'll track the start and
        // length of the string, as well as the count of characters from p that
        // we have in our substring. The count allows us to quickly see whether
        // our substring includes all the characters in p or not
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            // This is basically opposite of 4.3 where we WANT all the values to
            // get to 0 or negative because we want the string to be inclusive
            // of all the characters in p
            char rightChar = s.charAt(right++);
            chars[rightChar]--;

            if (chars[rightChar] >= 0) {
                count++;
            }

            // If count == p.length we have a valid substring. In this case,
            // keep shrinking it as much as we can by incrementing left
            while (count == p.length()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }

                // If we have extra of a character, we don't decrement the count
                // until we have fewer occurrences of that char than there are
                // in p
                if (++chars[s.charAt(left)] > 0) count--;
                left++;
            }
        }

        // If we don't find a valid substring, return ""
        if (minLength > s.length()) return "";

        return s.substring(minStart, minStart + minLength);
    }

    // Sample test cases
    public static void main(String[] args) {
        int[] toReverse = new int[] {1, 2, 3, 4, 5};
        reverseArray(toReverse);
        // System.out.println(Arrays.toString(toReverse));
        LOGGER.log(Level.INFO, Arrays.toString(toReverse));

        // System.out.println(removeEven("iloveinterviewprep"));
        LOGGER.log(Level.INFO, removeEven("iloveinterviewprep"));

        // System.out.println(zigZag("PAYPALISHIRING", 3));
        LOGGER.log(Level.INFO, zigZag("PAYPALISHIRING", 3));

        int[][] matrix = new int[4][5];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }

        // System.out.println(Arrays.deepToString(matrix));
        LOGGER.log(Level.INFO, Arrays.deepToString(matrix));

        printBackAndForth(matrix);

        // System.out.println(Arrays.deepToString(matrix));
        LOGGER.log(Level.INFO, Arrays.deepToString(matrix));

        printSpiral(matrix);

        // System.out.println(Arrays.deepToString(matrix));
        LOGGER.log(Level.INFO, Arrays.deepToString(matrix));

        printDiagonals(matrix);

        // printSubstrings("abc");
        // printSubstrings("abcd");
        LOGGER.log(Level.INFO, Arrays.deepToString(matrix));
        printSubstrings("abcd").forEach(s -> LOGGER.log(Level.INFO, s));

        // System.out.println(findDuplicates(new int[] { 1, 2, 3, 2, 4 }));
        LOGGER.log(Level.INFO, String.valueOf(findDuplicates(new int[] {1, 2, 3, 2, 4})));

        int[] arr = new int[] {1, 2, 2, 2, 3, 4, 5, 6, 6, 6};
        // System.out.println(Arrays.deepToString(twoSum(arr, 8)));
        LOGGER.log(Level.INFO, Arrays.deepToString(twoSum(arr, 8)));
        List<int[]> twoSum = twoSumLst(arr, 8);
        for (int[] a : twoSum) {
            // System.out.println(Arrays.toString(a));
            LOGGER.log(Level.INFO, Arrays.toString(a));
        }

        // System.out.println(arraysAreEqual(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));
        LOGGER.log(
                Level.INFO,
                String.valueOf(arraysAreEqual(new int[] {1, 2, 3}, new int[] {1, 2, 3})));

        // System.out.println(stringsAreOpposite("abcde", "edcba"));
        LOGGER.log(Level.INFO, String.valueOf(stringsAreOpposite("abcde", "edcba")));

        // System.out.println(areAnagrams("ababc", "cbaab"));
        LOGGER.log(Level.INFO, String.valueOf(areAnagrams("ababc", "cbaab")));

        // System.out.println(Arrays.toString(subarraySums(new int[] { 1, 2, 3, 4, 5 }, 3)));
        LOGGER.log(Level.INFO, Arrays.toString(subarraySums(new int[] {1, 2, 3, 4, 5}, 3)));

        // System.out.println(noRepeatedChars("abcbabcd"));
        LOGGER.log(Level.INFO, String.valueOf(noRepeatedChars("abcbabcd")));

        // System.out.println(findAllAnagrams("cbaebabacd", "abc"));
        findAllAnagrams("cbaebabacd", "abc")
                .forEach(i -> LOGGER.log(Level.INFO, String.valueOf(i)));

        // System.out.println(smallestSubstring("aabbccdd", "abc"));
        LOGGER.log(Level.INFO, smallestSubstring("aabbccdd", "abc"));
    }
}
