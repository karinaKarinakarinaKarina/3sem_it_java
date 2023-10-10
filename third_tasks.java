import java.util.Arrays;

public class third_tasks {
    public static void main(String[] args) {
        // task1
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code"));
        // task2
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(stringTransform("hello"));
        // task3
        System.out.println(doesBlockkFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockkFit(1, 2, 2, 1, 1));
        // task4
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        // task5
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        // task6
        System.out.println(Arrays.toString(salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}})));
        // task7
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        // task8
        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));

        // task9
        System.out.println(commonVovel("Hello world"));

        // task10
        System.out.println(Arrays.deepToString(dataScience(5, new int[][]{
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}})));

    }

    // task1
    public static String replaceVovels (String line) {
        String alphabet = "AEIOUYaeiouy"; //все гласные буквы в верхнем и нижнем регистре. 
        StringBuilder outputLine = new StringBuilder();
        for (int i = 0; i < line.length(); i++) { //проверка каждого символа строки на принадлежность к алфавиту гласных букв
            if (alphabet.indexOf(line.charAt(i)) >= 0) {
                outputLine.append("*");
            }
            else {
                outputLine.append(line.charAt(i));
            }
        }
        return outputLine.toString();
    }

    // task2
    public static String stringTransform (String line) {
        StringBuilder outputLine = new StringBuilder();
        int i = 0;

        for (i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) == line.charAt(i+1)) {
                outputLine.append("Double");
                outputLine.append(line.substring(i, i+1).toUpperCase());
                i++;
            }
            else {
                outputLine.append(line.charAt(i));
            }
        }
        if (i < line.length()) {
            outputLine.append(line.charAt(i));
        }

        return outputLine.toString();
    }

    // task3
    public static boolean doesBlockkFit (int a, int b, int c, int w, int h) {
        int[] cube = {a, b, c};
        int[] hole = {w, h};
        Arrays.sort(cube);
        Arrays.sort(hole);

        return cube[0] <= hole[0] && cube[1] <= hole[1];
    }

    // task4
    public static boolean numCheck (int num) {
        int num1 = num;
        int num2 = 0;

        while (num > 0) {
            num2 += (int) Math.pow(num%10, 2);
            num /= 10;
        }

        return num1%2 == num2%2;
    }

    // task5 
    public static int countRoots (int[] args) {
        int a = args[0];
        int b = args[1];
        int c = args[2];
        int d = (int) (Math.pow(b, 2) - 4*a*c);

        if (d > 0) {
            return 2;
        }
        else if (d == 0) {
            return 1;
        }
        else {
           return 0;
        }
    }

    // task6
    public static String[] salesData (String[][] data) {
        String[] output = {};
        for (String[] line: data) {
            if (line.length == 5) {
                output = Arrays.copyOf(output, output.length+1);
                output[output.length-1] = line[0];
            }
        }
        return output;
    }

    // task7
    public static boolean validSplit (String line) {
        String[] words = line.split(" ");
        boolean output = true;
        int i = 1;
        while (i < words.length & output) {
            String word1 = words[i-1];
            String word2 = words[i];
            if (word1.charAt(word1.length()-1) != word2.charAt(0)) {
                output = false;
            }
            i++;
        }
        return output;
    }

    // task8
    public static boolean waveForm (int[] numbers) {
        boolean output = true;
        int i = 0;
        while (i < numbers.length - 2 & output) {
            if (!(((numbers[i] > numbers[i+1]) != (numbers[i+1] > numbers[i+2])) & ((numbers[i] != numbers[i+1]) & (numbers[i+1] != numbers[i+2])))) {
                output = false;
            }
            i++;
        }
        return output;
    }

    // task9
    public static String commonVovel (String line) {
        String alphabet = "aeiouy";
        int[] count = {0, 0, 0, 0, 0, 0};
        int mx = 0;
        String output = "";
        line = line.toLowerCase();
        for (int i=0; i<line.length(); i++) {
            int index = alphabet.indexOf(line.charAt(i));
            if (index >= 0) {
                count[index] += 1;
            }
        }
        for (int i=0; i<count.length; i++) {
            if (count[i] > mx) {
                mx = count[i];
                output = String.valueOf(alphabet.charAt(i));
            }
        }
        return output;
    }

    // task10
    public static int[][] dataScience (int n, int[][] data) {
        for (int i=0; i<n; i++) {
            float mean = 0;
            for (int j=0; j<n; j++) {
                if (j != i) {
                    mean += data[j][i];
                }
            }
            mean = Math.round(mean/4);
            data[i][i] = (int) mean;
        }
        return data;
    }
}
