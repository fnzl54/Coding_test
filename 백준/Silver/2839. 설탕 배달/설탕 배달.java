import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int answer = 0;

    while (N > 0) {
      if (N % 5 == 0) {
        answer += N / 5;
        break;
      } else if (N < 3) {
        answer = -1;
        break;
      }
      N -= 3;
      answer++;
    }

    System.out.println(answer);
  }
}