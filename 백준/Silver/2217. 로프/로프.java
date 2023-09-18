import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] rope_list = new int[N];
    int max = 0;

    for (int i = 0; i < N; i++) {
      rope_list[i] = sc.nextInt();
    }

    Arrays.sort(rope_list);

    for (int i = N-1; i >= 0; i--) {
      if (rope_list[i] * (N-i) > max) {
        max = rope_list[i] * (N-i);
      } 
    }

    System.out.println(max);

  }
}
