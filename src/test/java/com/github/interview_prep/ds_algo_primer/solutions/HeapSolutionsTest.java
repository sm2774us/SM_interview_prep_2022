package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: HeapSolutions.java
 *
 *   This file contains the test cases for Exercise Sets of the Heap
 *   exercises in the DS & Algos Primer. If you have not already attempted these
 *   exercises, we highly recommend you complete them before reviewing the
 *   solutions here.
 */
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HeapSolutionsTest {

    @Test
    public void minHeapImplementation() {
        HeapSolutions.MinHeap m = new HeapSolutions.MinHeap();
        m.insert(5);
        m.insert(2);
        m.insert(1);
        m.insert(-1);
        assertEquals("[-1, 1, 2, 5]", m.toString());

        assertEquals(-1, m.pop());

        assertEquals("[1, 5, 2]", m.toString());

        m.insert(6);
        m.insert(3);
    }

    @Test
    public void isValid() {
        assertEquals(false, HeapSolutions.isValid(new int[] {1, 3, 2, 4, 6, 5, 0}));
        assertEquals(true, HeapSolutions.isValid(new int[] {1, 3, 2, 6, 5}));
    }

    @Test
    public void findMax() {
        assertEquals(6, HeapSolutions.findMax(new int[] {1, 3, 2, 4, 6, 5, 0}));
    }

    @Test
    public void heapSort() {
        assertArrayEquals(
                new int[] {0, 1, 2, 3, 4, 5, 6},
                HeapSolutions.heapSort(new int[] {1, 3, 2, 4, 6, 5, 0}));
    }

    @Test
    public void kthLargestImplementation() {
        HeapSolutions.KthLargest kth = new HeapSolutions.KthLargest(3, new int[] {4, 5, 8, 2});
        // System.out.println(kth.add(3));
        assertEquals(4, kth.add(3));
        // System.out.println(kth.add(5));
        assertEquals(5, kth.add(5));
        // System.out.println(kth.add(10));
        assertEquals(5, kth.add(10));
        // System.out.println(kth.add(9));
        assertEquals(8, kth.add(9));
    }

    @Test
    public void kClosest() {
        int[][] points = new int[][] {new int[] {3, 3}, new int[] {5, -1}, new int[] {-2, 4}};
        assertArrayEquals(new int[][] {{-2, 4}, {3, 3}}, HeapSolutions.kClosest(points, 2));
    }

    @Test
    public void medianFinderImplementation() {
        HeapSolutions.MedianFinder mf = new HeapSolutions.MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        assertEquals(1.5d, mf.findMedian());
        mf.addNum(3);
        assertEquals(2.0d, mf.findMedian());

        mf = new HeapSolutions.MedianFinder();
        mf.addNum(-1);
        assertEquals(-1.0d, mf.findMedian());
        mf.addNum(-2);
        assertEquals(-1.5d, mf.findMedian());
        mf.addNum(-3);
        assertEquals(-2.0d, mf.findMedian());
        mf.addNum(-4);
        assertEquals(-2.5d, mf.findMedian());
        mf.addNum(-4);
        assertEquals(-3.0d, mf.findMedian());
    }

    @Test
    public void mergeKLists() {
        HeapSolutions.ListNode[] lists = new HeapSolutions.ListNode[3];
        lists[0] = new HeapSolutions.ListNode(1);
        lists[0].next = new HeapSolutions.ListNode(4);
        lists[0].next.next = new HeapSolutions.ListNode(5);
        lists[1] = new HeapSolutions.ListNode(1);
        lists[1].next = new HeapSolutions.ListNode(3);
        lists[1].next.next = new HeapSolutions.ListNode(4);
        lists[2] = new HeapSolutions.ListNode(2);
        lists[2].next = new HeapSolutions.ListNode(6);
        HeapSolutions.ListNode head = HeapSolutions.mergeKLists(lists);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " -> ");
            head = head.next;
        }
        sb.append("null");
        assertEquals("1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null", sb.toString());
    }
}
