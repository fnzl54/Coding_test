import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();
    int[] x_position = new int[N];
    double[] sum_position = new double[N];
    int check_num = 0;

    for (int i = 0; i < N; i++) {
      x_position[i] = sc.nextInt();
    }

    sum_position[N-1] = x_position[N-1];

    for (int i = N-2; i > 0; i--) {
      sum_position[i] = sum_position[i+1] + x_position[i];
    }

    for (int i = 1; i < N; i++) {
      double middle = sum_position[i] / (N - i);
      if (!(x_position[i-1] - L < middle && middle < x_position[i-1] + L)) {
        check_num = 1;
        break;
      }
    }

    if (check_num == 0) {
      System.out.println("stable");
    } else {
      System.out.println("unstable");
    }
  }
}