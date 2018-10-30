package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Josephus_1158 {
    public static void printAnswer(List<Integer> list, int m, int n) {
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
                        while (index < m && isRemoved[index])    index++;
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
        List<Integer> list = new ArrayList<>();

        // 1부터 m까지의 정수를 list에 저장
        for (int i = 1; i <= m; i++)
            list.add(i);

        printAnswer(list, m, n);
    }
}
