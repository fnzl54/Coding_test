import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Long A = Long.parseLong(st.nextToken());
    Long B = Long.parseLong(st.nextToken());
    int count = 0;

    System.out.println(bfs(A, B, count));

  }

  static int bfs(Long A, Long B, int count){
    Queue<Long> q = new LinkedList<>();
    q.add(A);

    while(!q.isEmpty()){
      int size = q.size();

      for(int i=0; i<size; i++){
        long tmp = q.poll();
        if(tmp==B) {
          return count+1;
        }
        
        if(tmp*2<=B) {
          q.add(tmp * 2);
        }
        if(tmp*10+1<=B) {
          q.add(tmp*10+1);
        }
      }
      count++;
    }
    return -1;
  }
}