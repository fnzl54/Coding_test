public class 나머지가1이되는수 {
    public static void main(String[] args) {
        int n = 10;

        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
