package leetcode.Q108_Convert_Sorted_Array_to_Binary_Search_Tree;

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

  public TreeNode sortedArrayToBST(int[] nums) {
    return makeBST(nums, 0, nums.length-1);
  }

  public TreeNode makeBST(int[] arr, int start, int end) {
    if (start > end) return null;

    int middle = (start + end) / 2;
    TreeNode node = new TreeNode(arr[middle]);

    node.left = makeBST(arr, start, middle-1);
    node.right = makeBST(arr, middle+1, end);

    return node;
  }
}
