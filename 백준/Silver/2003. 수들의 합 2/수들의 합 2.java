import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int first = 0, end = 0, temp_add = 0, answer = 0;;
    int[] input_list = new int[N];

    for (int i = 0; i < N; i++) {
      input_list[i] = sc.nextInt();
    }

    while(true) {
      if (temp_add >= M) {
        temp_add -= input_list[first];
        first++;
      } else if (end == N) {
        break;
      } else {
        temp_add += input_list[end];
        end++;
      }

      if (temp_add == M) {
        answer++;
      }
    }

    System.out.println(answer);
  }
}