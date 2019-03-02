package custom;

/**
 * @author Gyumin Kim
 * @since 2019-03-02
 */
public class QuickSortCtci {

  private static void quickSort(int[] arr, int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1) quickSort(arr, left, index - 1);
    if (index < right)    quickSort(arr, index, right);
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
      while (arr[left] < pivot) left++;
      while (arr[right] > pivot) right--;

      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  private static void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }

  public static void main(String[] args) {
    int[] intArray = {20, 35, -15, 7, 55, 1, -22};
    quickSort(intArray, 0, intArray.length-1);

    for (int num : intArray) {
      System.out.print(num + " ");
    }
  }
}
