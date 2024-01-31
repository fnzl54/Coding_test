import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static boolean[][] checkBoard = new boolean[5][5];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int answer = 0;

    Map<Integer, int[]> numberLocate = new HashMap<>();
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        numberLocate.put(Integer.parseInt(st.nextToken()), new int[] {i, j});
      }
    }

    end: for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        int[] locate =  numberLocate.get(Integer.parseInt(st.nextToken()));
        checkBoard[locate[0]][locate[1]] = true;
        if (checkLine() >= 3) {
          answer++;
          break end;
        }
        answer++;
      }
    }

    System.out.println(answer);

  }

  static int checkLine() {
    boolean oneLineCheck = true;
    int lineCount = 0;

    // 세로줄 확인
    for (int i = 0; i < 5; i++) {
      oneLineCheck = true;
      for (int j = 0; j < 5; j++) {
        if (checkBoard[i][j] == false) {
          oneLineCheck = false;
          break;
        }
      }

      if (oneLineCheck) {
        lineCount++;
      }
    }

    // 가로줄 확인
    for (int i = 0; i < 5; i++) {
      oneLineCheck = true;
      for (int j = 0; j < 5; j++) {
        if (checkBoard[j][i] == false) {
          oneLineCheck = false;
          break;
        }
      }

      if (oneLineCheck) {
        lineCount++;
      }
    }

    // 가로줄 확인 1
    oneLineCheck = true;
    for (int i = 0; i < 5; i++) {
      if (checkBoard[i][i] == false) {
        oneLineCheck = false;
        break;
      }
    }
    if (oneLineCheck) {
      lineCount++;
    }

    // 가로줄 확인 2
    oneLineCheck = true;
    for (int i = 0; i < 5; i++) {
      if (checkBoard[i][4-i] == false) {
        oneLineCheck = false;
        break;
      }
    }
    if (oneLineCheck) {
      lineCount++;
    }

    return lineCount;
  }

}