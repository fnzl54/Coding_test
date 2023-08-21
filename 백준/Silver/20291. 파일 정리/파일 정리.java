import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    HashMap<String, Integer> file_map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      String temp_file = sc.next();
      temp_file = temp_file.split("\\.")[1];

      file_map.put(temp_file, file_map.getOrDefault(temp_file, 0) + 1);
    }

    List<String> file_key = new ArrayList<>(file_map.keySet());
    Collections.sort(file_key);

    for (String s : file_key) {
      sb.append(s + " " + file_map.get(s));
      sb.append("\n");
    }

    System.out.println(sb);

  }
}
