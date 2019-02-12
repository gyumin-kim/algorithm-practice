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

  /**
   * Top-down recursion
   */
  public boolean isValidBST(TreeNode root) {
    return util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean util(TreeNode root, int min, int max) {
    if (root == null) return true;

    return root.val < max && root.val > min
        && util(root.left, min, root.val)
        && util(root.right, root.val, max);
  }

  /**
   * Top-down recursion (use null to represent the infinity)
   */
  public boolean isValidBST2(TreeNode root) {
    return util2(root, null, null);
  }

  public boolean util2(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;

    return (min == null || root.val > min)
        && (max == null || root.val < max)
        && util(root.left, min, root.val)
        && util(root.right, root.val, max);
  }

  /**
   * In-order traversal
   */
  private TreeNode prev;
  public boolean isValidBST3(TreeNode root) {
    prev = null;
    return isMonotonicIncreasing(root);
  }

  private boolean isMonotonicIncreasing(TreeNode p) {
    if (p == null)  return true;
    if (isMonotonicIncreasing(p.left)) {  // 왼쪽 자식들이 다 현재 node의 값보다 작은 경우(true가 리턴되어 올라온 경우)
      if (prev != null && p.val <= prev.val)  return false; // 직전 node의 값보다 크지 않다면 false
      prev = p;
      return isMonotonicIncreasing(p.right);
    }

    return false; // 직전 node들에 대해 재귀호출한 결과가 false라면 여기로 와서 false를 리턴
  }
}
