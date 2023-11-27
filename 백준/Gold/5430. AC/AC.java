/*
반례 1 (https://www.acmicpc.net/board/view/104970)
2
DD
2
[1,2]
DD
2
[1,2]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      Boolean direction = true; // R이 들어올때마다 방향 변수
      Boolean printCheck = false;
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine());
      StringBuilder sbInput = new StringBuilder(br.readLine());
      Deque<String> pq = new ArrayDeque<>();


      // 배열 입력 받음
      sbInput.deleteCharAt(sbInput.length()-1);
      sbInput.deleteCharAt(0);
      String input = sbInput.toString();
      for (String s : input.split(",")) {
        pq.add(s);
      }

      // 함수 실행
      for (char c : p.toCharArray()) {
        if (pq.isEmpty()) {
          sb.append("error").append("\n");
          printCheck = true;
          break;
        }

        if (c == 'R') {
          direction = !direction;
        }

        if (c == 'D') {
          if (pq.size() == 1 && pq.peek() == "") {
            sb.append("error").append("\n");
            pq.remove();
            printCheck = true;
            break;
          }

          if (direction) { // 앞에서 지우는 경우
            pq.remove();
          } else {
            pq.removeLast();
          }
        }

      }

      // 출력 형식에 맞도록 수정
      if (pq.isEmpty() && printCheck == false) {
        sb.append("[]").append("\n");
        printCheck = true;
      }

      if (printCheck == false){
        sb.append("[");
        if (direction) {
          while (!pq.isEmpty()) {
            sb.append(pq.pollFirst()).append(",");
          }
        } else {
          while (!pq.isEmpty()) {
            sb.append(pq.pollLast()).append(",");
          }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]").append("\n");
      }
    }

    System.out.println(sb);
  }
}