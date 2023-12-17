// 반례 : https://forward-gradually.tistory.com/71
// BFS 풀어야 하는 이유 : https://www.acmicpc.net/board/view/76922
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int K, W, H, answer = Integer.MAX_VALUE;
  static int[][] map;
  static int[][][] check;
  static int[] dxHorse = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] dyHorse = {-1, 1, -2, 2, -2, 2, -1, 1};
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    // 입력
    map = new int[H][W];
    for (int h = 0; h < H; h++) {
      st = new StringTokenizer(br.readLine());
      for (int w = 0; w < W; w++) {
        map[h][w] = Integer.parseInt(st.nextToken());
      }
    }


    check = new int[H][W][K+1];
    check[0][0][0] = 1;
    bfs();

    if (answer == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }

/*
DFS 푸는 과정 (시간 초과,,)
 */
//    check = new int[H][W];
//    check[0][0] = 1;
//    dfs(0, new int[] {0, 0});
//
//    if (answer == Integer.MAX_VALUE) {
//      System.out.println(-1);
//    } else {
//      System.out.println(answer);
//    }


  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {0, 0, K, 0});

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];
      int k = now[2];
      int count = now[3];

      if (x == H - 1 && y == W - 1) {
        answer = count;
        return;
      }

      if (k > 0) {
        for (int i = 0; i < 8; i++) {
          int moveX = x + dxHorse[i];
          int moveY = y + dyHorse[i];

          if (moveX >= 0 && moveY >= 0 && moveX < H && moveY < W) {
            if (check[moveX][moveY][k-1] == 0 && map[moveX][moveY] != 1) {
              check[moveX][moveY][k-1] = 1;
              q.add(new int[] {moveX, moveY, k - 1, count + 1});
            }
          }
        }
      }

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveY >= 0 && moveX < H && moveY < W) {
          if (check[moveX][moveY][k] == 0 && map[moveX][moveY] != 1) {
            check[moveX][moveY][k] = 1;
            q.add(new int[] {moveX, moveY, k, count + 1});
          }
        }
      }
    }
  }

/*
DFS 푸는 과정 (시간 초과,,)
 */
//  static void dfs(int depth, int[] now) {
//    if (check[H-1][W-1] != 0) {
//      answer = Math.min(answer, check[H-1][W-1]-1);
//      return;
//    }
//
//    if (depth >= H + W -2) {
//      return;
//    }
//
//    int x = now[0];
//    int y = now[1];
//
//    if (K > 0) {
//      for (int i = 0; i < 8; i++) {
//        int moveX = x + dxHorse[i];
//        int moveY = y + dyHorse[i];
//
//        if (moveX >= 0 && moveY >= 0 && moveX < H && moveY < W) {
//          if (check[moveX][moveY] == 0 && map[moveX][moveY] != 1) {
//            K -= 1;
//            check[moveX][moveY] = check[x][y] + 1;
//            dfs(depth + 1, new int[] {moveX, moveY});
//            K += 1;
//            check[moveX][moveY] = 0;
//          }
//        }
//      }
//    }
//
//    for (int i = 0; i < 4 ;i++) {
//      int moveX = x + dx[i];
//      int moveY = y + dy[i];
//
//      if (moveX >= 0 && moveY >= 0 && moveX < H && moveY < W) {
//        if (check[moveX][moveY] == 0 && map[moveX][moveY] != 1) {
//          check[moveX][moveY] = check[x][y] + 1;
//          dfs(depth + 1, new int[] {moveX, moveY});
//          check[moveX][moveY] = 0;
//        }
//      }
//
//    }
//  }

}