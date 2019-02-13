package leetcode.Q110_Balanced_Binary_Tree;

/**
 * @author Gyumin Kim
 * @since 2019-02-13
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

  /**
   * Brute force top-down recursion
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
        && isBalanced(root.left) && isBalanced(root.right);
  }

  public int maxDepth(TreeNode p) {
    if (p == null) return 0;
    int left = maxDepth(p.left);
    int right = maxDepth(p.right);
    return Math.max(left, right) + 1;
  }

  /**
   * Bottom-up recursion
   */
  public boolean isBalanced2(TreeNode root) {
    return maxDepth2(root) != -1;
  }

  private int maxDepth2(TreeNode root) {
    if (root == null) return 0;

    int L = maxDepth2(root.left);
    if (L == -1)  return -1;
    int R = maxDepth2(root.right);
    if (R == -1)  return -1;

    return Math.abs(L-R) <= 1
        ? Math.max(L, R) + 1
        : -1;
  }
}
