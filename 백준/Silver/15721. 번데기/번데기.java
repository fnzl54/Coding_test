import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int T = sc.nextInt();
    int G = sc.nextInt();
    int b_num = 0, d_num = 0;
    boolean game = true;
    int game_num = 2;
    int answer = 0;

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < A; i++) {
      queue.offer(i);
    }

    while (game) {

      for (int i = 0; i < 4; i++) {
        if(i % 2 == 0) {
          b_num++;
          if (check_game(G, 0, b_num, T)) {
            answer = queue.poll();
            game = false;
            break;
          }
          queue.offer(queue.poll());
        } else {
          d_num++;
          if (check_game(G, 1, d_num, T)) {
            answer = queue.poll();
            game = false;
            break;
          }
          queue.offer(queue.poll());
        }
      }

      for (int i = 0; i < game_num; i++) {
        b_num++;
        if (check_game(G, 0, b_num, T)) {
          answer = queue.poll();
          game = false;
          break;
        }
        queue.offer(queue.poll());
      }

      for (int i = 0; i < game_num; i++) {
        d_num++;
        if (check_game(G, 1, d_num, T)) {
          answer = queue.poll();
          game = false;
          break;
        }
        queue.offer(queue.poll());
      }

      game_num++;

    }

    System.out.println(answer);


  }

  static boolean check_game(int G, int check_G, int count, int answer_count) {
    // 정답을 찾은 경우
    if (G == check_G && count == answer_count) {
      return true;
    }
    return false;
  }

}
