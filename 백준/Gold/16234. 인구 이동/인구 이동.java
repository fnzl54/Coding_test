import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, L, R;
  static int[][] map, check;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  static List<int[]> openPoint = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    boolean checkAgain = true;
    int answer = -1;

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (checkAgain) {
      check = new int[N][N];
      checkAgain = false;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (check[i][j] == 0) {
            bfs(i, j);
            if (!openPoint.isEmpty()) {
              movePopulation(i, j);
              checkAgain = true;
            }
            openPoint.clear();
          }
        }
      }

      answer++;
    }

    System.out.println(answer);
  }
  
  // 인구 이동이 필요한 국가 좌표 찾기
  static void bfs(int startX, int startY) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {startX, startY});
    //int[][] tempCheck = new int[N][N];
    check[startX][startY] = 1;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N ) {
          if (check[moveX][moveY] != 1) {
            int populationDifference = Math.abs(map[x][y] - map[moveX][moveY]);
            if ( L <= populationDifference && populationDifference <= R) {
              check[moveX][moveY] = 1;
              openPoint.add(new int[] {moveX, moveY});
              q.add(new int[] {moveX, moveY});
            }
          }
        }
      }
    }
  }

  // 인구 이동이 필요한 국가간의 이동
  static void movePopulation(int startX, int startY) {
    openPoint.add(new int[] {startX, startY});

    int sumPopulation = 0;
    for (int[] point : openPoint) {
      sumPopulation += map[point[0]][point[1]];
    }

    for (int[] point : openPoint) {
      map[point[0]][point[1]] = sumPopulation / openPoint.size();
    }
  }

}
