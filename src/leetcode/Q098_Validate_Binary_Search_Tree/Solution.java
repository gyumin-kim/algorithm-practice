package leetcode.Q098_Validate_Binary_Search_Tree;

/**
 * @author Gyumin Kim
 * @since 2019-02-11
 */
public class Solution {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return util(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean util(TreeNode root, long min, long max) {
    if (root.val >= max || root.val <= min) return false;

    boolean left = true;
    boolean right = true;
    if (root.left != null)  {
      left = util(root.left, min, root.val);
    }
    if (root.right != null)  {
      right = util(root.right, root.val, max);
    }

    return left && right;
  }
}
