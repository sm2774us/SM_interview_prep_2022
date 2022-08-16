package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: Stack & Queue Solutions
 *
 *   This file contains the test cases for the Stack & Queue exercises in the
 *   DS & Algos Primer. If you have not already attempted these exercises, we
 *   highly recommend you complete them before reviewing the solutions here.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class StackAndQueueSolutionsTest {

    @Test
    public void stackImplementation() {
        StackAndQueueSolutions.MyStack s = new StackAndQueueSolutions.MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.pop());
        s.push(4);
        assertEquals(4, s.pop());
        assertEquals(2, s.pop());
        assertEquals(1, s.size());
    }

    @Test
    public void queueImplementation() {
        StackAndQueueSolutions.MyQueue q = new StackAndQueueSolutions.MyQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        q.enqueue(4);
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertEquals(1, q.size());
    }

    @Test
    public void nthElementInStack() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 5; i > 0; i--) stack.push(i);
        assertEquals(2, StackAndQueueSolutions.nthElementInStack(stack, 2));
    }

    /**
     * INFO: 3 Aug 01, 2022 10:09:11 PM
     * com.github.interview_prep.ds_algo_primer.solutions.StackAndQueueSolutions main INFO: 2 Aug
     * 01, 2022 10:09:12 PM
     * com.github.interview_prep.ds_algo_primer.solutions.StackAndQueueSolutions main INFO: true Aug
     * 01, 2022 10:09:12 PM
     * com.github.interview_prep.ds_algo_primer.solutions.StackAndQueueSolutions main INFO: 11
     */
    @Test
    public void stackFromQueueImplementation() {
        StackAndQueueSolutions.StackFromQueues sfq = new StackAndQueueSolutions.StackFromQueues();
        sfq.push(1);
        sfq.push(2);
        sfq.push(3);
        assertEquals(3, sfq.pop());
        assertEquals(2, sfq.top());
    }

    @Test
    public void validParentheses() {
        assertEquals(true, StackAndQueueSolutions.validParentheses("([]{}(()))"));
    }

    @Test
    public void basicCalculator() {
        assertEquals(11, StackAndQueueSolutions.basicCalculator("12 - (2 + 3) + 4"));
    }
}
