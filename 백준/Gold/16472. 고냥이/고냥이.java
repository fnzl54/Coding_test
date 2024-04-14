import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  static int N, answer = 0;
  static String input;
  static int[] alphabet;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    input = br.readLine();

    int count = 0, left = 0, right = 0;
    alphabet = new int[26];

    alphabet[input.charAt(left) - 'a']++;
    count++;

    while (right < input.length() - 1) {
      right++;
      alphabet[input.charAt(right) - 'a']++;

      if (alphabet[input.charAt(right) - 'a'] == 1) {
        count++;
      }

      while (count > N && left < right) {
        alphabet[input.charAt(left) - 'a']--;
        if (alphabet[input.charAt(left) - 'a'] == 0) {
          count--;
        }
        left++;
      }

      answer = Math.max(answer, right - left + 1);
    }

    System.out.println(answer);
  }

}
