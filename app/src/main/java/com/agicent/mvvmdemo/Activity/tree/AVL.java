package com.agicent.mvvmdemo.Activity.tree;

public class AVL {

    public static void main(String[] args){
        Node avl = null;
        avl= insert(1,avl);
        avl= insert(2,avl);
        avl= insert(3,avl);
        avl= insert(4,avl);
        avl= insert(5,avl);
        avl= insert(6,avl);
        avl= insert(7,avl);
        avl= insert(8,avl);
        avl= insert(9,avl);
        avl= insert(10,avl);
        avl= insert(11,avl);
        avl= insert(12,avl);
        avl= insert(13,avl);
        avl= insert(14,avl);
        avl= insert(15,avl);

        System.out.println("root "+avl.val);
        System.out.println("left "+avl.left.val);
        System.out.println("right "+avl.right.val);
        System.out.println("left-left "+avl.left.left.val);
        System.out.println("left-right "+avl.left.right.val);
        System.out.println("right-left "+avl.right.left.val);
        System.out.println("right-right "+avl.right.right.val);

     }

    private static Node insert(int val, Node avl) {
        if(avl==null) return new Node(val,0);
        else {
            if(val<avl.val) avl.left=insert(val,avl.left);
            else avl.right=insert(val,avl.right);
            Node ret= checkBalance(avl,val);
            int lh=height(avl.left);
            int rh=height(avl.right);
            avl.height=1+Math.max(lh,rh);
            return ret;
        }
    }

    private static Node checkBalance(Node avl, int val) {
        int bf=balanceFactor(avl);
        if(bf==1 || bf==0 || bf==-1) return avl;
        if(bf>1){
            if(avl.left!=null && val<avl.left.val) return LL(avl);
            else {
                avl.left=RR(avl.left);
                return LL(avl);
            }
        }else{
            if(avl.right!=null && val>avl.right.val) return RR(avl);
            else {
                avl.right=LL(avl.right);
                return RR(avl);
            }
        }
    }

    private static Node LL(Node node) {
        Node newRoot=node.left;
        Node leftOfNewRoot=newRoot.right;
        node.left=null;
        newRoot.right=node;
        newRoot.right.left=leftOfNewRoot;
        return newRoot;
    }

    private static Node RR(Node node) {
        Node newRoot=node.right;
        Node rightOfNewRoot=newRoot.left;
        node.right=null;
        newRoot.left=node;
        newRoot.left.right=rightOfNewRoot;
        return newRoot;
    }

    private static int balanceFactor(Node avl) {
        if(avl==null) return -1;
        else return height(avl.left)-height(avl.right);
    }

    private static int height(Node node) {
        if(node == null) return -1;
        else return node.height;
    }

}
class Node{
    int val;
    int height;
    Node left;
    Node right;

    public Node(int val, int height) {
        this.val=val;
        this.height=height;
        left=right=null;
    }
}

