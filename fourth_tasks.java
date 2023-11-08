import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fourth_tasks {
    public static void main(String[] args) {
        // task1 
        System.out.println(removeDuplicates("abracadabra")); 
        System.out.println(removeDuplicates("paparazzi")); 

        // task2
        System.out.println(generateBrackets(1)); 
        System.out.println(generateBrackets(2)); 
        System.out.println(generateBrackets(3));

        // task3
        System.out.println(generateBinaryCombinations(3)); 
        System.out.println(generateBinaryCombinations(6)); 

        // task4
        System.out.println(alphabeticRow("abcdjuwx")); 
        System.out.println(alphabeticRow("klmabzyxw")); 

        // task5
        System.out.println(countAndSort("aaabbcdd"));
        System.out.println(countAndSort("vvvvaajaaaaa"));

        // task6
        System.out.println(convertToNum("eight")); 
        System.out.println(convertToNum("thirty one"));
        
        // task7
        System.out.println(uniqueSubstring("123412324")); 
        System.out.println(uniqueSubstring("77897898"));

        // task8
        int[][] matrix1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] matrix2 = {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}};
        System.out.println(shortestWay(matrix1));
        System.out.println(shortestWay(matrix2));

        // task9
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); 
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        // task10
        System.out.println(switchNums(519, 723));
    } 

    // task1
    public static String removeDuplicates(String str) {
    // Если строка пустая или состоит из одного символа, возвращаем её
        if (str == null || str.length() <= 1) {
            return str;
            }
        // Проверяем, есть ли текущий символ в оставшейся части строки
        if (str.substring(1).contains(str.substring(0, 1))) {
            // Если есть, вызываем рекурсивно функцию для оставшейся части строки
            return removeDuplicates(str.substring(1));
        } else {
            // Если нет, возвращаем текущий символ + результат рекурсивного вызова для оставшейся части строки
            return str.substring(0, 1) + removeDuplicates(str.substring(1));
        }
    }

    // task2
    public static List<String> generateBrackets(int n) {
        // Функция generateBrackets генерирует все возможные комбинации скобок с заданным количеством открытых и закрытых скобок (n).
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result, String current, int open, int close, int max) {
        // - result: список, в который добавляются все комбинации скобок, current: текущая комбинация скобок, open: количество открытых скобок в текущей комбинации, close: количество закрытых скобок в текущей комбинации.
        // - max: максимальное количество открытых и закрытых скобок.
        if (current.length() == max * 2) {
            // Функция добавляет текущую комбинацию в список result, если она имеет длину max*2 (т.е. содержит все открытые и закрытые скобки).
            result.add(current);
            return;
        }
        if (open < max) {
            //Если количество открытых скобок меньше максимального, функция добавляет открывающую скобку к текущей комбинации и вызывает себя рекурсивно 
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            //Если количество закрытых скобок меньше количества открытых, функция добавляет закрывающую скобку к текущей комбинации и вызывает себя рекурсивно
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    // task3
    // Затем функция вызывает себя рекурсивно два раза:
    public static List<String> generateBinaryCombinations(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int index, int n) {
        // result: список, в который добавляются все комбинации, current: текущая комбинация, index: индекс текущего символа в комбинации,n: длина комбинаций.
        if (index == n) {
            // Функция добавляет текущую комбинацию в список result, если комбинация имеет длину n).
            result.add(current);
            return;
        }

        if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
        // Если текущая комбинация пуста или последний символ равен '1', функция добавляет символ '0' к текущей комбинации и вызывает себя рекурсивно
            backtrack(result, current + "0", index + 1, n);
        }
        // - Функция всегда добавляет символ '1' к текущей комбинации и вызывает себя рекурсивно с увеличенным индексом.
        backtrack(result, current + "1", index + 1, n);
    }

    // task4
    // Функция alphabeticRow возвращает самую длинную последовательность букв в алфавитном порядке из заданной строки.
    public static String alphabeticRow(String input) {
        //longestSeq для хранения самой длинной последовательности и currentSeq для хранения текущей последовательности.
        String longestSeq = "";
        String currentSeq = "";
        
        for (int i = 0; i < input.length(); i++) {
            if (currentSeq.isEmpty() || input.charAt(i) - 1 == currentSeq.charAt(currentSeq.length() - 1)) {
                currentSeq += input.charAt(i);
            } else {
            // Если текущий символ не следует за предыдущим в алфавитном порядке
                if (longestSeq.length() < currentSeq.length()) {
                    // Если текущая последовательность длиннее самой длинной последовательности, функция обновляет longestSeq
                    longestSeq = currentSeq;
                }
                currentSeq = String.valueOf(input.charAt(i));
            }
        }
        
        if (longestSeq.length() < currentSeq.length()) {
            longestSeq = currentSeq;
        }
        
        return longestSeq;
    }

    // task5
    public static String countAndSort(String str) {
        List<String> patterns = new ArrayList<>(); // Создаем список для хранения букв и кол-во их повторений подряд
        int count = 1; // Счетчик для подсчета повторений символа.
        char prev = str.charAt(0); // Первый символ строки.

        //Заполняем список символами и кол-вом их повторений
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == prev) {
                count++;
            } else {
                patterns.add(prev + Integer.toString(count));
                count = 1;
                prev = current;
            }
        }

        patterns.add(prev + Integer.toString(count));

        // Сортировка пузырьком по значению int от второго до последнего символа в строке.
        for (int i = 0; i < patterns.size() - 1; i++) {
            for (int j = 0; j < patterns.size() - 1 - i; j++) {
                int value1 = Integer.parseInt(patterns.get(j).substring(1)); // Получаем значение для первой строки.
                int value2 = Integer.parseInt(patterns.get(j + 1).substring(1)); // Получаем значение для второй строки.

                if (value1 > value2) {
                    String temp = patterns.get(j);
                    patterns.set(j, patterns.get(j + 1));
                    patterns.set(j + 1, temp);
                }
            }
        }

        // Собираем отсортированные буквенные паттерны в результирующую строку.
        StringBuilder result = new StringBuilder();
        for (String pattern : patterns) {
            result.append(pattern);
        }

        return result.toString();
    }

    // task6 
    // Функция convertToNum преобразует строку, содержащую числительное на английском языке, в числовое значение.
        public static int convertToNum(String str) {
        Map<String, Integer> numMap = new HashMap<>();
        //Map numMap для соответствия числительных и числовых значений.
        numMap.put("zero", 0);
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);
        numMap.put("four", 4);
        numMap.put("five", 5);
        numMap.put("six", 6);
        numMap.put("seven", 7);
        numMap.put("eight", 8);
        numMap.put("nine", 9);
        numMap.put("ten", 10);
        numMap.put("eleven", 11);
        numMap.put("twelve", 12);
        numMap.put("thirteen", 13);
        numMap.put("fourteen", 14);
        numMap.put("fifteen", 15);
        numMap.put("sixteen", 16);
        numMap.put("seventeen", 17);
        numMap.put("eighteen", 18);
        numMap.put("nineteen", 19);
        numMap.put("twenty", 20);
        numMap.put("thirty", 30);
        numMap.put("forty", 40);
        numMap.put("fifty", 50);
        numMap.put("sixty", 60);
        numMap.put("seventy", 70);
        numMap.put("eighty", 80);
        numMap.put("ninety", 90);
        
        // Затем функция разбивает входную строку на отдельные слова с помощью метода split(" ").
        String[] words = str.split(" ");
        int result = 0;

        // Далее функция проходит по каждому слову и, если оно содержится в numMap, добавляет его числовое значение к результату
        for (String word : words) {
            if (numMap.containsKey(word)) {
                result += numMap.get(word);
            }
        }
        
        return result;
    }

    // task7
    // Функция uniqueSubstring возвращает самую длинную подстроку без повторяющихся символов из заданной строки.
    public static String uniqueSubstring(String str) {
        String longestSubstring = "";
        String currentSubstring = "";

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentSubstring.indexOf(currentChar) == -1) {
                currentSubstring += currentChar;
            } else {
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = "" + currentChar;
            }
        }

        if (currentSubstring.length() > longestSubstring.length()) {
            longestSubstring = currentSubstring;
        }

        return longestSubstring;
    }

    // task8
    // Функция shortestWay принимает на вход двумерный массив matrix и возвращает минимальную сумму пути от верхнего левого угла до нижнего правого угла.
    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;
        //создаем двумерный массив dp размером n*n, где n - размерность matrix.
        int[][] dp = new int[n][n];
        // заполняем первую строку и первый столбец массива dp суммами элементов соответствующих строк и столбцов матрицы matrix.
        dp[0][0] = matrix[0][0];
        
        // Далее функция проходит по каждому элементу массива dp, начиная со второй строки и второго столбца, и вычисляет минимальную сумму пути до текущего элемента.
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        
        return dp[n-1][n-1];
    }

    // task9
    // Функция numericOrder принимает на вход строку input и возвращает новую строку, в которой слова упорядочены по числовому значению, указанному в каждом слове.
    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        String[] orderedWords = new String[words.length];
        
        for (String word : words) {
            // Затем функция проходит по каждому слову и извлекает числовое значение, удаляя все символы, кроме цифр
            int index = Integer.parseInt(word.replaceAll("[^0-9]", "")) - 1;
            // Затем функция помещает слово в соответствующую позицию в массиве orderedWords, используя полученное числовое значение как индекс.
            orderedWords[index] = word.replaceAll("[0-9]", "");
        }
        
        return String.join(" ", orderedWords);
    }

    // task10
    // Функция switchNums принимает на вход два числа number1 и number2 и возвращает число, полученное из number2 путем замены его цифр на цифры из number1 в порядке возрастания.
    public static Integer switchNums (int number1, int number2) {
        //преобразуем число number1 и 2 в массив символов с помощью метода toCharArray().
        char[] array1 = Integer.toString(number1).toCharArray();
        Arrays.sort(array1);
        char[] array2 = Integer.toString(number2).toCharArray();
        int i = 0;
        while (i < array2.length){
            int j = 0;
            while (j < array1.length) {
                if (array2[i] < array1[j]) {
                    // Если элемент array2 меньше элемента array1, то он заменяется на элемент array1, а элемент array1 становится равным 0.
                    array2[i] = array1[j];
                    array1[j] = 0;
                }
                j++;
            }
            i++;
        }
        return Integer.valueOf(String.valueOf(array2));
    }
}






