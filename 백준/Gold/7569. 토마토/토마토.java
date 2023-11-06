import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    Queue<int[]> q = new LinkedList<>();
    int[][][] box = new int[H][N][M];
    int[] dx = {0, -1, 1, 0, 0, 0};
    int[] dy = {0, 0, 0, -1, 1, 0};
    int[] dz = {-1, 0, 0, 0, 0, 1};
    int answer = 0;

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
          box[h][n][m] = Integer.parseInt(st.nextToken());
          if (box[h][n][m] == 1) {
            q.add(new int[] {h, n, m});
          }
        }
      }
    }

    while (!q.isEmpty()) {
      int[] position = q.poll();
      int z = position[0];
      int x = position[1];
      int y = position[2];

      for (int i = 0; i < 6; i++) {
        int moveZ = z + dz[i];
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX < N && moveX >= 0 && moveY < M && moveY >= 0 && moveZ < H && moveZ >= 0) {
          if (box[moveZ][moveX][moveY] == 0) {
            q.add(new int[] {moveZ, moveX, moveY});
            box[moveZ][moveX][moveY] = box[z][x][y] + 1;
          }
        }
      }
    }

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (box[h][n][m] == 0) {
            System.out.println("-1");
            return;
          } else {
            answer = Math.max(answer, box[h][n][m]);
          }
        }
      }
    }

    System.out.println(answer-1);
  }
}