import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    double tree_count = 0;

    while (sc.hasNext())  {
      String tree_name = sc.nextLine();
      map.put(tree_name, map.getOrDefault(tree_name, 0) + 1);
      tree_count++;
    }

    ArrayList<String> key_list = new ArrayList<>(map.keySet());
    Collections.sort(key_list);

    for (String s : key_list) {
      String ps = String.format("%.4f", (map.get(s) / tree_count) * 100);
      sb.append(s).append(" ").append(ps).append("\n");
    }

    System.out.println(sb);
  }
}