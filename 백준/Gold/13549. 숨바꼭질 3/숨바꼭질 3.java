import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] visited = new int[100001];
    visited[N] = 1;
      
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {N, 1});

    while(!q.isEmpty()) {
      int[] now = q.poll();
      int point = now[0];
      int time = now[1];

      if(point+1>=0 && point+1<=100000){
        if(visited[point+1] == 0 || visited[point+1] > time+1){
          visited[point+1] = time+1;
          q.add(new int[] {point + 1, time + 1});
        }
      }

      if(point-1>=0 && point-1<=100000){
        if(visited[point-1] == 0 || visited[point-1] > time+1) {
          visited[point - 1] = time + 1;
          q.add(new int[] {point - 1, time + 1});
        }
      }

      if(point*2>=0 && point*2<=100000){ // 순간이동
        if(visited[point*2] == 0 || visited[point*2] > time) {
          visited[point*2] = time;
          q.add(new int[] {point*2, time});
        }
      }
    }

    System.out.println(visited[K]-1);
  }
}