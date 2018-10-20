package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 */
public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int[] tmp = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array, commands);
        for (int num : answer)
            System.out.print(num + " ");
        System.out.println();
    }
}
