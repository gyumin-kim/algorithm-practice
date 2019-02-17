package leetcode.contests.Weekly_Contest_124.Q993_Cousins_in_Binary_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gyumin Kim
 * @since 2019-02-17
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

  private Map<Integer, Integer> depth;
  private Map<Integer, TreeNode> parent;

  public boolean isCousins(TreeNode root, int x, int y) {
    depth = new HashMap<>();
    parent = new HashMap<>();

    dfs(root, null);
    return depth.get(x) == depth.get(y)
        && parent.get(x) != parent.get(y);
  }

  private void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
      depth.put(node.val, par == null ? 0 : depth.get(par.val) + 1);
      parent.put(node.val, par);
      dfs(node.left, node);
      dfs(node.right, node);
    }
  }
}
