import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    List<Integer> person = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      person.add(i);
    }

    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K-1; j++) {

        if (count >= person.size()-1) {
          count = 0;
        } else {
          count++;
        }

      }

      if (count == person.size()-1) {
        answer.add(person.get(count));
        person.remove(count);
        count = 0;
      } else {
        answer.add(person.get(count));
        person.remove(count);
      }

    }

    System.out.print("<");
    for (int i = 0; i < answer.size(); i++) {
      if (i == answer.size() - 1) {
        System.out.print(answer.get(i));
      } else {
        System.out.print(answer.get(i) + ", ");
      }
    }
    System.out.print(">");
  }
}