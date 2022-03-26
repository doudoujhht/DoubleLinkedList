package com.debut;

public class MyDoubleLinkedList {
    private Node headNode;
    private Node tailNode;
    public MyDoubleLinkedList(){
        this.headNode = null;
        this.tailNode=null;
    }

    public String printList(){
        String laListe="<head> ";
        Node currentNode = headNode;
        while(currentNode != null){
            laListe = laListe + (currentNode.data + " ");
            currentNode=currentNode.getNextNode();
        }
        laListe+="<tail>";
        System.out.println(laListe);
        return laListe;
    }


    //constructeur qui prend un string en paramètre
    public void addToHead(String... data){
        for(String donnee : data){
            addToHead(new Node(donnee));
        }

    }
    public void addToHead(Node... nodes){
        for(Node node : nodes){
            Node currentHead = headNode;
            if (currentHead != null){
                currentHead.setPreviousNode(node);
                node.setNextNode(currentHead);
            }
            this.headNode=node;
            if (this.tailNode==null) addToTail(node);
        }
    }



    public void addToTail(String... data){
        for(String donnee : data){
            addToTail(new Node(donnee));
        }

    }

    public void addToTail(Node... nodes){
        for (Node node:nodes){
            Node currentTail=tailNode;
            if (currentTail!=null){
                currentTail.setNextNode(node);
                node.setPreviousNode(currentTail);
            }
            this.tailNode=node;
            if (this.headNode==null) addToHead(node);
        }
    }





}
