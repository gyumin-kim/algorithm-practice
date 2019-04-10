package sample.st_unitas.Q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-04-10
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] results = new int[n];

		for (int i = 0; i < n; i++) {
			int taskSize = Integer.parseInt(br.readLine());
			int[][] tasksArr = new int[taskSize][2];
			for (int j = 0; j < taskSize; j++) {
				String[] times = br.readLine().split(" ");
				tasksArr[j][0] = Integer.parseInt(times[0]);
				tasksArr[j][1] = Integer.parseInt(times[1]);
			}

			int latestEnd = 1;
			for (int j = 0; j < taskSize; j++) {
				if (latestEnd <= tasksArr[j][0]) {
					results[i]++;
					latestEnd = tasksArr[j][1];
				}
			}
		}

		for (int result : results) {
			System.out.println(result);
		}
	}
}
