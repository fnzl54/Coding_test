import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] list_a = new int[N];
    int[] list_b = new int[M];
    StringBuilder answer = new StringBuilder();
    int a = 0, b = 0;

    for (int i = 0; i < N; i++) {
      list_a[i] = sc.nextInt();
    }

    for (int i = 0; i < M; i++) {
      list_b[i] = sc.nextInt();
    }

    while (a < N && b < M) {
      if (list_a[a] < list_b[b]) {
        answer.append(list_a[a]);
        answer.append(" ");
        a++;
      } else {
        answer.append(list_b[b]);
        answer.append(" ");
        b++;
      }
    }

    if (a < N) {
      while (a < N) {
        answer.append(list_a[a]);
        answer.append(" ");
        a++;
      }
    } else {
      while (b < M) {
        answer.append(list_b[b]);
        answer.append(" ");
        b++;
      }
    }

    System.out.println(answer);
  }
}