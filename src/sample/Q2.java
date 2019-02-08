package sample;

/**
 * @author Gyumin Kim
 * @since 2019-02-08
 *
 * int 형 숫자를 하나 입력받아 1인 비트 수를 세는 메서드를 작성하세요.
 * 단 Integer.toBinaryString 또는 Integer.toString 함수를 사용하지 않고 구현합니다.
 */
public class Q2 {

  public static int countBits(int number) {
    int count = 0;
    while (number > 0) {
      if (number % 2 == 1)
        count++;
      number /= 2;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(countBits(10));
  }
}
