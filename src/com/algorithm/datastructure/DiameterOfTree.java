package com.algorithm.datastructure;

import static java.lang.Math.*;

/**
 * Created by biswac on 3/17/2015.
 */
public class DiameterOfTree {

    private static int height (BinaryTree node){
        if (node == null) return 0;
        return max(height(node.getLeft()), height(node.getRight()))+1;
    }

    private static int diameter(BinaryTree node) {
        if (node == null) return 0;
        int heightLeft = height(node.getLeft());
        int heightRight = height(node.getRight());
        int diameter = heightLeft + heightRight;
        int diameterLeft = diameter(node.getLeft());
        int diameterRight = diameter(node.getRight());
        int maxDiameter = max(diameterLeft, diameterRight);
        return max(diameter, maxDiameter);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        BinaryTree node8 = new BinaryTree(8);
        BinaryTree node9 = new BinaryTree(9);


        root.setLeft(node2);root.setRight(node3);
        node2.setLeft(node4); node2.setRight(node5);
        node4.setLeft(node7); node5.setRight(node6);
        node6.setRight(node8);
        node8.setLeft(node9);
        int maxDiameter = diameter(root);
        System.out.println("maxDiameter = "+maxDiameter);

    }


}


