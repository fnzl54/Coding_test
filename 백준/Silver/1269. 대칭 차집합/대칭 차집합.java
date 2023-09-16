import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A_num = sc.nextInt();
    int B_num = sc.nextInt();
    int answer = 0;

    HashSet<Integer> A = new HashSet<>();
    HashSet<Integer> B = new HashSet<>();

    for (int i = 0; i < A_num; i++) {
      A.add(sc.nextInt());
    }

    for (int i = 0; i < B_num; i++) {
      B.add(sc.nextInt());
    }

    for (int i : A.toArray(new Integer[0])) {
      if (!B.contains(i)) {
        answer++;
      }
    }

    for (int i : B.toArray(new Integer[0])) {
      if (!A.contains(i)) {
        answer++;
      }
    }

    System.out.println(answer);
  }
}