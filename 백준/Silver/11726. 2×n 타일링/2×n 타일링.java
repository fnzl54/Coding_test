import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] case_list = new int[1001];

    case_list[1] = 1;
    case_list[2] = 2;

    for (int i = 3; i < 1001; i++) {
      case_list[i] = (case_list[i-1] + case_list[i-2]) % 10007;
    }

    System.out.println(case_list[n]);
  }
}
