import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int point = 0;
    Deque<int[]> dq = new ArrayDeque<>();
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int[] temp = new int[] {sc.nextInt(), i+1};
      dq.add(temp);
    }


    for (int i = 0; i < N; i++) {
      point = dq.peek()[0];
      answer.add(dq.poll()[1]);

      if (dq.size() == 0) {
        break;
      }

      if (point < 0) {
        for (int j = 0; j < Math.abs(point); j++) {
          dq.addFirst(dq.pollLast());
        }
      } else {
        for (int j = 0; j < point-1; j++) {
          dq.add(dq.poll());
        }
      }

    }

    for (int i : answer) {
      System.out.print(i + " ");
    }

  }

}
