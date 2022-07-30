package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: ArraysAndStringsSolutionsTest
 *
 *   This file contains the test cases for the solutions for the Arrays and Strings exercises in
 *   the DS & Algos Primer. If you have not already attempted these exercises,
 *   we highly recommend you complete them before reviewing the solutions here.
 *
 */

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ArraysAndStringsSolutions {

    /*
     * Exercise 1.1: Write a function that takes an integer array and reverses
     * the values in place
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    @Test
    public void reverseArray() {
        assertThat(ArraysAndStringsSolutions.reverseArray(new int[] { 1, 2, 3, 4, 5 }), equalTo(new int[] { 5, 4, 3, 2, 1 }));
    }

    /*
     * Exercise 1.2: Write a function that takes in a string and removes every
     * even-indexed character
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(s.length())
     */
    @Test
    public void removeEven() {
        assertThat(ArraysAndStringsSolutions.removeEven("iloveinterviewprep"), equalTo("ioenevepe"));
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
    @Test
    public void zigZag() {
        assertThat(ArraysAndStringsSolutions.zigZag("PAYPALISHIRING"), equalTo("PAHNAPLSIIGYIR"));
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
    @Test
    public void printBackAndForth() {
		int[20] result
		int[][] matrix = new int[4][5];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }
        assertThat(ArraysAndStringsSolutions.printBackAndForth(matrix), equalTo(new int[] { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6, 11, 12, 13, 14, 15, 20, 19, 18, 17, 16 }));
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
    @Test
    public void printSpiral() {
		int[20] result
		int[][] matrix = new int[4][5];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }
        assertThat(ArraysAndStringsSolutions.printSpiral(matrix), equalTo(new int[] { 1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12 }));
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
    @Test
    public void printDiagonals() {
		int[20] result
		int[][] matrix = new int[4][5];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }
        assertThat(ArraysAndStringsSolutions.printDiagonals(matrix), equalTo(new int[] { 1, 2, 6, 11, 7, 3, 4, 8, 12, 16, 17, 13, 9, 5, 10, 14, 18, 19, 15, 20 }));
    }

    /*
     * Exercise 2.1: Given a string, print out all of the substrings
     *
     * Time Complexity: O(s.length()^2)
     * Space Complexity: O(1)
     */
    @Test
    public void printSubstrings() {
        assertThat(ArraysAndStringsSolutions.printSubstrings("abc"), equalTo(Arrays.asList("a", "ab", "abc", "b", "bc", "c")));
    }

    /*
     * Exercise 2.2: Write a function to find all duplicates in an array. The
     * array will contain exactly 1 duplicated value
     *
     * Time Complexity: O(arr.length^2)
     * Space Complexity: O(1)
     */
    @Test
    public void findDuplicates() {
        assertThat(ArraysAndStringsSolutions.reverseArray(new int[] { 1, 2, 3, 2 }), equalTo(2));
    }

    /*
     * Exercise 2.3: Given a sorted array, find every pair of values in the
     * array that sum up to a given target
     *
     * Time Complexity: O(arr.length)
     * Space Complexity: O(1)
     */
    @Test
    public void twoSum() {		
        assertThat(ArraysAndStringsSolutions.twoSum(new int[] {1, 2, 3, 4, 5}, 5), equalTo(new int[][]{ { 1, 4 }, { 2, 3 } }));
    }
    
        /*
     * Exercise 2.3: Given a sorted array, find every pair of values in the
     * array that sum up to a given target
     *
     * Time Complexity: O(arr.length)
     * Space Complexity: O(1)
     */
    @Test
    public void twoSumLst() {
        List<int[]> result = new ArrayList<>() {{
            add(new int[] { 1, 4 });
            add(new int[] { 2, 3 });
        }};
        assertThat(ArraysAndStringsSolutions.twoSumLst(new int[] {1, 2, 3, 4, 5}, 5), equalTo(result));
    }

    /*
     * Exercise 3.1: Given two arrays, compare them to see if they are equal
     *
     * Time Complexity: O(arr1.length)
     * Space Complexity: O(1)
     */
    @Test
    public void arraysAreEqual() {
        assertThat(ArraysAndStringsSolutions.arraysAreEqual(new int[] {1, 2, 3}, new int[] {1, 2, 3}), equalTo(true));
        assertThat(ArraysAndStringsSolutions.arraysAreEqual(new int[] {3, 2, 1}, new int[] {1, 2, 3}), equalTo(false));
    }

    /*
     * Exercise 3.2: Given two strings, determine if one string is the reverse
     * of the other string
     *
     * Time Complexity: O(s1.length())
     * Space Complexity: O(1)
     */
    @Test
    public void stringsAreOpposite() {
        assertThat(ArraysAndStringsSolutions.stringsAreOpposite("abcd", "dcba"), equalTo(true));
        assertThat(ArraysAndStringsSolutions.stringsAreOpposite("abc", "dbc"), equalTo(false));
    }

    /*
     * Exercise 3.3: Given two strings, determine whether they are anagrams of
     * each other
     *
     * Time Complexity: O(s1.length())
     * Space Complexity: O(s1.length())
     */
    @Test
    public void areAnagrams() {
        assertThat(ArraysAndStringsSolutions.areAnagrams("abcd", "dcba"), equalTo(true));
        assertThat(ArraysAndStringsSolutions.areAnagrams("abc", "bac"), equalTo(true));
        assertThat(ArraysAndStringsSolutions.areAnagrams("abc", "dbc"), equalTo(false));
    }

    /*
     * Exercise 4.1: Given an array, compute the sum of each length-k subarray
     *
     * Time Complexity: O(arr.length)
     * Space Complexity: O(1)
     */
    @Test
    public void subarraySums() {
        assertThat(ArraysAndStringsSolutions.subarraySums(new int[] {1, 2, 3, 4, 5}, 3), equalTo(new int[]{ 6, 9, 12 }));
    }


    /*
     * Exercise 4.2: Given a string, find the longest substring of the string
     * that does not contain any repeated characters
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(1)
     */
    @Test
    public void noRepeatedChars() {
        assertThat(ArraysAndStringsSolutions.noRepeatedChars("abcdbaba"), equalTo(4));
    }

    /*
     * Exercise 4.3: Given two strings, s and p, find all occurrences of
     * anagrams of p in s. The output is the starting index of each anagram
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(1)
     */
    @Test
    public void findAllAnagrams() {
        assertThat(ArraysAndStringsSolutions.findAllAnagrams("abcbcba", "abc"), equalTo(new int[]{ 0, 4 }));
    }

    /*
     * Exercise 4.4: Given two strings, s and p, find the smallest substring of
     * s that contains all the characters in p
     *
     * Time Complexity: O(s.length())
     * Space Complexity: O(1)
     */
    @Test
    public void smallestSubstring() {
        assertThat(ArraysAndStringsSolutions.findAllAnagrams("aabbccdd", "abc"), equalTo("abbc"));
    }
}
