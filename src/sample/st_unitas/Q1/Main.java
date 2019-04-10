package sample.st_unitas.Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-04-10
 *
 * 딸기(4), 바나나(3), 라임(2), 자두(1) 순서대로, 많을 수록 승리
 * 수가 모두 같으면 무승부
 *
 * 원택의 동생이 이겼다면 A를, 동생의 친구가 이겼다면 B를 출력한다. 만약 무승부라면 D를 출력하면 된다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] results = new char[n];

		for (int i = 0; i < n; i++) {
			String[] aCard = br.readLine().split(" ");
			String[] bCard = br.readLine().split(" ");

			int[] aNum = new int[4];
			int[] bNum = new int[4];

			calc(aCard, aNum);
			calc(bCard, bNum);

//			getResult(aNum, bNum);

			boolean isDone = false;
			for (int j = 0; j < 4; j++) {
				if (aNum[j] > bNum[j]) {
					results[i] = 'A';
					isDone = true;
					break;
				} else if (aNum[j] < bNum[j]) {
					results[i] = 'B';
					isDone = true;
					break;
				}
			}
			if (!isDone)
				results[i] = 'D';
		}

		for (char result : results) {
			System.out.println(result);
		}
	}

	private static void calc(String[] card, int[] numbers) {
		for (String numStr : card) {
			int num = Integer.parseInt(numStr);
			if (num == 4) {
				numbers[0]++;
			} else if (num == 3) {
				numbers[1]++;
			} else if (num == 2) {
				numbers[2]++;
			} else if (num == 1) {
				numbers[3]++;
			}
		}
	}

//	private static void getResult(int[] aNum, int[] bNum) {
//		for (int i = 0; i < 4; i++) {
//			if (aNum[i] > bNum[i]) {
//				System.out.println("A");
//				return;
//			} else if (aNum[i] < bNum[i]) {
//				System.out.println("B");
//				return;
//			}
//		}
//		System.out.println("D");
//	}
}