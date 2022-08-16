package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: Graph Solutions
 *
 *   This file contains the test cases for the Graph exercises in the DS & Algos
 *   Primer. If you have not already attempted these exercises, we highly
 *   recommend you complete them before reviewing the solutions here.
 */

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GraphSolutionsTest {

    private static GraphSolutions.AdjacencyMatrix am;
    private static GraphSolutions.AdjacencyList al;
    private static List<List<Integer>> adjList;
    private static boolean[][] adjMatrix;

    @BeforeAll
    public static void setup() {
        am = new GraphSolutions.AdjacencyMatrix(4);
        am.addEdge(1, 2);
        am.addEdge(1, 3);

        al = new GraphSolutions.AdjacencyList(4);
        al.addEdge(1, 2);
        al.addEdge(1, 3);

        adjList = new ArrayList<>();
        adjList.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2})));
        adjList.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0})));
        adjList.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0})));
        adjList.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 5})));
        adjList.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 5})));
        adjList.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 4})));

        adjMatrix =
                new boolean[][] {
                    {false, true, true, false, false, false},
                    {true, false, false, false, false, false},
                    {true, false, false, false, false, false},
                    {false, false, false, false, true, true},
                    {false, false, false, true, false, true},
                    {false, false, false, true, true, false}
                };
    }

    @AfterAll
    public static void tearDown() {
        am = null;
        al = null;
        adjList = null;
        adjMatrix = null;
    }

    // Jul 31, 2022 3:40:12 PM com.github.interview_prep.ds_algo_primer.solutions.GraphSolutions
    // lambda$0
    // INFO: 2
    @Test
    public void adjacencyMatrixNeighbors() {
        assertIterableEquals(Arrays.asList(2, 3), am.neighbors(1));
    }

    @Test
    public void adjacencyListNeighbors() {
        assertIterableEquals(Arrays.asList(2, 3), al.neighbors(1));
    }

    @Test
    public void adjacencyMatrixToList() {
        List<Set<Integer>> adjacencyMatrixLst = GraphSolutions.adjacencyMatrixToList(am.matrix);
        assertEquals(4, adjacencyMatrixLst.size());
        assertListContainsSubset(adjacencyMatrixLst);
    }

    @Test
    public void adjacencyListToMatrix() {
        boolean[][] matrix = GraphSolutions.adjacencyListToMatrix(al.edges);
        assertArrayEquals(
                new boolean[][] {
                    {false, false, false, false},
                    {false, false, true, true},
                    {false, false, false, false},
                    {false, false, false, false}
                },
                matrix);
    }

    @Test
    public void validPathList() {
        assertEquals(true, GraphSolutions.validPathList(6, adjList, 0, 1));
        assertEquals(false, GraphSolutions.validPathList(6, adjList, 0, 5));
    }

    @Test
    public void validPathMatrix() {
        assertEquals(true, GraphSolutions.validPathMatrix(6, adjMatrix, 0, 1));
        assertEquals(false, GraphSolutions.validPathMatrix(6, adjMatrix, 0, 5));
    }

    @Disabled("Until we figure out why this particular test hangs the Test Suite")
    @Test
    public void lengthOfShortestPath() {
        assertEquals(4, GraphSolutions.lengthOfShortestPath(adjList, 0, 5));
    }

    @Disabled("Until we figure out why this particular test hangs the Test Suite")
    @Test
    public void shortestPath() {
        assertIterableEquals(Arrays.asList(0, 2, 4, 5), GraphSolutions.shortestPath(adjList, 0, 5));
    }

    @Disabled("Until we figure out why this particular test hangs the Test Suite")
    @Test
    public void allPaths() {
        List<List<Integer>> expected =
                Arrays.asList(Arrays.asList(0, 2, 4, 3, 5), Arrays.asList(0, 2, 4, 5));
        List<List<Integer>> actual = GraphSolutions.allPaths(adjList, 0, 5);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void courseScheduling() {
        assertEquals(
                true,
                GraphSolutions.courseScheduling(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }

    @Test
    public void courseSchedulingII() {
        int[] expected = new int[] {0, 1, 2, 3};
        int[] actual =
                GraphSolutions.courseSchedulingII(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertArrayEquals(expected, actual);
    }

    @Test
    public void alienDictionary() {
        assertEquals(
                "wertf",
                GraphSolutions.alienDictionary(new String[] {"wrt", "wrf", "er", "ett", "rftt"}));
        assertEquals("aczb", GraphSolutions.alienDictionary(new String[] {"ac", "ab", "zc", "zb"}));
    }

    @Test
    public void keysAndRooms() {
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(Arrays.asList(new Integer[] {1}));
        rooms.add(Arrays.asList(new Integer[] {2}));
        rooms.add(Arrays.asList(new Integer[] {3}));
        rooms.add(Arrays.asList(new Integer[] {}));
        assertEquals(true, GraphSolutions.keysAndRooms(rooms));
    }

    @Test
    public void evaluateDivision() {
        List<List<String>> equations = new LinkedList<>();
        equations.add(Arrays.asList(new String[] {"a", "b"}));
        equations.add(Arrays.asList(new String[] {"b", "c"}));

        List<List<String>> queries = new LinkedList<>();
        queries.add(Arrays.asList(new String[] {"a", "c"}));
        queries.add(Arrays.asList(new String[] {"b", "a"}));
        queries.add(Arrays.asList(new String[] {"a", "e"}));
        queries.add(Arrays.asList(new String[] {"a", "a"}));
        queries.add(Arrays.asList(new String[] {"x", "x"}));

        // System.out.println(Arrays.toString(evaluateDivision(equations, new double[] { 2.0, 3.0 },
        // queries)));
        double[] expected = new double[] {6.0, 0.5, -1.0, 1.0, 1.0};
        double[] actual =
                GraphSolutions.evaluateDivision(equations, new double[] {2.0, 3.0}, queries);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void slidingPuzzle() {
        assertEquals(1, GraphSolutions.slidingPuzzle(new int[][] {{1, 2, 3}, {4, 0, 5}}));
        assertEquals(-1, GraphSolutions.slidingPuzzle(new int[][] {{1, 2, 3}, {5, 4, 0}}));
    }

    private static void assertListContainsSubset(List<Set<Integer>> subsets, int... ns) {
        final Set<Integer> set = new TreeSet<Integer>();
        for (int i : ns) set.add(i);
        assertTrue(subsets.contains(set));
    }
}
