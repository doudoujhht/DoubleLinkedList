package com.debut;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addToHead("jean");
        list.addToTail("paul","marc","paulin","jacques");
        Node jean = new Node("christophe");
        list.addToHead(jean);
        list.printList();
        list.removeByData("marc","jean");
        list.printList();
        list.removeByData(jean);
        list.printList();
    }
}
