package com.debut;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addToHead("jean");
        list.addToTail("paul","delacrois","theodort");
        list.printList();
    }
}
