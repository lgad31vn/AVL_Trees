import java.util.*;

public class AVLTree<T extends Comparable<T>> {
    // tree root
    private TreeNode<T> root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size  = 0;
    }
    
    public void add(T data) {
        TreeNode<T> newNode = new TreeNode<T>(data);
        if( root == null) {
            root = newNode;
            size++;
            return;
        }
        add(newNode, root);

    }
    private void add(TreeNode<T> newNode, TreeNode<T> parent) {
        if(newNode.data.compareTo(parent.data) > 0) {
            if(parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                size++;
            } else add(newNode, parent.right);
        } else {
            if(parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                size++;
            } else add(newNode, parent.left);
        }
        checkBalance(newNode);
    }

    public void checkBalance(TreeNode<T> node) {
        if(
            (height(node.left) - height(node.right) > 1) || 
            (height(node.left) - height(node.right) < -1)
        ) {
            rebalance(node);
        }
        if(node.parent == null) return;

        checkBalance(node.parent);
        
    }

    public void rebalance(TreeNode<T> node) {
        if(height(node.left) - height(node.right) > 1) {
            if(height(node.left.left) > height(node.left.right)) node = rightRotate(node);
            else node = leftRightRotate(node);
        } else {
            if(height(node.right.left) > height(node.right.right)) node = leftRotate(node);
            else node = rightLeftRotate(node);
        }
        if(node.parent == null) root = node;
    }

}
