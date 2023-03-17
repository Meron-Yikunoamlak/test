package et.com.meron.service.otherService;

public class MagicNumber {

    public static int checkMagicNumber(int number) {

        String noToString = String.valueOf(number);
        int sum = 0;
        char[] chars = noToString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            Integer no = (int) chars[i];

            System.out.println(no);

            sum += no;
        }
        return sum;

    }


    public static Integer reverse(int str) {
//        char[] chars = str.toCharArray();
//        int sum = 0;
//        for (int i = 0; i < chars.length; i++) {
//            Integer number = Integer.valueOf(chars[i]);
//            System.out.println(number);
//            sum += number;
//        }
//        return sum;





        char[] chars = Character.toChars(str);
        System.out.println(chars.length);
        for (int i = 1; i <= chars.length; i++) {
//            String ch = str.substring(i, i + 1);


        }
            return null;


    }


    public static void main(String[] args) {
//        System.out.println(reverse(String.valueOf(163)));
        System.out.println(reverse(163));
    }
}
