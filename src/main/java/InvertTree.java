class Solution12 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        if (root.left!=null && root.right!=null){
            TreeNode tmpL = new TreeNode(root.left.val);
            tmpL.left = root.left.left;
            tmpL.right = root.left.right;
            TreeNode tmpR = new TreeNode(root.right.val);
            tmpR.left = root.right.left;
            tmpR.right = root.right.right;
            root.left = tmpR;
            root.right = tmpL;
            invertTree(root.left);
            invertTree(root.right);
        }else if (root.left!=null){
            TreeNode tmpL = new TreeNode(root.left.val);
            tmpL.left = root.left.left;
            tmpL.right = root.left.right;
            root.right = tmpL;
            root.left = null;
            invertTree(root.right);
        }else if (root.right!=null){
            TreeNode tmpR = new TreeNode(root.right.val);
            tmpR.left = root.right.left;
            tmpR.right = root.right.right;
            root.left = tmpR;
            root.right = null;
            invertTree(root.left);
        }
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}