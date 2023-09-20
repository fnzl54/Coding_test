import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    HashMap<String, Integer> name = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String temp_name = sc.next();
      name.put(temp_name, name.getOrDefault(temp_name, 0) + 1);
    }

    for (int i = 0; i < N-1; i++) {
      String temp_name = sc.next();
      name.put(temp_name, name.get(temp_name) - 1);
    }

    for (String s : name.keySet()) {
      if(name.get(s) != 0) {
        System.out.println(s);
        break;
      }
    }
  }
}