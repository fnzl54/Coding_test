import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int current_num = 666;
    int count = 1;

    while(count != N) {
      current_num++;

      if (String.valueOf(current_num).contains("666")) {
        count++;
      }
    }

    System.out.println(current_num);
  }
}