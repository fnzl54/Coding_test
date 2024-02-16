import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int N, M, max, answer = Integer.MAX_VALUE;
  public static int[][] map;
  public static int[][] check; // 방문 체크를 하면서 몇번째 방문인지 저장
  public static List<int[]> virusPoint = new ArrayList<>();
  public static int[] nowVirus;
  public static int[] dx = {-1, 0, 0, 1};
  public static int[] dy = {0, -1, 1, 0};


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        // 바이러스 놓을 수 있는 위치 저장
        if (map[i][j] == 2) {
          virusPoint.add(new int[] {i, j});
        }
      }
    }

    nowVirus = new int[M];
    dfs(0, 0); // 바이러스를 놓을 수 있는 위치에 대한 모든 경우

    if (answer == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }

  }

  static void dfs(int depth, int now) {
    // 바이러스를 놓을 위치를 찾으면 bfs로 시간 구하기
    if (depth == M) {
      check = new int[N][N];
      bfs();

      max = Integer.MIN_VALUE;
      if (checkAllVirus()) {
        answer = Math.min(max, answer);
      }

      return;
    }

    for (int i = now; i < virusPoint.size(); i++) {
      nowVirus[depth] = i;
      dfs(depth + 1, i + 1);
    }

  }


  static void bfs() {
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < nowVirus.length; i++) { // dfs의 경우의 수에 대해 좌표값을 q에 넣어줌
      int[] now = virusPoint.get(nowVirus[i]);
      q.add(now);
      check[now[0]][now[1]] = 1;
    }

    while(!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveY >= 0 && moveX < N && moveY < N) {
          if (check[moveX][moveY] == 0 && map[moveX][moveY] != 1) {
            check[moveX][moveY] = check[x][y] + 1;
            q.add(new int[] {moveX, moveY});
          }
        }
      }
    }

  }

  static boolean checkAllVirus() { // 모든 땅에 바이러스를 전파했는지 확인
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (check[i][j] == 0 && map[i][j] != 1) {
          return false;
        } else {
          max = Math.max(max, check[i][j] - 1);
        }
      }
    }

    return true;
  }

}
