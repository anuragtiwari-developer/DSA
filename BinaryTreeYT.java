package Tree;

import com.sun.source.tree.Tree;

import java.security.PublicKey;
import java.util.*;

public class BinaryTreeYT {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);  // //ly inorder & postorder.
    }
    // Q) BFS-print level order traversal
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    // Q) count nodes in a binary tree
    public static int countOfNodes(Node root){
         if(root == null){
             return 0;
         }
         int left = countOfNodes(root.left);
         int right = countOfNodes(root.right);
         return (left+right+1);
    }
    // Q) sum of nodes in a binary tree
    public static int sumOfNodes(Node root){
        if(root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }
    // Q) Height of a tree
    // A) - left or right height which ever max add +1 in it
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }
    // Q) Diameter of a tree
    // Number of nodes in the longest path between any 2 nodes
    // case_1 = diameter passes through root node.
    // case_2 = diameter do NOT passes through node.
    // approach_1:O(n^2) - Diam1 -> left_subtree
    //                   - Diam2 -> right_subtree
    //                   - Diam3 -> (left_subtree + right_subtree + 1)
    // MAX of(Diam1, Diam2, Diam3) ==  ANSWER!! (actual tree diameter)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left)+height(root.right)+1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }
    // Diameter of a tree
    // approach 2: O(N) - we will calculate height simultaneously
    //                    so that we don't have to create another
    // function. that's why we'll have 0(N) T.C.
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){}
        this.ht = ht;
        this.diam = diam;
    }

    public static TreeInfo diameter2(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, mydiam);
        return  myInfo;
    }
    // Q) subtree of another tree - LEETCODE
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
//        System.out.println(root.data);
//        preorder(root);
//        levelOrder(root);
//        System.out.println("count of nodes is: " + countOfNodes(root));
//        System.out.println("sum of nodes is: "+sumOfNodes(root));
//        System.out.println(height(root));
//        System.out.println(diameter(root));
        System.out.println(diameter2(root).diam);
    }
}
