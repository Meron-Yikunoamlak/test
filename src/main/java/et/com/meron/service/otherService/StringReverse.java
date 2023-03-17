package et.com.meron.service.otherService;

public class StringReverse {

    /**
     * Let’s try to understand the below code –>
     *
     * <li>We have created a user-defined function called reverse().</li>
     * <li>The toCharArray() is the function used to convert the string into a sequence of characters.</li>
     * <li>After that, using the length() function, we are finding the length of the character array.</li>
     * <li>We are printing the reverse of the character array using a for a loop.</li>
     *
     * <li>The time complexity of the code is O(N).</li>
     * <li>The space complexity of the code is O(N).</li>
     *
     * @param str input parameter(in this example "entoto")
     * @return The reversed String
     */
    public static String reverse(String str) {
        String reversedString = "";
        char[] arrayOfCharacters = str.toCharArray();
        for (int i = arrayOfCharacters.length - 1; i >= 0; i--)
            reversedString += arrayOfCharacters[i];
        return reversedString;
    }



    /**
     * We can also use a while loop to reverse a string.
     *
     * <li>We have used the length() method to find the length of the input string “str”.</li>
     * <li>We run the while loop on the condition- length should be greater than zero.</li>
     * <li> Next, we print the string using the charAt() method, which returns the character at</li>
     * <li>the specified index of the given string. Lastly, we decrement the length variable “length”.</li>
     * <li>The time complexity of the function is O(N).</li>
     * <li>The space complexity of the function is O(N).</li>
     *
     * @param str input parameter(in this example "entoto")
     * @return The reversed String
     */
    public static String reverse2(String str) {
        String reversedString = "";
        int length = str.length();
        while (length > 0) {
            reversedString += str.charAt(length - 1);
            length--;
        }
        return reversedString;
    }


    public static void main(String[] args) {
        System.out.println(reverse("entoto"));
        System.out.println(reverse2("entoto"));
    }

}
