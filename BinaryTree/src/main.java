import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main {
    public static void main(String[] args){

        BinaryTree tree= new BinaryTree();
        tree.addNode(50);
        tree.addNode(25);
        tree.addNode(75);
        tree.addNode(15);
        tree.addNode(30);
        tree.addNode(85);

        System.out.println("---------IterativeFindMinimum--------------");
        System.out.println(IterativeFindMinimum(tree.root));
        System.out.println("---------IterativeFindMaximum--------------");
        System.out.println(IterativeFindMaximum(tree.root));
        System.out.println("------------RecursiveFindMinimum-----------");
        RecursiveFindMinimum(tree.root);
        System.out.println("------------RecursiveFindMaximum-----------");
        RecursiveFindMaximum(tree.root);
        System.out.println("-------------FindElement--------------");
        System.out.println(FindElement(tree.root,30));
        System.out.println("-------------FindElementRecursive--------------");
        System.out.println(FindElementRecursive(tree.root,30));
        System.out.println("--------------CountNodes-------------");
        System.out.println(countNodes(tree.root));
        System.out.println("--------------countLeafNode-------------");
        System.out.println(countLeafNode(tree.root));
        System.out.println("--------------InOrderTraversal--------------");
        InOrderTraversal(tree.root);
        System.out.println();
        System.out.println("--------------PostOrderTraversal--------------");
        PostOrderTraversal(tree.root);
        System.out.println();
        System.out.println("--------------preOrderTraversal--------------");
        preOrderTraversal(tree.root);
        System.out.println();
        System.out.println("--------------copyTree--------------");
        copyTree(tree.root);
        System.out.println();
        System.out.println("--------------isIdenticalTree--------------");
        BinaryTree tree3= new BinaryTree();
        tree3.addNode(50);
        tree3.addNode(25);
        tree3.addNode(75);
        tree3.addNode(15);
        tree3.addNode(30);
        tree3.addNode(85);

        System.out.println(isIdenticalTrees(tree.root,tree3.root));


    }
    public static int IterativeFindMinimum(TreeNode root){
        if(root==null){
            System.out.println("error empty");
            return -1;
        }
        while(root.leftChild!=null){
            root=root.leftChild;

        }
        return root.getValue();
    }

    public static int IterativeFindMaximum(TreeNode root){
        if(root==null){
            System.out.println("error empty");
            return -1;
        }
        while(root.rightChild!=null){
            root=root.rightChild;

        }
        return root.getValue();
    }

    public static void RecursiveFindMinimum(TreeNode root){
        if(root==null){
            System.out.println("Root is empty");
        }
        else{
            if (root.leftChild == null) {
                System.out.println(root.getValue());
            } else {
                RecursiveFindMinimum(root.leftChild);
            }
        }

    }
    public static void RecursiveFindMaximum(TreeNode root){
        if(root==null){
            System.out.println("Root is empty");
        }
        else{
            if (root.rightChild == null) {
                System.out.println(root.getValue());
            }
            else {
                RecursiveFindMaximum(root.rightChild);
            }
        }

    }

    public static TreeNode FindElement(TreeNode root,int value){
        while(root!=null) {

            if (value == root.getValue()) {
                return root;
            }
            else if (value < root.getValue()) {
                root=root.leftChild;

            }
            else
                root=root.rightChild;
        }
        return null;
    }
    public static TreeNode FindElementRecursive(TreeNode root,int value) {
        if (value == root.getValue()) {
            return root;
        } else if (value < root.getValue()) {
            if (root.leftChild != null) {
                return FindElementRecursive(root.leftChild, value);
            }
            return null;
        } else {
            if (root.rightChild != null) {
                return FindElementRecursive(root.rightChild, value);
            }
            return null;
        }
    }


        public static int countNodes(TreeNode root){
        if(root==null)
            return 0;

        return 1+countNodes(root.leftChild)+countNodes(root.rightChild);

    }

    public static int countLeafNode(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.leftChild==null && root.rightChild==null){
            return 1;
        }
        return countLeafNode(root.leftChild)+countLeafNode(root.rightChild);
    }

    public static void InOrderTraversal(TreeNode root) {
        if(root!=null) {
            InOrderTraversal(root.leftChild);
            System.out.print(root.getValue()+" ");
            InOrderTraversal(root.rightChild);
        }

    }

    public static void PostOrderTraversal(TreeNode root){
        if(root!=null){
            PostOrderTraversal(root.leftChild);
            PostOrderTraversal(root.rightChild);
            System.out.print(root.getValue()+" ");
        }
    }
    public static void preOrderTraversal(TreeNode root){
        if(root!=null){
            System.out.print(root.getValue()+" ");
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }

    }
    public static String preOrderTraversal2(TreeNode root){
        String s1="";
        if(root!=null){
            s1=" "+root.getValue();
            preOrderTraversal2(root.leftChild);
            preOrderTraversal2(root.rightChild);
        }
        return s1;
    }
    public static void copyTree(TreeNode root){
        BinaryTree copynewTree = new BinaryTree();
        if(root==null){
            return;
        }
        copyTree(root.leftChild);
        copynewTree.addNode(root.getValue());
        preOrderTraversal(copynewTree.root);
        preOrderTraversal(root.rightChild);
    }

    public static boolean isIdenticalTrees(TreeNode root1,TreeNode root2){

        String s1=preOrderTraversal2(root1);
        String s2=preOrderTraversal2(root2);

        if(root1==null && root2==null)
            return true;

        else if(s1.equals(s2))
            return true;

        else
            return false;
    }








    }





