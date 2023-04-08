public class 문자열내p와y의개수 {
    public static void main(String[] args) {
        String s = "pPyy";
        boolean answer = true;

        int pNum = 0;
        int yNum = 0;

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                pNum++;
            } else if (s.charAt(i) == 'y') {
                yNum++;
            }
        }

        if(pNum != yNum) answer = false;

        System.out.println(answer);
    }
}
