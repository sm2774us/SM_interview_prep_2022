package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: LinkedListSolutionsPart1Test
 *
 *   This file contains the test cases for Exercise Set #1 of the Linked List
 *   exercises in the DS & Algos Primer. If you have not already attempted these
 *   exercises, we highly recommend you complete them before reviewing the
 *   solutions here.
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinkedListSolutionsPart1Test {

    @Test
    public void singlyLinkedListImplementation() {
        LinkedListSolutionsPart1.SinglyLinkedList l =
                new LinkedListSolutionsPart1.SinglyLinkedList();
        for (int i = 6; i > 0; i--) l.insert(i);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null", l.toString());
        assertEquals(true, l.delete(1));
        assertEquals(true, l.delete(4));
        assertEquals("2 -> 3 -> 5 -> 6 -> null", l.toString());
        assertEquals(4, l.size());
    }

    @Test
    public void doublyLinkedListImplementation() {
        LinkedListSolutionsPart1.DoublyLinkedList d =
                new LinkedListSolutionsPart1.DoublyLinkedList();
        for (int i = 6; i > 0; i--) d.insert(i);
        assertEquals("null <- 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 -> null", d.toString());
        assertEquals(true, d.delete(1));
        assertEquals(true, d.delete(4));
        assertEquals("null <- 2 <-> 3 <-> 5 <-> 6 -> null", d.toString());
        assertEquals(4, d.size());
    }
}
