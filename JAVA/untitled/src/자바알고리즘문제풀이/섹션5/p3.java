import java.util.*;

public class p3 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] input = new int[N][N];
    List<Stack<Integer>> board = new ArrayList<Stack<Integer>>();

    int answer = 0;

    for (int i = 0; i < N; i++) {
      board.add (new Stack<Integer>() );
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        input[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = N-1 ; j >= 0; j--) {
        if (input[j][i] != 0) {
          board.get(i).add(input[j][i]);
        }
      }
    }


    int M = sc.nextInt();
    int[] moves = new int[M];

    for (int i = 0; i < M; i++) {
      moves[i] = sc.nextInt();
    }

    Stack<Integer> pocket = new Stack<Integer>();

    for (int i = 0; i < M; i++) {
      int board_num = moves[i] - 1;

      if (!board.get(board_num).empty()) {
        if (pocket.size() == 0) {
          pocket.add(board.get(board_num).pop());
        } else if (pocket.peek() == board.get(board_num).peek()) {
          pocket.pop();
          board.get(board_num).pop();
          answer += 2;
        } else {
          pocket.add(board.get(board_num).pop());
        }
      }

    }
    System.out.print(answer);
  }
}