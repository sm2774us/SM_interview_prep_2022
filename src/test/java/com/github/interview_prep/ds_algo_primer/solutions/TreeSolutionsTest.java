package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: TreeSolutions
 *
 *   This file contains the test cases for the Tree exercises in the DS & Algos
 *   Primer. If you have not already attempted these exercises, we highly
 *   recommend you complete them before reviewing the solutions here.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TreeSolutionsTest {

    private static TreeSolutions.TreeNode root;

    @BeforeAll
    public static void setup() {
        root = new TreeSolutions.TreeNode(5);
        root.left = new TreeSolutions.TreeNode(3);
        root.left.left = new TreeSolutions.TreeNode(1);
        root.left.right = new TreeSolutions.TreeNode(4);
        root.right = new TreeSolutions.TreeNode(8);
        root.right.left = new TreeSolutions.TreeNode(7);
        root.right.right = new TreeSolutions.TreeNode(9);
    }

    @AfterAll
    public static void tearDown() {
        root = null;
    }

    @Test
    public void binarySearchTreeImplementation() {
        TreeSolutions.BinarySearchTree t = new TreeSolutions.BinarySearchTree();
        t.insert(5);
        t.insert(2);
        t.insert(7);
        t.insert(1);
        t.insert(6);
        assertEquals("1 2 5 6 7", t.toString().trim());
        assertEquals(true, t.contains(2));
        t.delete(5);
        assertEquals("1 2 6 7", t.toString().trim());
        String ser = TreeSolutions.BinarySearchTree.serialize(t);
        assertEquals("6 2 1 null null null 7 null null", ser.trim());
        assertEquals("1 2 6 7", TreeSolutions.BinarySearchTree.deserialize(ser).toString().trim());
    }

    @Test
    public void trieImplementation() {
        TreeSolutions.Trie s = new TreeSolutions.Trie();
        s.insert("test");
        s.insert("tester");
        s.insert("rest");
        assertEquals("rest test tester", s.toString());
        assertEquals(true, s.contains("test"));
        assertEquals(false, s.contains("teste"));
        assertIterableEquals(Arrays.asList("test", "tester"), s.prefix("test"));
    }

    @Test
    public void inOrderTraversalRecursive() {
        assertIterableEquals(
                Arrays.asList(1, 3, 4, 5, 7, 8, 9), TreeSolutions.inOrderTraversalRecursive(root));
    }

    @Test
    public void inOrderTraversalIterative() {
        assertIterableEquals(
                Arrays.asList(1, 3, 4, 5, 7, 8, 9), TreeSolutions.inOrderTraversalIterative(root));
    }

    @Test
    public void preOrderTraversalRecursive() {
        assertIterableEquals(
                Arrays.asList(5, 3, 1, 4, 8, 7, 9), TreeSolutions.preOrderTraversalRecursive(root));
    }

    @Test
    public void preOrderTraversalIterative() {
        assertIterableEquals(
                Arrays.asList(5, 3, 1, 4, 8, 7, 9), TreeSolutions.preOrderTraversalIterative(root));
    }

    @Test
    public void postOrderTraversalRecursive() {
        assertIterableEquals(
                Arrays.asList(1, 4, 3, 7, 9, 8, 5),
                TreeSolutions.postOrderTraversalRecursive(root));
    }

    @Test
    public void postOrderTraversalIterative() {
        assertIterableEquals(
                Arrays.asList(1, 4, 3, 7, 9, 8, 5),
                TreeSolutions.postOrderTraversalIterative(root));
    }

    @Test
    public void levelOrderTraversalRecursive() {
        assertIterableEquals(
                Arrays.asList(5, 3, 8, 1, 4, 7, 9),
                TreeSolutions.levelOrderTraversalRecursive(root));
    }

    @Test
    public void levelOrderTraversalIterative() {
        assertIterableEquals(
                Arrays.asList(5, 3, 8, 1, 4, 7, 9),
                TreeSolutions.levelOrderTraversalIterative(root));
    }

    @Test
    public void containsValue() {
        assertEquals(true, TreeSolutions.containsValue(root, 4));
    }

    @Test
    public void pathToNode() {
        assertIterableEquals(Arrays.asList(5, 3, 4), TreeSolutions.pathToNode(root, 4));
    }

    @Test
    public void maxDepth() {
        assertEquals(3, TreeSolutions.maxDepth(root));
    }

    @Test
    public void lowestCommonAncestor() {
        assertEquals(3, TreeSolutions.lowestCommonAncestor(root, root.left.left, root.left).val);
    }

    @Test
    public void isBalanced() {
        assertEquals(true, TreeSolutions.isBalanced(root));
    }

    @Test
    public void mergeTrees() {
        TreeSolutions.TreeNode root2 = new TreeSolutions.TreeNode(3);
        root2.left = new TreeSolutions.TreeNode(2);
        root2.left.left = new TreeSolutions.TreeNode(4);
        root2.left.left.right = new TreeSolutions.TreeNode(5);
        assertEquals(8, TreeSolutions.mergeTrees(root, root2).val);
    }

    @Test
    public void invertTree() {
        assertEquals(5, TreeSolutions.invertTree(root).val);
        assertEquals(3, TreeSolutions.invertTree(root).left.val);
    }

    @Test
    public void diameterOfBinaryTree() {
        assertEquals(4, TreeSolutions.diameterOfBinaryTree(root));
    }

    @Disabled("Until we figure out why this particular test hangs the Test Suite")
    @Test
    public void treeToList() {
        //           5
        //        /    \
        //       3      8
        //    /   \   /   \
        //   1    4  7     9
        //
        // <- 1 <-> 3 <-> 4 <-> 5 <-> 7 <-> 8 <-> 9 ->
        TreeSolutions.TreeNode node = TreeSolutions.treeToList(root);
        // 1
        assertEquals(1, node.val);
        // 3
        assertEquals(3, node.right.val);
        // 4
        assertEquals(4, node.right.right.val);
        // 9
        assertEquals(9, node.left.val);
        // 8
        assertEquals(8, node.left.left.val);
        // 7
        assertEquals(7, node.left.left.left.val);
        // 5
        assertEquals(5, node.right.right.right.val);
        // 5
        assertEquals(5, node.left.left.left.left.val);
        // true
        assertEquals(true, node.right.right.right.val == node.left.left.left.left.val);
        // [1, 3, 4, 5, 9, 8, 7]
        assertIterableEquals(
                Arrays.asList(1, 3, 4, 5, 9, 8, 7),
                Arrays.asList(
                        node.val,
                        node.right.val,
                        node.right.right.val,
                        node.right.right.right.val,
                        node.left.val,
                        node.left.left.val,
                        node.left.left.left.val));
    }
}
