import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String X = sc.next();
    StringBuilder temp = new StringBuilder();
    List<String> X_split = new ArrayList<>();
    for (char c : X.toCharArray()) {
      if (c == 'X') {
        temp.append('X');
      } else {
        X_split.add(temp.toString());
        X_split.add(".");
        temp.setLength(0);
      }
    }
    X_split.add(temp.toString());

    StringBuilder answer = new StringBuilder();
    boolean check_num = true;

    for (String s : X_split) {
      if (s.equals(".")) {
        answer.append(".");
      } else {
        int temp_size = s.length();
        while (temp_size % 2 == 0 && temp_size >= 2) {
          if (temp_size >= 4) {
            answer.append("AAAA");
            temp_size -= 4;
          } else if (temp_size >= 2) {
            answer.append("BB");
            temp_size -= 2;
          }
        }
        if (temp_size != 0) {
          check_num = false;
          break;
        }
      }
    }

    if (check_num) {
      System.out.println(answer);
    } else {
      System.out.println("-1");
    }

  }
}