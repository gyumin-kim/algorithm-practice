package leetcode.Q111_Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

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
   * Depth-first traversal
   */
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);

    if (root.left == null)  return right + 1;
    if (root.right == null) return left + 1;
    return Math.min(left, right) + 1;
  }

  /**
   * Breadth-first traversal
   */
  public int minDepth2(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    TreeNode rightMost = root;
    int depth = 1;

    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node.left == null && node.right == null)  break;

      if (node.left != null)  q.add(node.left);
      if (node.right != null)  q.add(node.right);

      if (node == rightMost) {
        depth++;
        rightMost = (node.right != null) ? node.right : node.left;
      }
    }

    return depth;
  }
}
