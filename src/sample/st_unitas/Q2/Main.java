package sample.st_unitas.Q2;

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
		int[] results = new int[n];	// 출력값을 담을 정수 배열

		for (int i = 0; i < n; i++) {



			String[] str = br.readLine().split(" ");
			int small = Integer.parseInt(str[0]);
			int medium = Integer.parseInt(str[1]);
			int large = Integer.parseInt(str[2]);
			int people = Integer.parseInt(str[3]);

			if (people / large > 0) {
				int tmpPeople = people;
				int mok = people / large;
				tmpPeople = tmpPeople - (large * mok);
				if (tmpPeople / medium > 0) {
					mok = tmpPeople / medium;
					tmpPeople = tmpPeople - (medium * mok);
					if (tmpPeople / small > 0) {
						mok = tmpPeople / small;
						tmpPeople = tmpPeople - (small * mok);

						results[i] = (tmpPeople == 0) ? 1 : 0;
					}
				}
			}



			// if-else
//			results[i] = ?;
		}
	}
}
