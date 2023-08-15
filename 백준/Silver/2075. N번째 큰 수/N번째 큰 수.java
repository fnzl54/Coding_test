import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    Queue<Integer> q = new PriorityQueue<>();


    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int num = sc.nextInt();

        if(q.size() == N) {
          if(q.peek() < num) {
            q.poll();
            q.add(num);
          }
        }else {
          q.add(num);
        }
      }
    }

    System.out.println(q.peek());

  }
}