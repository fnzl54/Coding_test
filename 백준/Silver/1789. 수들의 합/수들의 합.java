import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long S = sc.nextLong();
    int N = 1;

    while (S > N) {
      S -= N;
      N++;
    }

    if (S == N) {
      System.out.println(N);
    } else {
      System.out.println(N-1);
    }

  }
}