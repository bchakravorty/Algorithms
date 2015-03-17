package com.algorithm.datastructure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by biswac on 2/18/2015.
 */
public class InsertNodeInBinaryTree {

    private static BinaryTree root;
    public static void addNode(int value){
        if (root == null) {
            root = new BinaryTree(value);
        }else {
            Queue<BinaryTree> nodes =new LinkedList<BinaryTree>();
            nodes.add(root); BinaryTree parent = null;
            while (!nodes.isEmpty()) {
                BinaryTree node = nodes.remove();
                if (node.getLeft() == null || node.getRight() ==null) {
                    BinaryTree binaryTree = new BinaryTree(value);
                    if (node.getLeft() == null) {
                        node.setLeft(binaryTree);
                        System.out.println("Add the new node to the left of :-"+node.getValue());
                    } else {
                        node.setRight(binaryTree);
                        System.out.println("Add the new node to the right of :-"+node.getValue());
                    }
                    break;
                } else {
                    if (node.getLeft() != null)
                        nodes.add(node.getLeft());
                    if (node.getRight() != null)
                        nodes.add(node.getRight());
                }
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree(1);BinaryTree t2 = new BinaryTree(2);BinaryTree t3 = new BinaryTree(3);
        BinaryTree t4 = new BinaryTree(4);BinaryTree t5 = new BinaryTree(5);BinaryTree t6 = new BinaryTree(6);
        BinaryTree t7 = new BinaryTree(7); BinaryTree t8 = new BinaryTree(8);

        t1.setLeft(t2); t1.setRight(t3);
        t2.setLeft(t4); t2.setRight(t5);
        t3.setLeft(t6);
        t6.setLeft(t7);
        t7.setRight(t8);
        root = t1;
//        addNode(7);
        int height = HeightOfTree.height(root);
        System.out.println("Height of the tree - "+height);
         height = HeightOfTree.heightNonRecursive(root);
        System.out.println("Height of the tree through bfs - "+height);



    }


}
