class TreeNode<T> {
    T data; 
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    public TreeNode(T data) {
        this.data = data;
        this.parent = this.left = this.right = null;
    }
    

}