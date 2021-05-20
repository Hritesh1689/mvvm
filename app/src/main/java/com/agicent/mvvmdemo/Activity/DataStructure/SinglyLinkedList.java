package com.agicent.mvvmdemo.Activity.DataStructure;

public class SinglyLinkedList {

//    public  static void main(String[] args){
//           Node linkedList=new Node();
//          linkedList= insertAtEnd(linkedList,5);
//        linkedList= insertAtEnd(linkedList,15);
//        linkedList=  insertAtEnd(linkedList,18);
//        linkedList=insertAtEnd(linkedList,90);
//        linkedList= insertAtEnd(linkedList,113);
//        linkedList=insertAtEnd(linkedList,98);
//        linkedList= insertAtFront(linkedList,67);
//        linkedList= insertAtFront(linkedList,35);
//        linkedList= deleteData(linkedList,90);
//
//        printLinkedList(linkedList);
//    }
    public Node linkedList;
    SinglyLinkedList() {
        linkedList = null;
    }


    private  void printLinkedList(Node linkedList) {
        while(linkedList.next!=null){
            System.out.print(linkedList.val+"-->");
            linkedList=linkedList.next;
        }
        System.out.print(linkedList.val);
    }

    public  void insertAtFront(char data){
        if(linkedList==null) {  linkedList=new Node(data); return; }
        Node temp=new Node(data);
        if(linkedList.val==0)
            temp.next=linkedList.next;
        else
        temp.next=linkedList;
        linkedList=temp;
        return ;
    }


    public static Node insertAtEnd(Node head,char data){
        if(head==null) return new Node(data);
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;

        temp.next=new Node(data);
        return head;
    }

    public static Node deleteData(Node head,int data){
        if(head==null) return head;

        if(head.val==data) return head.next;

        Node temp=head;
        while(temp.next!=null && temp.next.val!=data)
            temp=temp.next;

        temp.next=temp.next.next;
        return head;
    }

    public  char deleteAtFront(){
        if(linkedList==null) return '0';

        char c=linkedList.val;
        Node next=linkedList.next;
        linkedList=next;

        return c;
    }

    public char getFront() {
        return linkedList.val;
    }
}

class Node{
    char val;
    Node next;

    Node(char data){
        this.val=data;
        next=null;
    }

    Node(){}
}
