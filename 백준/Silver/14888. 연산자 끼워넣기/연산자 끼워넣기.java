// 테케 : https://www.acmicpc.net/board/view/110806
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, tempAnswer;
  static int[] number, formula;
  static List<Integer> answerList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    N = Integer.parseInt(br.readLine());

    number = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      number[n] = Integer.parseInt(st.nextToken());
    }

    formula = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      formula[i] = Integer.parseInt(st.nextToken());
    }

    tempAnswer = number[0];
    dfs(1);

    Collections.sort(answerList);
    sb.append(answerList.get(answerList.size()-1)).append("\n").append(answerList.get(0));

    System.out.println(sb);
  }

  static void dfs(int depth) {
    if (depth == N) {
      answerList.add(tempAnswer);
      return;
    }

    for(int i = 0; i < 4; i++) {
      if (formula[i] != 0) {
        int beforeTempAnswer = tempAnswer;
        formula[i]--;
        calculation(i, number[depth]);
        dfs(depth + 1);
        formula[i]++;
        tempAnswer = beforeTempAnswer;
      }
    }
  }

  static void calculation (int formulaNumber, int num) {
    switch (formulaNumber) {
      case 0:
        tempAnswer += num;
        break;
      case 1:
        tempAnswer -= num;
        break;
      case 2:
        tempAnswer *= num;
        break;
      case 3:
        tempAnswer /= num;
        break;

    }
  }
  
}