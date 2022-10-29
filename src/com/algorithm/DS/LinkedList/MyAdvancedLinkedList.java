package com.algorithm.DS.LinkedList;

public class MyAdvancedLinkedList<E> {
    int size;
    Node<E> head;
    Node<E> tail;

    static class Node<E> {
        E data;
        Node<E> nextNode;
        int size;

        Node(E data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    MyAdvancedLinkedList(E data) {
        //new node creations -O(1)
        Node<E> newNode = new Node<E>(data);
        this.size = 1;
        this.head = newNode;
        this.tail = newNode;
        System.out.println(data + "->null");

    }

    void append(E data) {
        //10->9->8->89
        //append-0(n)
        Node<E> newNode = new Node<E>(data);
        this.tail.nextNode = newNode;
        this.tail = newNode;
        this.size++;
        System.out.println("Appended " + data);

    }

    void prepend(E data) {
        //head==null
        //10
        //10-->8
        //10-->8-->9
        Node<E> newNode = new Node<E>(data);
        newNode.nextNode = head;
        this.head = newNode;
        this.size++;
        System.out.println("Prepended " + data);
    }

    Node<E> traverseToIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        } else {
            Node<E> currentNode = this.head;
            int count = 0;
            while (index != count) {
                currentNode = currentNode.nextNode;
                count++;
            }

            return currentNode;
        }
    }

    void remove(int index) {
        if (index == 0) {
            //13-->null;
            //10-->6
            //10-->9-->4
            if (size == 0) {
                this.head = null;
                this.tail = null;
            } else {
                Node<E> temp = this.head;
                this.head = temp.nextNode;
                temp.nextNode = null;
                this.size--;
                System.out.println("Deleted node at " + index);
            }

            return;
        }
        Node<E> leader = traverseToIndex(index - 1);
        Node<E> toBeDelete = leader.nextNode;
        leader.nextNode = toBeDelete.nextNode;
        System.out.println("Deleted node At " + index);
        this.size--;
    }

    void insert(int index, E value) {
        if (index == 0) {
            prepend(value);
        } else if (index >= this.size) {
            append(value);
        } else {
            Node<E> newNode = new Node<>(value);
            Node<E> target = traverseToIndex(index - 1);
            Node<E> next = target.nextNode;
            target.nextNode = newNode;
            newNode.nextNode = next;
            System.out.println("Inserting " + value + " at " + index);
            this.size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (head == null) {
            return null;

        } else if (head.nextNode == null) {
            sb.append(head.data).append("-->").append("null");
            return sb.toString();

        } else {
            Node<E> temp = head;
            while (temp != null) {
                sb.append(temp.data).append("-->");
                temp = temp.nextNode;

            }
            sb.append("null");
            return sb.toString();
        }
    }

    void printMyLL() {
        System.out.println(this);
        System.out.println("size:" + this.size);
        if (this.head == null) {
            System.out.println("head:" + "null");
        } else {
            System.out.println("head:" + this.head.data);
        }

        if (this.head == null) {
            System.out.println("tail:" + "null");
        } else {
            System.out.println("tail:" + this.tail.data);

        }
    }
}
