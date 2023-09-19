import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int max = 0;
    HashMap<String, Integer> book = new HashMap<>();
    ArrayList<String> best_list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String temp_book = sc.next();
      book.put(temp_book, book.getOrDefault(temp_book, 0) + 1);
    }

    for (String s : book.keySet()) {
      if (book.get(s) > max) {
        max = book.get(s);
        best_list.clear();
        best_list.add(s);
      } else if (book.get(s) == max) {
        best_list.add(s);
      }
    }

    Collections.sort(best_list);
    System.out.println(best_list.get(0));
  }
}