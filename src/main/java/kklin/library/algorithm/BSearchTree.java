package kklin.library.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BSearchTree {

    private TreeNode root;

    public BSearchTree() {
        this.root = null;
    }

    public TreeNode search(int value) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (value == currentNode.getValue()) {
                return currentNode;
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                currentNode = currentNode.getLeft();
            }
        }

        return null;
    }

    public TreeNode minimum() {
        return minimum(root);
    }

    private TreeNode minimum(TreeNode tree) {
        TreeNode currentNode = tree;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }

        return currentNode;
    }

    public TreeNode successor(int value) {
        TreeNode current = search(value);
        if (current == null || current.getRight() == null) {
            return null;
        }
        return minimum(current.getRight());
    }

    public TreeNode predecessor(int value) {
        TreeNode current = search(value);
        if (current == null || current.getLeft() == null) {
            return null;
        }
        return maximum(current.getLeft());
    }

    public List<Integer> preOrder() {
        List<Integer> output = new ArrayList<Integer>();
        preOrder(root, output);
        return output;
    }

    private void preOrder(TreeNode tree, List<Integer> output) {
        if (tree != null) {
            output.add(tree.getValue());
            System.out.print(tree.getValue() + ",");
            preOrder(tree.getLeft(), output);
            preOrder(tree.getRight(), output);
        }
    }

    public List<Integer> inOrder() {
        List<Integer> output = new ArrayList<Integer>();
        inOrder(root, output);
        return output;
    }

    private void inOrder(TreeNode tree, List<Integer> output) {
        if (tree != null) {
            inOrder(tree.getLeft(), output);
            output.add(tree.getValue());
            System.out.print(tree.getValue() + ",");
            inOrder(tree.getRight(), output);
        }
    }

    public List<Integer> postOrder() {
        List<Integer> output = new ArrayList<Integer>();
        postOrder(root, output);
        return output;
    }

    private void postOrder(TreeNode tree, List<Integer> output) {
        if (tree != null) {
            postOrder(tree.getLeft(), output);
            postOrder(tree.getRight(), output);
            output.add(tree.getValue());
            System.out.print(tree.getValue() + ",");
        }
    }

    public TreeNode maximum() {
        return maximum(root);
    }

    private TreeNode maximum(TreeNode tree) {
        TreeNode currentNode = tree;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        TreeNode currentNode = root;
        TreeNode parentNode;
        if (currentNode == null) {
            root = newNode;
            return;
        }

        while(true) {
            parentNode = currentNode;
            if (newNode.getValue() < currentNode.getValue()) {
                currentNode = parentNode.getLeft();
                if (currentNode == null) {
                    parentNode.setLeft(newNode);
                    newNode.setParent(parentNode);
                    return;
                }
            } else {
                currentNode = parentNode.getRight();
                if (currentNode == null) {
                    parentNode.setRight(newNode);
                    newNode.setParent(parentNode);
                    return;
                }
            }
        }
    }

    private TreeNode delete(TreeNode deleteNode) {
        if (deleteNode == null) {
            return null;
        }

        if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
            TreeNode parent = deleteNode.getParent();

            if (parent == null) {
                root = null;
            } else {
                if (parent.getRight() == deleteNode) {
                    parent.setRight(null);
                } else {
                    parent.setLeft(null);
                }
            }
        } else if(deleteNode.getLeft() == null || deleteNode.getRight() == null) {
            TreeNode parent = deleteNode.getParent();
            TreeNode child = deleteNode.getLeft() == null ? deleteNode.getRight() : deleteNode.getLeft();
            child.setParent(parent);
            if (parent == null) {
                root = child;
            } else {
                if (parent.getRight() == deleteNode) {
                    parent.setRight(child);
                } else {
                    parent.setLeft(child);
                }
            }
        } else if (deleteNode.getLeft() != null && deleteNode.getRight() != null) {
            TreeNode successor = successor(deleteNode.getValue());
            delete(successor); //需要对后继节点执行删除操作。
            if (successor.getParent() != deleteNode) {
                TreeNode right = deleteNode.getRight();
                successor.setRight(right);
                right.setParent(successor);
            }
            TreeNode left = deleteNode.getLeft();
            successor.setLeft(left);
            left.setParent(successor);

            TreeNode parent = deleteNode.getParent();
            successor.setParent(parent);
            if (parent == null) {
                root = successor;
            } else {
                if (parent.getRight() == deleteNode) {
                    parent.setRight(successor);
                } else {
                    parent.setLeft(successor);
                }
            }
        }

        return deleteNode;
    }

    public TreeNode delete(int value) {
        TreeNode deleteNode = search(value);
        return delete(deleteNode);
    }
}


class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
