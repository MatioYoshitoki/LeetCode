import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    public Link inorderTraversal(TreeNode root) {
        List <Integer> result = new LinkedList<>();
        preorderHelper(root, result);
        Link link = new Link(result.get(0));
        Link tmp;
        tmp = link;
        Link pre = null;
        for (int i = 1; i < result.size(); i++) {
            tmp.next = new Link(result.get(i));
            tmp.pre = pre;
            pre = tmp;
            tmp = tmp.next;
        }
        return link;
    }


    public void flatten(TreeNode root) {
        List <Integer> result = new LinkedList<>();
        preorderHelper(root, result);
        TreeNode tmp;
        tmp = root;
        for (int i = 1; i < result.size(); i++) {
            tmp.right = new TreeNode(result.get(i));
            tmp.left = null;
            tmp = tmp.right;
        }
    }

    int fatherVal ;
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        fatherVal = root.val;
        return preorderCheck(root, null);
    }

    public void inorderHelper(TreeNode root, List <Integer> result) {
        if (root != null) {
            if (root.left != null) {
                inorderHelper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                inorderHelper(root.right, result);
            }
        }
    }


    public void preorderHelper(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                preorderHelper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                preorderHelper(root.right, result);
            }
        }
    }

    public boolean preorderCheck(TreeNode root, Boolean leftFlag) {
        boolean result = true;
        if (root != null) {
            if (root.left != null) {
                if (root.left.val >= root.val){
                    return false;
                }
                if (leftFlag!=null) {
                    if (leftFlag && root.left.val >= fatherVal) {
                        return false;
                    }
                    if (!leftFlag && root.left.val <= fatherVal) {
                        return false;
                    }
                }
            }
            if (root.right != null) {
                if (root.right.val <= root.val){
                    return false;
                }
                if (leftFlag!=null) {
                    if (leftFlag && root.right.val >= fatherVal) {
                        return false;
                    }
                    if (!leftFlag && root.right.val <= fatherVal) {
                        return false;
                    }
                }
            }
            if (root.left!=null){
                result = preorderCheck(root.left, true);
            }
            if (root.right!=null){
                result &= preorderCheck(root.right, false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new InorderTraversal().inorderTraversal(new TreeNode(1));
    }
}

class Link{
    Link pre;
    Link next;
    int val;
    public Link(int val){
        this.val = val;
    }
}
