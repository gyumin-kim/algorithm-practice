package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/1406
 * IDE에서 3가지 예제 입력에 대해 올바른 결과가 출력됨.
 * 백준 제출 결과 시간초과됨.
 */
public class Editor_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 512);
        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);
        int time = Integer.parseInt(br.readLine());
        int pointer = input.length();

        for (int i = 0; i < time; i++) {
            String command = br.readLine();
            char opt = command.charAt(0);
            switch (opt) {
                // 커서를 왼쪽으로 한칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case 'L':
                    if (pointer != 0)
                        --pointer;
                    break;
                // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                case 'D':
                    if (pointer < sb.length())
                        ++pointer;
                    break;
                // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                case 'B':
                    if (pointer != 0)
                        sb.delete(pointer-1, pointer--);
                    break;
                // 'extraStr'을 커서 왼쪽에 추가함
                case 'P':
                    sb.insert(pointer++, command.charAt(2));
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
