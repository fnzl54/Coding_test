//반래 : https://forward-gradually.tistory.com/52
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불의 전파 시간 파악 이후 전파 시간 이전에 움직일 수 있는 곳만 이동하여 탈출 여부 판단
public class Main {

  public static int R, C, answer = Integer.MIN_VALUE;
  public static char[][] map;
  public static int[][] fire, person;
  public static Queue<int[]> fireQ, personQ;
  public static int[] dx = {-1, 0, 0, 1};
  public static int[] dy = {0, -1, 1, 0};


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    fire = new int[R][C];
    person = new int[R][C];
    fireQ = new LinkedList<>();
    personQ = new LinkedList<>();
    for (int r = 0; r < R; r++) {
      String input = br.readLine();
      for (int c = 0; c < C; c++) {
        map[r][c] = input.charAt(c);
        fire[r][c] = -1;
        person[r][c] = -1;
        if (map[r][c] == 'F') {
          fire[r][c] = 0;
          fireQ.add(new int[] {r, c});
        } else if (map[r][c] == 'J') {
          person[r][c] = 0;
          personQ.add(new int[] {r, c});
        }
      }
    }

    fireBfs();
    personBfs();

    if (answer == Integer.MIN_VALUE) {
      System.out.println("IMPOSSIBLE");
    } else {
      System.out.println(answer);
    }

  }

  static void fireBfs() {
    while (!fireQ.isEmpty()) {
      int[] now = fireQ.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveY >= 0  && moveX < R && moveY < C) {
          if (map[moveX][moveY] != '#' && fire[moveX][moveY] == -1) {
            fire[moveX][moveY] = fire[x][y] + 1;
            fireQ.add(new int[] {moveX, moveY});
          }
        }
      }
    }

  }

  static void personBfs() {
    while (!personQ.isEmpty() && answer == Integer.MIN_VALUE) {
      int[] now = personQ.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX < 0 || moveX >= R || moveY < 0 || moveY >= C) {
          answer = person[x][y] + 1;
          break;
        }

        if (map[moveX][moveY] != '#' && person[moveX][moveY] == -1) {
          if (fire[moveX][moveY] > person[x][y] + 1 || fire[moveX][moveY] == -1) {
            person[moveX][moveY] = person[x][y] + 1;
            personQ.add(new int[] {moveX, moveY});
          }
        }
      }

    }
  }

}