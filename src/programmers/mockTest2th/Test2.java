package programmers.mockTest2th;

public class Test2 {

  /**
   *
   * @param l 도로의 길이
   * @param v 가로등의 위치 정보
   * @return ?
   */
  public static int solution(int l, int[] v) {
    int answer = 0;

    // 가로등이 있는 곳을 true로 둔다.
    boolean[] arr = new boolean[l+1];
    for (int index : v) {
      arr[index] = true;
    }

    // 각 가로등 사이의 거리 중 최대값을 구한다.
    int maxLength = 0;
    int prevLight = 0;
    for (int i = 0; i <= l; i++) {
      if (arr[i]) {
        if (i == 0) continue;
        int length = i - prevLight;
        prevLight = i;
        if (length > maxLength)
          maxLength = length;
      }
    }
    System.out.println("maxLength: " + maxLength);

    // d를 1부터 시작해 최대값까지 커버 가능한지 체크한다(d를 1씩 증가시키면서).
    answer = maxLength / 2;
    if (maxLength % 2 != 0)
      answer++;

    return answer;
  }

  public static void main(String[] args) {
    int l = 5;
    int[] v = { 2, 5 };
    System.out.println(solution(l, v));
  }
}
