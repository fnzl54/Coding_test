import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int answer = 0, currentEnd = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    ArrayList<Integer> keys = new ArrayList<>();

    // 끝나는 시간을 기준으로 정렬
    for (int n = 0; n < N; n++) {
      StringTokenizer st =new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      List<Integer> temp = map.getOrDefault(b, new ArrayList<>());
      temp.add(a);
      Collections.sort(temp);
      map.put(b, temp);
    }

    //key 값 정렬
    for(int i : map.keySet()) {
      keys.add(i);
    }

    Collections.sort(keys);

    // 끝나는 시간 이후에 값이 존재하면 다음 회의를 진행
    for (int k : keys) {
      for (int i = 0; i < map.get(k).size(); i++) {
        if (currentEnd <= map.get(k).get(i)) {
          answer++;
          currentEnd = k;
        }
      }
    }

    System.out.println(answer);
  }
}