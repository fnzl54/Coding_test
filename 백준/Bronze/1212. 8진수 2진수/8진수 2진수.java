import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String num = sc.next();
    StringBuilder sb = new StringBuilder();
    int i = 0;

    for (char c : num.toCharArray()) {
      String temp = Integer.toBinaryString(c - '0');
      if (temp.length() == 1 && i!=0) {
        temp = "00" + temp;
      } else if (temp.length() == 2 && i!=0) {
        temp = "0" + temp;
      }
      sb.append(temp);
      i++;
    }

    System.out.println(sb);

  }
}
