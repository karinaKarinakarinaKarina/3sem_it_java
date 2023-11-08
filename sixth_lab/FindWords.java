package fifth_java_lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FindWords {

    public static void main(String[] args) {
        String text = "Blabla and go away hahah";

        String letter = "a";

        String regex = "\\b" + letter + "\\w+";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректное регулярное выражение.");
        }
    }
}