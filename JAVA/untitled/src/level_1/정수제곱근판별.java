package level_1;

public class 정수제곱근판별 {
    public static void main(String[] args) {

        long n = 121;
        long answer = 0;


        Double sqrtNum = Math.sqrt(n);

        if (sqrtNum % 1 == 0) {
            answer = (long) Math.pow(sqrtNum + 1, 2);
        } else {
            answer = -1;
        }

        System.out.println(answer);
    }
}
