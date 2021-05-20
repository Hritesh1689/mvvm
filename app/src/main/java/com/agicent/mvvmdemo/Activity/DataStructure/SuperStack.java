package com.agicent.mvvmdemo.Activity.DataStructure;

public class SuperStack {


    public static void main(String[] args){
        Stak s=new Stak();
        s.push(5);
        s.push(10);
        System.out.println(s.middle());
      //  System.out.println(s.minimum());
        s.deleteMiddle();
        s.deleteMiddle();
        System.out.println(s.top());
        s.push(90);
        s.push(87);
        s.push(8);
        s.push(34);
        //System.out.println(s.minimum());
        System.out.println(s.middle());
        s.pop();
        System.out.println(s.middle());
    }
    
}

class Stak{
    int count;
    DLLNode1 head;
    DLLNode1 middle;
    long min;

    Stak(){
        head=null;
        middle=null;
        count=0;
        min=Long.MAX_VALUE;
    }


    public void push(long val){
        if(head==null) {
            head=new DLLNode1(val);
            middle=head;
            min=val;
        }else{
            DLLNode1 newNode=new DLLNode1(val);
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            if(count==0) middle=head;
            else if((count&1)==1) middle=middle.prev;
        }
        count++;
    }

    public void pop(){
        if(head!=null){
            head=head.next;
            if(head!=null) head.prev=null;
            if(head==null) middle=null;
            else if((count&1)!=1) middle=middle.next;
            count--;
        }
    }

    public int top(){
        if(head==null) return -1;
        else{
            if(head.val>min) return (int)head.val;
            else return (int)min;
        }
    }

    public int middle(){
        if(head==null) return -1;
        else return (int)middle.val;
    }


    public void deleteMiddle(){
//        if(head!=null){
//
//            if(head==middle){
//                middle=middle.next;
//                if(middle!=null) middle.prev=null;
//                head=middle;
//
//            }else {
//
//                DLLNode1 temp = null;
//                if ((count & 1) == 1) temp = middle.prev;
//                else temp = middle.next;
//
//                if (middle.prev != null)
//                    middle.prev.next = middle.next;
//                if (middle.next != null)
//                    middle.next.prev = middle.prev;
//
//                middle = temp;
//            }
//            count--;
//        }


        if(count>0){
            DLLNode1 temp ;
            if ((count & 1) == 1) temp = middle.prev;
            else temp = middle.next;

            if (middle.prev != null)
                middle.prev.next = middle.next;
            if (middle.next != null)
                middle.next.prev = middle.prev;

            middle = temp;
            count--;

            if(count==0){
                head=null;
                middle=null;
            }
        }
    }


}

class DLLNode1{
    long val;
    DLLNode1 next;
    DLLNode1 prev;

    DLLNode1(long val) {
        this.val=val;
        next=null;
        prev=null;
    }
}

