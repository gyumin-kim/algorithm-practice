package leetcode.Q145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    if (root.left != null) list.addAll(postorderTraversal(root.left));
    if (root.right != null) list.addAll(postorderTraversal(root.right));
    list.add(root.val);

    return list;
  }

  /**
   * iterative
   * stack 2개를 사용한다.
   */
  public List<Integer> postorderTraversal2(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    Deque<TreeNode> s1 = new ArrayDeque<>();
    Deque<TreeNode> s2 = new ArrayDeque<>();

    s1.push(root);
    while (!s1.isEmpty()) {
      TreeNode treeNode = s1.pop();
      s2.push(treeNode);
      if (treeNode.left != null) s1.push(treeNode.left);
      if (treeNode.right != null) s1.push(treeNode.right);
    }

    while (!s2.isEmpty())
      list.add(s2.pop().val);

    return list;
  }

  /**
   * iterative
   * LinkedList를 사용하여 Stack 개수를 1개로 줄인다.
   */
  public List<Integer> postorderTraversal3(TreeNode root) {
    if (root == null) return new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;

    while (!stack.isEmpty() || p != null) {
      if (p != null) {
        stack.push(p);
        list.addFirst(p.val);
        p = p.right;
      } else {
        TreeNode node = stack.pop();
        p = node.left;
      }
    }

    return list;
  }
}
