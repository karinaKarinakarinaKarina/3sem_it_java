import java.util.Arrays;
import java.util.Random;

public class second_tasks {
    
    public static void main(String[] args) {

        // task1
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(duplicateChars("clara"));

        // task2
        System.out.println(getInitials("Rayan Gosling"));
        System.out.println(getInitials("Varvara Cool"));

        // task3
        int[] arr1 = {44, 32, 86, 19};
        int[] arr2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(arr1));
        System.out.println(differenceEvenOdd(arr2));
        
        // task4
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 2, 3, 4, 6};
        System.out.println(equaltoavg(arr3));
        System.out.println(equaltoavg(arr4));
        
        // task5
        int[] arr5 = {1, 2, 3};
        int[] arr6 = {3, 3, -2, 408, 3, 31};
        System.out.println(indexMult(arr5));
        System.out.println(indexMult(arr6));

        // task6
        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown fox."));


        // task7 
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        // task8 
        System.out.println(pseudoHash(0));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(5));

        // task9
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        // task10
        System.out.println(isAnagram("eleven plus two", "twelve plus one") );
        System.out.println(isAnagram("hello", "world"));


        
    }

    // task1
    public static boolean duplicateChars(String str) {
    for (int i = 0; i < str.length(); i++) {
        for (int j = i + 1; j < str.length(); j++) {
            if (str.charAt(i) == str.charAt(j)) {
                return true;
                }
            }
        }
        return false;
    }

    // task2
    public static String getInitials(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : names) {
            initials.append(name.charAt(0));
        }
        return initials.toString();
    }

    // task3 
    public static int differenceEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int num: arr) {
            if (num % 2 == 0) {
                even += num;
            }
            else {
                odd += num;
            }
        }
        return even - odd;
    }
    
    // task4
    public static boolean equaltoavg(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        for (int num: arr) {
            if (num == avg) {
                return true;
            }
        }
        return false;
        
    }
    
    
    // task5
    public static int[] indexMult(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * i;
        }
        return result;
    }

    // task6 
    public static String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >=0; i--){
            char c = str.charAt(i);
            result +=c;
    }
        return result;
    }


    // task7
    public static int Tribonacci(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        int[] sequence = new int[n + 1];
        sequence[0] = 0;
        sequence[1] = 0;
        sequence[2] = 1;
        for (int i = 3; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2] + sequence[i - 3];
        }
        return sequence[n-1];
    }


    // task8 
    public static String pseudoHash(int length) {
        StringBuilder hash = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(16);
            hash.append(Integer.toHexString(num));
        }
        return hash.toString();
    }

    // task9
    public static String botHelper(String message) {
        if (message.toLowerCase().contains("help")) {
            return "Calling for a staff member";
        } else {
            return "Keep waiting";
        }
    }


    // task10
    public static boolean isAnagram(String str1, String str2) {
    char[] arr1 = str1.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
    char[] arr2 = str2.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
    }

}