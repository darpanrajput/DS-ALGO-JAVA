package com.algorithm.DS.LinkedList;

public class LinkedList {
    static MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

    public static void main(String[] args) {
        insertion();
        //printingAndRemoving();
        //removingOperations();
        //testingRemovingAt();

        MyAdvancedLinkedList<Integer> ll = new MyAdvancedLinkedList<>(201);
        ll.append(9);
        ll.append(89);
        ll.append(800);
        ll.prepend(0);
        ll.prepend(90);
        ll.printMyLL();
        ll.insert(2, 100);
        ll.insert(7, 701);
        ll.insert(0, 1011);

        ll.printMyLL();
        ll.remove(0);

        ll.printMyLL();


    }


    public static void insertion() {

        for (int i = 0; i < 10; i++) {
            myLinkedList.addNode(i);
        }

    }

    public static void printingAndRemoving() {
        System.out.println("Linked list:" + myLinkedList);
        System.out.println("size:" + myLinkedList.size());
        System.out.println("last node is:" + myLinkedList.getEndNode());
        myLinkedList.removeLastNode();
        System.out.println("*********************************************************************************************");

        System.out.println("Linked list:" + myLinkedList);
        System.out.println("size:" + myLinkedList.size());
        System.out.println("now last node is:" + myLinkedList.getEndNode());
        myLinkedList.removeLastNode();
        System.out.println("*********************************************************************************************");

        System.out.println("Linked list:" + myLinkedList);
        System.out.println("size:" + myLinkedList.size());
        System.out.println("now last node is:" + myLinkedList.getEndNode());
        myLinkedList.removeLastNode();
        System.out.println("*********************************************************************************************");

        System.out.println("Linked list:" + myLinkedList);
        System.out.println("size:" + myLinkedList.size());
        System.out.println("now last node is:" + myLinkedList.getEndNode());

    }

    private static void printLL() {
        System.out.println(myLinkedList.toString());
    }

    private static void removingOperations() {
        printLL();
        myLinkedList.removeAt(5);
        printLL();
        myLinkedList.removeAt(3);
        printLL();
        myLinkedList.removeAt(9);
        printLL();
    }

    static void testingRemovingAt() {
        myLinkedList.addNode(11);
        myLinkedList.addNode(24);
        System.out.println(myLinkedList.size());
        printLL();
        myLinkedList.removeAt(0);
        printLL();
    }

}
