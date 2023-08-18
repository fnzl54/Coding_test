import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    Character[][] DNA_list = new Character[N][M];
    HashMap<Character, Integer> DNA_kind = new HashMap<>();
    String answer = "";
    int answer_num = 0;

    for (int i = 0; i < N; i++) {
      String temp_DNA = sc.next();

      for (int j = 0; j < M; j++) {
        DNA_list[i][j] = temp_DNA.charAt(j);
      }
    }

    for (int i = 0; i < M; i++) {
      DNA_kind.clear();

      for (int j = 0; j < N; j++) {
        int count = DNA_kind.getOrDefault(DNA_list[j][i], 0) + 1;
        DNA_kind.put(DNA_list[j][i], count);
      }

      int max_num = 0;
      String max_str = "";
      List<Character> key_set = new ArrayList<>(DNA_kind.keySet());
      Collections.sort(key_set);
      for (char c : key_set) {
        if (max_num < DNA_kind.get(c)) {
          max_num = DNA_kind.get(c);
          max_str = String.valueOf(c);
        }
      }

      answer += max_str;
    }


    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (DNA_list[i][j] != answer.charAt(j)) {
          answer_num++;
        }
      }
    }

    System.out.println(answer);
    System.out.println(answer_num);
  }
}