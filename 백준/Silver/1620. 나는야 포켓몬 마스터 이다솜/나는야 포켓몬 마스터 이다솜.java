import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    HashMap<String, Integer> name_map = new HashMap<>();
    HashMap<Integer, String> num_map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String temp_name = sc.next();

      name_map.put(temp_name, i+1);
      num_map.put(i+1, temp_name);
    }

    for (int i = 0; i < M; i++) {
      String input = sc.next();

      if ((int)input.charAt(0) >= 49 && (int)input.charAt(0) <= 57) {
        sb.append(num_map.get(Integer.valueOf(input))).append("\n");
      } else {
        sb.append(name_map.get(input)).append("\n");
      }
    }

    System.out.println(sb);
  }
}