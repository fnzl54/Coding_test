import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    List<Integer> crane = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      crane.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(crane, Collections.reverseOrder());

    int K = Integer.parseInt(br.readLine());
    List<Integer> box = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int k = 0; k < K; k++) {
      box.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(box, Collections.reverseOrder());

    // 크레인이 못 옮기는 경우
    if (crane.get(0) < box.get(0)) {
      System.out.println(-1);
      return;
    }

    // 크레인이 옮길수 있는 경우
    int time = 0;

    while(!box.isEmpty()) {
      int boxIdx = 0;
      for (int n = 0; n < N; ) {
        if (boxIdx == box.size()) {
          break;
        } else if (crane.get(n) >= box.get(boxIdx)) {
          box.remove(boxIdx);
          n++;
        } else {
          boxIdx++;
        }
      }

      time++;
    }

    System.out.println(time);

  }

}