import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    Integer[] milk_list = new Integer[N];
    int answer = 0;

    for (int i = 0; i < N; i++) {
      milk_list[i] = sc.nextInt();
    }

    Arrays.sort(milk_list, Collections.reverseOrder());

    for (int i = 0; i < N; i+=3) {
      if (i + 1 == N) {
        answer += milk_list[i];
      } else {
        answer += milk_list[i] + milk_list[i+1];
      }
    }

    System.out.println(answer);
  }
}