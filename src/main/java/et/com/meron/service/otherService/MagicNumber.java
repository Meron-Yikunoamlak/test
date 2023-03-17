package et.com.meron.service.otherService;

public class MagicNumber {

    public static String sum(int given) {
        int sum = 0;
        String string = String.valueOf(given);
        char[] chars = string.toCharArray();

        while ( chars.length != 1 )
            for (int i = 0; i < chars.length; i++) {
                Integer number = Integer.parseInt(String.valueOf(chars[i]));
                System.out.println(number);
                sum += number;
            }

        if (sum == 1) return "magic number";
        else return "not magic number";

        }


    public static void main(String[] args) {
        System.out.println(sum(163));
    }
}
