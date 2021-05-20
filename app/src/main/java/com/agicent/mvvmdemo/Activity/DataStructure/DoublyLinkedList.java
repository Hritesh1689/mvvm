package com.agicent.mvvmdemo.Activity.DataStructure;

public class DoublyLinkedList {

    public static void main(String[] args){
         DLL dl=new DLL();
         dl.insertAtEnd(34);
        dl.insertAtEnd(23);
        dl.insertAtEnd(116);
        dl.insertAtEnd(78);
        dl.insertAtFront(9);
        dl.insertAtFront(21);
        dl.insertAtFront(389);
        dl.insertAtFront(47);
        dl.insertAtAnyPosition(654,23);

       dl.insertAtAnyPosition(111,9);
        dl.delete(78);

        traverse(dl);

    }

    private static void traverse(DLL dll) {
        if(dll.head==null) return ;
        DLLNode p=dll.head;
        while(p.next!=null){
            System.out.print(p.val+"<--->");
            p=p.next;
        }
        System.out.print(p.val);

        System.out.println();
        while(p.prev!=null){
            System.out.print(p.val+"<--->");
            p=p.prev;
        }
        System.out.print(p.val);
    }




}

class DLL{
     DLLNode head;
     DLLNode tail;

     DLL(){
         head=null;
         tail=null;
     }

    public  void insertAtEnd(int data){
        DLLNode newNode=new DLLNode(data);
        if(head==null){ head=newNode; tail=newNode;  return; }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    public  void delete(int data){
        if(head==null) return ;

        if( head.val==data){
            head=head.next;
            if(head!=null) head.prev=null;
            return;
        }

        if( tail.val==data){
            tail=tail.prev;
            tail.next.prev=null;
            tail.next=null;
            return;
        }

        DLLNode p=head;
        while(p.val!=data) p=p.next;
        p.prev.next=p.next;
        if(p.next!=null)
            p.next.prev=p.prev;

    }

    public  void insertAtAnyPosition(int data,int after){
        if(head==null){  head=new DLLNode(data); return; }

        DLLNode newNode=new DLLNode(data);
        DLLNode p=head;
        while(p.val!=after) p=p.next;
        newNode.next=p.next;
        if(p.next!=null) p.next.prev=newNode;
        newNode.prev=p;
        p.next=newNode;

    }


    public  void insertAtFront(int data){
        DLLNode newNode=new DLLNode(data);
        if(head==null){ head=newNode; return; }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

}

class DLLNode{
    int val;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val){
        this.val=val;
        next=null;
        prev=null;
    }

    public DLLNode() {

    }
}
