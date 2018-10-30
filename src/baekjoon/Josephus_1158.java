package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1158
 * 백준 제출 결과는 성공.
 * 풀고 보니 LinkedList의 특성을 전혀 활용하지 않는 풀이인 것 같아 개선이 필요한 것 같다.
 */
public class Josephus_1158 {
    static void printAnswer(List<Integer> list, int m, int n) {
        boolean[] isRemoved = new boolean[m];

        System.out.print("<");
        int index = -1;
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n; j++) {
                index++;
                while (index < m && isRemoved[index])    index++;
                if (index >= m) {
                    index = 0;
                    if (isRemoved[index]) {
                        while (index < m && isRemoved[index])
                            index++;
                    }
                }
            }
            isRemoved[index] = true;
            System.out.print(list.get(index) + ", ");
        }

        int finalIndex = 0;
        for (int i = 0; i < m; i++) {
            if (!isRemoved[i]) {
                finalIndex = i;
                break;
            }
        }
        System.out.print(list.get(finalIndex));
        System.out.println(">");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        List<Integer> list = new LinkedList<>();

        // 1부터 m까지의 정수를 list에 저장
        for (int i = 1; i <= m; i++)
            list.add(i);

        printAnswer(list, m, n);
    }
}
