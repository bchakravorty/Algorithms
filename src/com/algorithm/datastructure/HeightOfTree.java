package com.algorithm.datastructure;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by biswac on 2/19/2015.
 */
public class HeightOfTree {
    public static int height(BinaryTree binaryTree){
        if (binaryTree == null)
            return -1;
        else {
            int lheight = height(binaryTree.getLeft());
            int rheight= height(binaryTree.getRight());
            int height = lheight > rheight ? lheight: rheight;
            return height+1;
        }
    }

    public static int heightNonRecursive(BinaryTree root)
    {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        BinaryTree delimiter = new BinaryTree(-2);
        queue.add(root); queue.add(delimiter);
        int height = 0;

        while (!queue.isEmpty()) {
            BinaryTree b = queue.remove();
            BinaryTree next = queue.peek();
            if (b == delimiter ) {
                if (next == null) {
                    break;
                } else {
                height++;
                queue.add(delimiter);
            }

            } else {
                if (b.getLeft() != null)
                    queue.add(b.getLeft());

                if (b.getRight() != null)
                    queue.add(b.getRight());
            }

        }

        return height;


    }
}
