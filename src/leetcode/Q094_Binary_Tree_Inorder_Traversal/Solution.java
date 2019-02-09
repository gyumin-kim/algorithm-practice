package leetcode.Q094_Binary_Tree_Inorder_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Gyumin Kim
 * @since 2019-02-09
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
   * recursive
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    if (root.left != null)  list.addAll(inorderTraversal(root.left));
    list.add(root.val);
    if (root.right != null)  list.addAll(inorderTraversal(root.right));

    return list;
  }

  /**
   * iterative
   */
  public List<Integer> inorderTraversal2(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode pointer = root;

    while (pointer != null || !stack.isEmpty()) {
      // 직전 loop에서 right로 이동했음. 왼쪽 child node들 계속 체크
      while (pointer != null) {
        stack.push(pointer);
        pointer = pointer.left;
      }

      pointer = stack.pop();
      // list에 push하고 right로 이동
      list.add(pointer.val);
      pointer = pointer.right;
    }

    return list;
  }
}
