package com.debut;

import java.util.Objects;

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

    public String removeTail(){
        Node currentTail=tailNode;
        if (currentTail==null) return null;
        this.tailNode=currentTail.getPreviousNode();
        if (this.tailNode!=null) this.tailNode.setNextNode(null);
        if (currentTail==headNode) this.removeHead();
        return currentTail.data;

    }

    public String removeHead(){
        Node currentHead=headNode;
        if (currentHead==null) return null;
        this.headNode=currentHead.getNextNode();
        if (this.headNode!=null) headNode.setPreviousNode(null);
        if (currentHead==tailNode) this.removeTail();
        return currentHead.data;
    }

    public String[] removeByData(Node... nodes){
        String[] data=new String[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
         data[i]=nodes[i].data;
        }
        return removeByData(data);
    }
    public String[] removeByData(String... datas){
        String[] removedData =new String[datas.length];
        for (int i=0; i<datas.length;i++){
            Node current =headNode;
            while (current!=null){
                if (Objects.equals(current.data, datas[i])) break;
                current=current.getNextNode();
            }
            if (current==null) break;
            if (current==headNode) removedData[i]=this.removeHead();
            else if (current==tailNode) removedData[i]=this.removeTail();
            else {
                Node previousNode=current.getPreviousNode();
                Node nextNode=current.getNextNode();
                previousNode.setNextNode(nextNode);
                nextNode.setPreviousNode(previousNode);
                removedData[i]=current.data;
            }
        }
        return removedData;
    }





}
