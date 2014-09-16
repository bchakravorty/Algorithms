package com.algorithm.datastructure;

/**
 * Created by biswac on 9/4/2014.
 */
public class Node {
    private int key;
    private int value;
    private Node left;
    private Node right;


    private Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public static Node of(int key, int value) {
        Node n = new Node(key, value);
        return n;
    }
    public Node getLeft() {
        return left;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void right(Node right) {
        this.right = right;
    }
    public void left(Node left) {
        this.left = left;
    }


}
