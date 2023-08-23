import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int answer = 0;

    for (int i = 0; i <= N / 5; i++) {
      int temp_answer = 0;
      int temp_N = N;


      temp_answer += i;
      temp_N -= i * 5;

      temp_answer += temp_N / 2;
      temp_N -= (temp_N / 2) * 2;

      if (temp_N == 0) {
        answer = temp_answer;
      }
    }

    if (answer != 0) {
      System.out.println(answer);
    } else {
      System.out.println("-1");
    }
  }
}