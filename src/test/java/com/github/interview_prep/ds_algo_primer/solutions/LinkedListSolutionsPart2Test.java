package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: LinkedListSolutionsPart2Test
 *
 *   This file contains the test cases for Exercise Sets #2-5 of the Linked List
 *   exercises in the DS & Algos Primer. If you have not already attempted these
 *   exercises, we highly recommend you complete them before reviewing the
 *   solutions here.
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinkedListSolutionsPart2Test {

    @Test
    public void swapNodes() {
        LinkedListSolutionsPart2.DoublyLinkedListNode d =
                LinkedListSolutionsPart2.doubleGenerator(8);
        assertEquals(
                "null <- 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7 <-> 8 -> null",
                LinkedListSolutionsPart2.printDouble(d));
        LinkedListSolutionsPart2.swapNodes(d, 2, 6);
        assertEquals(
                "null <- 1 <-> 2 <-> 7 <-> 4 <-> 5 <-> 6 <-> 3 <-> 8 -> null",
                LinkedListSolutionsPart2.printDouble(d));
        LinkedListSolutionsPart2.swapNodes(d, 1, 7);
        assertEquals(
                "null <- 1 <-> 8 <-> 7 <-> 4 <-> 5 <-> 6 <-> 3 <-> 2 -> null",
                LinkedListSolutionsPart2.printDouble(d));
        LinkedListSolutionsPart2.swapNodes(d, 1, 2);
        assertEquals(
                "null <- 1 <-> 7 <-> 8 <-> 4 <-> 5 <-> 6 <-> 3 <-> 2 -> null",
                LinkedListSolutionsPart2.printDouble(d));
    }

    @Test
    public void removeOdd() {
        LinkedListSolutionsPart2.SinglyLinkedListNode l =
                LinkedListSolutionsPart2.singleGenerator(4);
        LinkedListSolutionsPart2.removeOdd(l);
        assertEquals("1 -> 3 -> null", LinkedListSolutionsPart2.printSingle(l));
    }

    @Test
    public void deinterleave() {
        LinkedListSolutionsPart2.SinglyLinkedListNode l =
                LinkedListSolutionsPart2.singleGenerator(9);
        LinkedListSolutionsPart2.deinterleave(l);
        assertEquals(
                "1 -> 3 -> 5 -> 7 -> 9 -> 2 -> 4 -> 6 -> 8 -> null",
                LinkedListSolutionsPart2.printSingle(l));
    }

    @Test
    public void reverse() {
        LinkedListSolutionsPart2.SinglyLinkedListNode l =
                LinkedListSolutionsPart2.singleGenerator(5);
        assertEquals(
                "5 -> 4 -> 3 -> 2 -> 1 -> null",
                LinkedListSolutionsPart2.printSingle(LinkedListSolutionsPart2.reverse(l)));
    }

    @Test
    public void areEqual() {
        assertEquals(
                true,
                LinkedListSolutionsPart2.areEqual(
                        LinkedListSolutionsPart2.singleGenerator(5),
                        LinkedListSolutionsPart2.singleGenerator(5)));
    }

    @Test
    public void nthToLast() {
        assertEquals(
                4,
                LinkedListSolutionsPart2.nthToLast(LinkedListSolutionsPart2.singleGenerator(5), 2)
                        .val);
    }

    @Test
    public void midpoint() {
        assertEquals(
                3,
                LinkedListSolutionsPart2.midpoint(LinkedListSolutionsPart2.singleGenerator(5)).val);
    }

    @Test
    public void removeAll() {
        LinkedListSolutionsPart2.SinglyLinkedListNode l =
                new LinkedListSolutionsPart2.SinglyLinkedListNode(1);
        l.next = new LinkedListSolutionsPart2.SinglyLinkedListNode(1);
        l.next.next = new LinkedListSolutionsPart2.SinglyLinkedListNode(2);
        l.next.next.next = new LinkedListSolutionsPart2.SinglyLinkedListNode(3);
        l.next.next.next.next = new LinkedListSolutionsPart2.SinglyLinkedListNode(1);
        assertEquals(
                "2 -> 3 -> null",
                LinkedListSolutionsPart2.printSingle(LinkedListSolutionsPart2.removeAll(l, 1)));
    }

    @Test
    public void hasCycleNaive() {
        LinkedListSolutionsPart2.SinglyLinkedListNode l =
                LinkedListSolutionsPart2.singleGenerator(5);
        l.next.next.next.next.next = l.next.next;
        assertEquals(true, LinkedListSolutionsPart2.hasCycleNaive(l));
    }

    @Test
    public void hasCycle() {
        LinkedListSolutionsPart2.SinglyLinkedListNode l =
                LinkedListSolutionsPart2.singleGenerator(5);
        l.next.next.next.next.next = l.next.next;
        assertEquals(true, LinkedListSolutionsPart2.hasCycle(l));
    }
}
