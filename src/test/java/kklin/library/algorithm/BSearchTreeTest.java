package kklin.library.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BSearchTreeTest {


    @Test
    public void testInsert() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(20);
    }

    @Test
    public void testPreOrder() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(10);
        expected.add(5);
        expected.add(-20);
        expected.add(8);
        expected.add(30);
        expected.add(100);
        List<Integer> actual = tree.preOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInOrder() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(-20);
        expected.add(5);
        expected.add(8);
        expected.add(10);
        expected.add(30);
        expected.add(100);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInOrder2() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        tree.insert(-10);
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        List<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(-10);
        expected.add(3);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);
        expected.add(30);
        expected.add(100);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testPostOrder() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(-20);
        expected.add(8);
        expected.add(5);
        expected.add(100);
        expected.add(30);
        expected.add(10);
        List<Integer> actual = tree.postOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMinimum() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        TreeNode expected = new TreeNode(-20);
        TreeNode actual = tree.minimum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaximum() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        TreeNode expected = new TreeNode(100);
        TreeNode actual = tree.maximum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        TreeNode expected = new TreeNode(-20);
        TreeNode actual = tree.search(-20);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSuccessor() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        TreeNode expected = new TreeNode(30);
        TreeNode actual = tree.successor(10);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPredecessor() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        TreeNode expected = new TreeNode(8);
        TreeNode actual = tree.predecessor(10);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteWithOneValue() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.delete(10);
        List<Integer> actual = tree.inOrder();
        Assert.assertTrue(actual.size() == 0);
    }

    @Test
    public void testDeleteWithOnlyOneChild1() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(8);
        tree.delete(10);
        List<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(5);
        expected.add(8);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteWithOnlyOneChild2() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        tree.delete(30);
        List<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(5);
        expected.add(8);
        expected.add(10);
        expected.add(100);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testDeleteWithTwoChildren1() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        tree.delete(10);
        List<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(5);
        expected.add(8);
        expected.add(30);
        expected.add(100);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteWithTwoChildren2() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        tree.delete(5);
        List<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(8);
        expected.add(10);
        expected.add(30);
        expected.add(100);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteWithTwoChildren3() {
        BSearchTree tree = new BSearchTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(-20);
        tree.insert(100);
        tree.insert(8);
        tree.insert(-10);
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        tree.delete(5);
        List<Integer> expected = new ArrayList<>();
        expected.add(-20);
        expected.add(-10);
        expected.add(3);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);
        expected.add(30);
        expected.add(100);
        List<Integer> actual = tree.inOrder();
        Assert.assertEquals(expected, actual);
    }
}
