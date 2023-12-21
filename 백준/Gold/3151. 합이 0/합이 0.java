import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] student = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      student[n] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(student);

    long answer = 0;
    for (int n = 0; n < N; n++) {
      if (student[n] > 0) {
        break;
      }

      int left = n + 1;
      int right = N - 1;

      while (left < right) {
        int sum = student[n] + student[left] + student[right];

        if (sum == 0) {
          int l = 1;
          int r = 1;

          if (student[left] == student[right]) {
            int c = right - left + 1; // nCn을 위한 작업
            answer +=  c * (c - 1) / 2;
            break;
          }

          while (student[left] == student[left + 1]) {
            l++;
            left++;
          }

          while (student[right] == student[right - 1]) {
            r++;
            right--;
          }

          answer += l * r;
        }

        if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }

    System.out.println(answer);
  }

}