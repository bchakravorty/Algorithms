package com.algorithm.datastructure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by biswac on 11/12/2014.
 */
public class LinkedList {
    private static LinkedNode head;

    public static void main(String[] args) {
        head = createLinkedList();
        int length = findLength(head);
        System.out.println("length - "+length);
        LinkedNode node = new LinkedNode(); node.setValue(10);
        printList(head);
        addedNodeAtEnd(node, head);
        printList(head);
    }

    private static int findLength(LinkedNode head) {
        Set<LinkedNode> LinkedNodeSet = new HashSet<LinkedNode>();
        int lenth = 0;
        LinkedNode LinkedNode = head;
        while (LinkedNode != null) {
            if (LinkedNodeSet.contains(LinkedNode))
                break;
            else {
                System.out.println("LinkedNode value - "+LinkedNode.getValue());
                LinkedNodeSet.add(LinkedNode);
                lenth++;
                LinkedNode = LinkedNode.getNext();

            }
        }
        return lenth;
    }


    private static boolean addedNodeAtEnd(LinkedNode node, LinkedNode head) {
        LinkedNode tail = findTail(head);
        LinkedNode circularNode = tail.getNext();
        tail.setNext(node);
        node.setNext(circularNode);
        return true;
    }

    private static LinkedNode findTail(LinkedNode head) {
        Set<LinkedNode> linkedNodeSet = new HashSet<LinkedNode>();
        LinkedNode node = head; LinkedNode previous = null;
        while (node != null && !linkedNodeSet.contains(node)) {
            previous = node;
            node = node.getNext();
        }
        return previous;
    }


    private static LinkedNode createLinkedList() {
        LinkedNode n1 = new LinkedNode(); n1.setValue(1);
        LinkedNode n2 = new LinkedNode(); n2.setValue(2); n1.setNext(n2);
        LinkedNode n3 = new LinkedNode(); n3.setValue(3); n2.setNext(n3);
        LinkedNode n4 = new LinkedNode(); n4.setValue(4); n3.setNext(n4);
        LinkedNode n5 = new LinkedNode(); n5.setValue(5); n4.setNext(n5);
        LinkedNode n6 = new LinkedNode(); n6.setValue(6); n5.setNext(n6);
        LinkedNode n7 = new LinkedNode(); n7.setValue(7); n6.setNext(n7);n7.setNext(n2);
        return n1;
    }

    private static void printList(LinkedNode head) {
        Set<LinkedNode> linkedNodeSet = new HashSet<LinkedNode>();
        LinkedNode node = head; LinkedNode previous = null;
        while (node != null && !linkedNodeSet.contains(node)) {
            System.out.println("node value -"+node.getValue()+": node -"+node+": next value -"+node.getNext().getValue());
            previous = node;
            node = node.getNext();
        }

    }

}
