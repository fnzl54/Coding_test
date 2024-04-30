import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  static String input;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    input = br.readLine();

    boolean isSameAll = true;

    for (int i = 0; i < input.length() / 2; i++) {
      if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
        System.out.println(input.length());
        return;
      }

      if (input.charAt(i) != input.charAt(i + 1)) {
        isSameAll = false;
      }
    }

    if (isSameAll) {
      System.out.println("-1");
    } else {
      System.out.println(input.length() - 1);
    }

  }

}