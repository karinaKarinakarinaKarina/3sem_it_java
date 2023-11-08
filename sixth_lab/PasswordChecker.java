package fifth_java_lab;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "89IN";
        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректен");
            } else {
                System.out.println("Пароль некорректен");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}