import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine().toLowerCase();
    ArrayList<String> inputList = new ArrayList<>();
    int start = 0;

    if (!input.contains("f") || input.length() % 4 != 0) {
      System.out.println("0");
      return;
    }

    for (int i = 0; i < input.length()-1; i++) {
      if (input.charAt(i) == 'f' && input.charAt(i+1) != 'f') {
        inputList.add(input.substring(start, i+1));
        start = i+1;
      }
    }

    inputList.add(input.substring(start));

    for (String s : inputList) {
      int count = 0;
      StringBuilder sb = new StringBuilder();

      if (s.length() % 4 != 0 || s.charAt(0) != 'w') {
        System.out.println("0");
        return;
      }

      for (char c : s.toCharArray()) {
        if (c != 'w') {
          break;
        }
        count++;
      }

      for (int i = 0; i < 4; i++) {
        if (i * count >= s.length()) {
          System.out.println("0");
          return;
        } else {
          sb.append(s.charAt(i*count));
        }
      }

      if (!sb.toString().equals("wolf")) {
        System.out.println("0");
        return;
      }
    }

    System.out.println("1");
  }
}