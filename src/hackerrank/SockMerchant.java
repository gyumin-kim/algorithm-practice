package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] arr) {
        int answer = 0;

        // Sort the array
        Arrays.sort(arr);

        int count = 1;
        int num = arr[0];

        for (int i = 1; i < n; i++) {
            // 이전 수와 i번째 수가 다른 경우
            if (arr[i] != num) {
                if (count > 1)
                    answer += count / 2;
                count = 1;
                num = arr[i];
            }

            // 이전 수와 i번째 수가 같은 경우
            else {
                if (i == n-1) {
                    count++;
                    answer += count / 2;
                }
                else
                    count++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String line = br.readLine();
        String[] strs = line.split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);

        System.out.println(sockMerchant(n, arr));
    }
}
