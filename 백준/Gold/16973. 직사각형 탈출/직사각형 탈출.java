import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int N, M, H, W, Sr, Sc, Fr, Fc, answer = -1;
  static int[][] map;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  static List<int[]> wallPoints = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        map[n][m] = Integer.parseInt(st.nextToken());
        if (map[n][m] == 1) {
          wallPoints.add(new int[] {n, m});
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    Sr = Integer.parseInt(st.nextToken());
    Sc = Integer.parseInt(st.nextToken());
    Fr = Integer.parseInt(st.nextToken());
    Fc = Integer.parseInt(st.nextToken());

    bfs();

    if (answer == -1) {
      System.out.println("-1");
    } else {
      System.out.println(answer);
    }

  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] check  = new boolean[N][M];

    q.add(new int[] {Sr-1,Sc-1});
    check[Sr-1][Sc-1] = true;

    while(!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      if (x == Fr-1 && y == Fc-1) {
        answer = map[x][y];
        return;
      }

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveY >= 0 && moveX < N && moveY < M) {
          if (check[moveX][moveY] == false && checkRectangle(moveX, moveY) && map[moveX][moveY] == 0) {
            q.add(new int[] {moveX, moveY});
            check[moveX][moveY] = true;
            map[moveX][moveY] = map[x][y] + 1;
          }
        }

      }
    }
  }

  static boolean checkRectangle(int x, int y) {
    if (x+H-1 < N && y+W-1 < M) {
      for (int[] wall : wallPoints) {
        int wX = wall[0];
        int wY = wall[1];

        if(wX >= x && wX <= x+H-1 && wY >= y && wY <= y+W-1) {
          return false;
        }
      }

      return true;
    }

    return false;
  }

}
