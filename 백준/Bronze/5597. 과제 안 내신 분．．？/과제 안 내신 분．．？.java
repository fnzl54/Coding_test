import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < 28; i++) {
      map.put(sc.nextInt(), 0);
    }

    for (int i = 1; i < 31; i++) {
      if (!map.containsKey(i)) {
        System.out.println(i);
      }
    }

  }
}