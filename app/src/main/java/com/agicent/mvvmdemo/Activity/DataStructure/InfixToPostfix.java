package com.agicent.mvvmdemo.Activity.DataStructure;

public class InfixToPostfix {
   public static SinglyLinkedList stack;

    public static void main(String[] args){

         infixToPostfix("(2*3+4*(5-6))");
        infixToPrefix("(2*3+4*(5-6))");
    }

    private static void infixToPrefix(String s) {
        int i=0;
        stack=new SinglyLinkedList();
        char temp;
        while(i<s.length()){
            char c=s.charAt(i);
            if(isAlphaNumeric(c)) System.out.print(c);
            else if(c=='(') push(c);
            else if(c==')') while((temp=pop())!='(') System.out.print(temp);
            else{ while(priority(top())>priority(c)) System.out.print(pop()); push(c); }
            i++;
        }
    }

    private static void infixToPostfix(String s) {
        int i=0;
        stack=new SinglyLinkedList();
        char temp;
        while(i<s.length()){
            char c=s.charAt(i);
            if(isAlphaNumeric(c)) System.out.print(c);
            else if(c=='(') push(c);
            else if(c==')') while((temp=pop())!='(') System.out.print(temp);
            else{ while(priority(top())>priority(c)) System.out.print(pop()); push(c); }
            i++;
        }
    }

    private static int priority(char c) {
        if(c=='(') return 0;
        else if(c=='+' || c=='-') return 1;
        else return 2;
    }

    private static boolean isAlphaNumeric(char c) {
        if(Character.isDigit(c) || Character.isAlphabetic(c)) return true;
        else return false;
    }

    public static void push(char el){
        stack.insertAtFront(el);
    }

    public static char pop(){
        return stack.deleteAtFront();
    }
    public static char top(){
        return stack.getFront();
    }
}
