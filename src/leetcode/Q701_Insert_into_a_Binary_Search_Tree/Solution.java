package leetcode.Q701_Insert_into_a_Binary_Search_Tree;

/**
 * @author Gyumin Kim
 * @since 2019-03-12
 *
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class Solution {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null)
      return new TreeNode(val);

    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }

    return root;
  }
}