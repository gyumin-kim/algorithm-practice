package baekjoon;

import java.util.Scanner;

public class Lotto_6603 {
    private static final int LOTTO_BALL_COUNT = 6;

    public static int getLastFalseIndex(boolean[] isUsed, int length) {
        int lastFalseIndex = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (!isUsed[i]) {
                lastFalseIndex = i;
                break;
            }
        }

        return lastFalseIndex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        boolean[] isUsed = new boolean[n];  // 기본값: false

        int falseCount = n; // falseCount: isUsed[]에 들어있는 false의 개수
        int lastFalseIndex = -1;

        while (true) {
            if (falseCount >= LOTTO_BALL_COUNT) {
                int printedNumbersCount = 0;    // printedNumbersCount: pass 시작할 때마다 0으로 초기화
                int firstFalse = 0;
                int lastFalse = n;
                boolean isFirst = false;

                for (int i = 0; i < n; i++) {
                    if (!isUsed[i]) {
                        if (!isFirst) { // 첫 false 판별
                            isFirst = true;
                            firstFalse = i;
                        }
                        System.out.print(arr[i] + " ");
                        printedNumbersCount++;
                        // 6개 째의 false를 출력했으면 한 pass를 끝내고
                        // 6개 중 가장 오른쪽의 false는 true로 바꾸고, falseCount 1 감소
                        if (printedNumbersCount == LOTTO_BALL_COUNT) {
                            isUsed[i] = true;
                            lastFalse = i;
                            falseCount--;
                            System.out.println();
                            if (firstFalse == n-6 && lastFalse == n-1) {
                                return;
                            }
                            break;
                        }
                    }
                }
            }
            else {
                lastFalseIndex = getLastFalseIndex(isUsed, n);
                isUsed[lastFalseIndex] = true;
                for (int i = lastFalseIndex + 1; i < n; i++) {
                    isUsed[i] = false;
                    falseCount++;
                }
                falseCount--;
            }
        }
    }
}
