import java.util.*;

public class q8 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String answer = "NO";

    String s = sc.nextLine();
    s = s.toUpperCase().replaceAll("[^A-Z]", "");
    String sb = new StringBuilder(s).reverse().toString();

    if (s.equals(sb)) answer = "YES";

    System.out.print(answer);


  }
}