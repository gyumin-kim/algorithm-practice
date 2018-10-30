package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Editor_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int time = Integer.parseInt(br.readLine());
        int pointer = input.length();
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < time; i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                // 커서를 왼쪽으로 한칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case 'L':
                    if (pointer != 0)
                        --pointer;
                    break;
                // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                case 'D':
                    if (pointer < list.size())
                        ++pointer;
                    break;
                // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                case 'B':
                    if (pointer != 0) {

                    }
                    break;
                // 'extraStr'을 커서 왼쪽에 추가함
                case 'P':
                    String extraStr = command.split(" ")[1];
                    list.add(pointer++, extraStr);
                    break;
            }
        }

        for (String str : list)
            //TODO: StringBuilder 혹은 StringBuffer로 출력할 것(성능 향상)
            System.out.print(str);

//        LinkedList<String> list = new LinkedList<>();
//        list.addLast("a");
//        list.addLast("b");
//        list.addLast("c");
//        list.addLast("d");
//        list.add(4, "e");
//        System.out.println(list);
    }
}
