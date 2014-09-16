package com.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by biswac on 9/4/2014.
 */
public class BST {
    private Node root;

    public boolean addNode(Node newNode){
        if (newNode == null) throw new IllegalArgumentException("Cannot add null node");
        if (root == null) {
            root = newNode;
            return true;
        } else {
            return addNode(root, newNode, null);
        }
    }

    private boolean addNode(Node node, Node newNode, Node parentNode) {

        if (node.getValue() == newNode.getValue()) return false;
        if (node.getValue() < newNode.getValue()) {
            return addNode(node.getLeft(),newNode, node);
        } else {
            return addNode(node.getRight(), newNode, node);
        }
    }

    public Node find(int value) {
        FindNode findNode = find(root, value, null);
        return findNode.getNode();

    }

    private FindNode find(Node node, int value, Node parentNode) {
        if (node == null) throw new NoSuchElementException("The value does not exist in the tree");
        if (node.getValue() < value) return find(node.getRight(), value, node);
        if (node.getValue() > value) return find(node.getLeft(), value, node);
        return new FindNode(node, parentNode);
    }

    public Node removeNode(Node n){
      FindNode findNode = find(root, n.getValue(), null);
      return null;

    }

    public Node floor(int value) {
        return null;
    }


    public Node ceiling(int value) {
        return null;
    }

    private static class FindNode {
        private Node parentNode;

        FindNode(Node n, Node parentNode) {
            this.node = n;
            this.parentNode = parentNode;
        }
        public Node getNode() {
            return node;
        }

        public Node getParentNode() {
            return parentNode;
        }

        private Node node;

    }

}
