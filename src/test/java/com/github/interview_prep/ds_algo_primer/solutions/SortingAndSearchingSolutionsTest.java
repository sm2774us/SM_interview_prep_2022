package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: SortingAndSearchingSolutions
 *
 *   This file contains the test cases for the Sorting and Searching exercises in
 *   the DS & Algos Primer. If you have not already attempted these exercises,
 *   we highly recommend you complete them before reviewing the solutions here.
 */
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SortingAndSearchingSolutionsTest {

    @Test
    public void binarySearch() {
        assertEquals(4, SortingAndSearchingSolutions.binarySearch(new int[] {1, 2, 3, 4, 5, 6}, 5));
    }

    @Test
    public void closestNumber() {
        assertEquals(
                1, SortingAndSearchingSolutions.closestNumber(new int[] {1, 2, 3, 4, 5, 6}, 0));
        assertEquals(2, SortingAndSearchingSolutions.closestNumber(new int[] {1, 2, 5, 6}, 3));
        assertEquals(1, SortingAndSearchingSolutions.closestNumber(new int[] {1, 6}, 3));
    }

    @Test
    public void searchRotatedArray() {
        assertEquals(
                4,
                SortingAndSearchingSolutions.searchRotatedArray(
                        new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(
                -1,
                SortingAndSearchingSolutions.searchRotatedArray(
                        new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    public void mergeSort() {
        int[] arr = new int[] {1, 5, 3, 3, 7, 6, 9, 1};
        SortingAndSearchingSolutions.mergeSort(arr);
        assertArrayEquals(new int[] {1, 1, 3, 3, 5, 6, 7, 9}, arr);
    }

    @Test
    public void quickSort() {
        int[] arr = new int[] {1, 5, 3, 3, 7, 6, 9, 1};
        SortingAndSearchingSolutions.quickSort(arr);
        assertArrayEquals(new int[] {1, 1, 3, 3, 5, 6, 7, 9}, arr);
    }

    @Test
    public void sortList() {
        SortingAndSearchingSolutions.ListNode l = new SortingAndSearchingSolutions.ListNode(5);
        l.next = new SortingAndSearchingSolutions.ListNode(2);
        l.next.next = new SortingAndSearchingSolutions.ListNode(3);
        l.next.next.next = new SortingAndSearchingSolutions.ListNode(7);
        l = SortingAndSearchingSolutions.sortList(l);
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            sb.append(String.valueOf(l.val) + " -> ");
            l = l.next;
        }
        sb.append("null");
        assertEquals("2 -> 3 -> 5 -> 7 -> null", sb.toString());
    }

    @Test
    public void largestNumber() {
        assertEquals(
                "9534330", SortingAndSearchingSolutions.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }

    @Test
    public void squareRoot() {
        assertEquals(2, SortingAndSearchingSolutions.squareRoot(4));
        assertEquals(2, SortingAndSearchingSolutions.squareRoot(8));
    }

    @Test
    public void splitLargest() {
        assertEquals(18, SortingAndSearchingSolutions.splitLargest(new int[] {7, 2, 5, 10, 8}, 2));
    }
}
