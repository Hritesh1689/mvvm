package com.agicent.mvvmdemo.Activity.DataStructure;

class CircularSinglyLinkedList {
    
    
    public  static void main(String[] args){
        CSLLNode circularSinglyLinkedList=null;
        circularSinglyLinkedList= insertAtEnd(circularSinglyLinkedList,5);
        circularSinglyLinkedList= insertAtEnd(circularSinglyLinkedList,15);
        circularSinglyLinkedList=  insertAtEnd(circularSinglyLinkedList,18);
        circularSinglyLinkedList=insertAtEnd(circularSinglyLinkedList,90);
        circularSinglyLinkedList= insertAtEnd(circularSinglyLinkedList,113);
        circularSinglyLinkedList=insertAtEnd(circularSinglyLinkedList,98);
        circularSinglyLinkedList= insertAtFront(circularSinglyLinkedList,67);
        circularSinglyLinkedList= insertAtFront(circularSinglyLinkedList,35);
        circularSinglyLinkedList= deleteData(circularSinglyLinkedList,90);

        printLinkedList(circularSinglyLinkedList);
    }

    private static void printLinkedList(CSLLNode head) {
        CSLLNode p=head;
        while(p.next!=null){
            System.out.print(p.val+"-->");
            p=p.next;
        }
        System.out.print(p.val);
    }

    private static CSLLNode insertAtFront(CSLLNode head,int data){
        if(head==null){
            head=new CSLLNode(data);
            head.next=head;
            return head;
        }
        
        CSLLNode temp=new CSLLNode(data);
         CSLLNode p=head;
         
         while(p.next!=head){
             p=p.next;
         }
         temp.next=head;
         p.next=temp;
         
         
        head=temp;
        return head;
    }


    private static CSLLNode insertAtEnd(CSLLNode head,int data){
        if(head==null){
            head=new CSLLNode(data);
            head.next=head;
            return head;
        }
        
        CSLLNode temp=new CSLLNode(data);
        CSLLNode p=head;
        while(p.next!=head) p=p.next;

        p.next=temp;
        temp.next=head;
        return head;
    }

    private static CSLLNode deleteData(CSLLNode head,int data){
        if(head==null) return head;

        if(head.val==data){
             CSLLNode p=head;
             
             while(p.next!=head) p=p.next;
             head=head.next;
             p.next=head;
            return head;
        }

        CSLLNode p=head;

        while(p.next.val!=data) p=p.next;
        p.next=p.next.next;

        return head;
    }
    
    
}

class CSLLNode{
    int val;
    CSLLNode next;
    
    CSLLNode(int val){
        this.val=val;
        next=null;
    }
    
}
