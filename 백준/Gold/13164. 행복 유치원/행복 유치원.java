import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Integer> subList = new ArrayList<>();

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int answer = 0;

    int[] child = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      child[n] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < N-1; i++){
      subList.add(child[i+1] - child[i]);
    }

    Collections.sort(subList);

    for(int i = 0; i < N-K; i++){
      answer += subList.get(i);
    }

    System.out.println(answer);
  }
}