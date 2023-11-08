package fifth_java_lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "В этом параграфе мы будем использовать набор данных «Amazon Top 50 Bestselling Books 2009 - 2019». Он состоит из информации о пятидесяти самых популярных книгах на Amazon за каждый год с 2009-го по 2019-й.";
        String regex = "\\d+(\\.\\d+)?"; // Регулярное выражение для поиска чисел

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String number = matcher.group();
                System.out.println(number);
            }
        } catch (java.util.regex.PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        } catch (java.lang.IllegalStateException e) {
            System.out.println("Ошибка при поиске чисел: " + e.getMessage());
        }
    }
}