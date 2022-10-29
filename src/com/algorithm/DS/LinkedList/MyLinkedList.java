package com.algorithm.DS.LinkedList;

public class MyLinkedList<E> {
    Node node;

    MyLinkedList(E data) {
        node = new Node(data);
    }

    MyLinkedList() {
    }


    boolean isEmpty() {
        if (node == null) return true;
        return node.head == null;
    }

    void addNode(E data) {
        //if Node is not initialised then init it
        if (node == null) {
            node = new Node(data);
            node.head = node;
//            System.out.println("Node has been initialised with " + node.data);
            return;
        }
        Node toAdd = new Node(data);
        if (isEmpty()) {
            node.head = toAdd;
//            System.out.println(toAdd.data + " Node has been added ");
            return;
        }
        //reaching to the last node
        Node temp = node.head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = toAdd;
//        System.out.println(toAdd.data + " Node has been added at last");

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = node.head;
        sb.append(temp.data).append("=>");
        while (temp.nextNode != null) {
            sb.append(temp.nextNode.data).append("=>");
            temp = temp.nextNode;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private Node getSecondLastNode() {
        Node temp = node.head;
        int len = size();
        int i = 1;
        if (len == 1) {
            node.head = null;
            return node;
        }
        while (i < len - 1) {
            temp = temp.nextNode;
            i++;
        }
        return temp;
    }

    public Object getEndNode() {
        Node temp = node.head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        return temp.data;
    }

    public int size() {
        int count = 1;
        Node temp = node.head;
        if (isEmpty()) {
            return 0;
        }
        while (temp.nextNode != null) {
            temp = temp.nextNode;
            count++;
        }
        return count;
    }

    public void removeLastNode() {
        Node temp = getSecondLastNode();
        System.out.println(temp.nextNode.data + " Removed");
        temp.nextNode = null;

    }

    public void removeAt(int index) {

        if (isEmpty()) {
            System.out.println("Linked list is already empty");

        } else {
            int len = size();
            if (index > len || index < 0) {
                System.out.println("Invalid index:" + index + " for length: " + len);
                return;
            }

            if (index == 0 && node.head.nextNode == null) {
                //only 1 node
                node.head = null;

                return;
            }
            if (index == 1 && node.head.nextNode.nextNode == null) {
                //only 2 nodes
                node.head.nextNode = null;
                return;
            }

            Node temp = node.head;
            if (index == 0) {
              //new head assignment
                node.head = node.head.nextNode;
                return;
            }
            if (index == len-1) {
                //if last element to be deleted
                removeLastNode();
                return;
            }
            int count = 1;
            while (count < index) {
                temp = temp.nextNode;
                count++;
            }
            Node PrevNode = temp;
            Node TobeDeletedNode = temp.nextNode;
            PrevNode.nextNode = TobeDeletedNode.nextNode;
            TobeDeletedNode.nextNode = null;


        }


    }

}

class Node<E> {
    E data;
    Node<E> head;
    Node<E> nextNode;

    Node(E data) {
        this.data = data;
        this.nextNode = null;

    }
}
