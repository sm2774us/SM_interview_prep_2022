/*
 *   Title: ArraysAndStringsSolutions
 *
 *   This file contains the solutions for the Arrays and Strings exercises in
 *   the DS & Algos Primer. If you have not already attempted these exercises,
 *   we highly recommend you complete them before reviewing the solutions here.
 *
 *   Execution: javac ArraysAndStringsSolutions.java && java -ea ArraysAndStringsSolutions
 */

import java.util.*;

public class ArraysAndStringsSolutions {

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
        //Increment by 2 each time to visit only odd indices.
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
     * | sb0: |	0  |    | 4  |    | 8  |    | 12 |
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
     * | sb0: |	0  |    |    | 6  |    |    | 12 |
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
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    /*
     * Exercise 1.4: Given a 2D matrix, write a function to print the values
     * going back and forth across each row
     *
     * Time Complexity: O(arr.length * arr[0].length)
     * Space Complexity: O(1)
     */
    public static void printBackAndForth(int[][] arr) {
        // Iterate 2 rows at a time and go across and back
        for (int i = 0; i < arr.length; i = i+2) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }

            // If iterating across to the right was the last row, end, otherwise
            // iterate back across to the right
            if (i + 1 < arr.length) {                
                for (int j = arr[i + 1].length - 1; j >= 0; j--) {
                    System.out.println(arr[i+1][j]);
                }
            }
        }
    }

    /*
     * Exercise 1.5: Given a 2D matrix, write a function to print the values in
     * the matrix in a clockwise spiral from outside to inside
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static void printSpiral(int[][] arr) {
        // INSERT YOUR SOLUTION HERE
    }

    /*
     * Exercise 1.6: Given a 2D matrix, write a function to print the values in
     * the matrix in a zig-zag order
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static void printDiagonals(int[][] arr) {
        // INSERT YOUR SOLUTION HERE
    }

    /*
     * Exercise 2.1: Given a string, print out all of the substrings
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static void printSubstrings(String s) {
        // INSERT YOUR SOLUTION HERE
    }

    /*
     * Exercise 2.2: Write a function to find all duplicates in an array. The
     * array will contain exactly 1 duplicated value
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static int findDuplicates(int[] arr) {
        // INSERT YOUR SOLUTION HERE
        return 0;
    }

    /*
     * Exercise 2.3: Given a sorted array, find every pair of values in the
     * array that sum up to a given target
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static int[][] twoSum(int[] arr, int target) {
        // INSERT YOUR SOLUTION HERE
        return null;
    }

    /*
     * Exercise 3.1: Given two arrays, compare them to see if they are equal
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static boolean arraysAreEqual(int[] arr1, int[] arr2) {
        // INSERT YOUR SOLUTION HERE
        return false;
    }

    /*
     * Exercise 3.2: Given two strings, determine if one string is the reverse
     * of the other string
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static boolean stringsAreOpposite(String s1, String s2) {
        // INSERT YOUR SOLUTION HERE
        return false;
    }

    /*
     * Exercise 3.3: Given two strings, determine whether they are anagrams of
     * each other
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static boolean areAnagrams(String s1, String s2) {
        // INSERT YOUR SOLUTION HERE
        return false;
    }

    /*
     * Exercise 4.1: Given an array, compute the sum of each length-k subarray
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static int[] subarraySums(int[] arr, int k) {
        // INSERT YOUR SOLUTION HERE
        return null;
    }

    /*
     * Exercise 4.2: Given a string, find the longest substring of the string
     * that does not contain any repeated characters
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static int noRepeatedChars(String s) {
        // INSERT YOUR SOLUTION HERE
        return 0;
    }

    /*
     * Exercise 4.3: Given two strings, s and p, find all occurrences of
     * anagrams of p in s. The output is the starting index of each anagram
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static List<Integer> findAllAnagrams(String s, String p) {
        // INSERT YOUR SOLUTION HERE
        return null;
    }

    /*
     * Exercise 4.4: Given two strings, s and p, find the smallest substring of
     * s that contains all the characters in p
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static String smallestSubstring(String s, String p) {
        // INSERT YOUR SOLUTION HERE
        return null;
    }

    // Sample test cases
    public static void main(String[] args) {
        int[] toReverse = new int[] { 1, 2, 3, 4, 5 };
        reverseArray(toReverse);
        System.out.println(Arrays.toString(toReverse));

        System.out.println(removeEven("iloveinterviewprep"));

        System.out.println(zigZag("PAYPALISHIRING", 3));

        int[][] matrix = new int[4][5];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        printBackAndForth(matrix);
    }
}
