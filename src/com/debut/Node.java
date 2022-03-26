package com.debut;

public class Node {
    public String data;
    private Node nextNode;
    private Node previousNode;

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node(String data){
        this.data = data;
        this.nextNode=null;
        this.previousNode=null;
    }

}
