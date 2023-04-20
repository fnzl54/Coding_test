package level_2;

public class 다음큰숫자 {
    public static void main(String[] args) {

        int n = 15;
        int answer = 0;

        //logic
        int nowCount = Integer.bitCount(n);

        while(true){
            n++;
            int nextCount = Integer.bitCount(n);

            if(nowCount == nextCount){
                break;
            }
        }

        answer = n;
        //output
        System.out.println(answer);
    }
}


// 시간초과로 틀림

//public class 다음큰숫자 {
//    public static void main(String[] args) {
//        
//        int n = 78;
//        int answer = n;
//
//        //logic
//        boolean check = false;
//        long input_one_num = check_one_num(n);
//
//        while (!check) {
//            answer++;
//
//            if (input_one_num == check_one_num(answer)) {
//                check = true;
//            }
//
//        }
//
//
//        //output
//        System.out.println(answer);
//    }
//
//    public static long check_one_num(int num) {
//        String str_num = Integer.toString(num, 2);
//
//        return str_num.chars()
//                .filter(c -> c == '1')
//                .count();
//    }
//}
