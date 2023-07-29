import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int start = N - String.valueOf(N).length() * 9;
    int answer = 0;

    for (int i = start; i < N; i++) {
      int temp  = i;

      for (char c : String.valueOf(i).toCharArray()) {
        temp += c - '0';
      }

      if (temp == N) {
        answer = i;
        break;
      }
    }

    System.out.println(answer);
  }

}
