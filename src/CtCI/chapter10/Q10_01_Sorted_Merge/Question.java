package CtCI.chapter10.Q10_01_Sorted_Merge;

/**
 * @author Gyumin Kim
 * @since 2019-03-02
 */
public class Question {

  private static void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexA = lastA - 1;
    int indexB = lastB - 1;
    int len = indexA + indexB + 1;

    while (indexB >= 0) {
      if (indexA >= 0 && a[indexA] > b[indexB]) {
        a[len--] = a[indexA--];
      } else {
        a[len--] = b[indexB--];
      }
    }

    // b의 원소들이 먼저 a에 복사되었다면, a에 원래 있던 것들은 이미 제자리에 있다.
//    while (i >= 0)
//      a[len--] = a[i--];
  }

  public static void main(String[] args) {
    int[] a = new int[20];
    a[0] = 3;
    a[1] = 7;
    a[2] = 11;
    a[3] = 16;
    a[4] = 42;
    a[5] = 51;
    int[] b = { 2, 9, 15, 32, 40 };

    merge(a, b, 6, 5);

    for (int num : a) {
      System.out.print(num + " ");
    }
  }
}
