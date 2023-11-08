package fifth_java_lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPadress {


    public static void main(String[] args) {
        String ipAddress = "192.290.1.1";
        String regex = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ipAddress);

            if (matcher.matches()) {
                String[] numbers = ipAddress.split("\\.");

                for (String num : numbers) {
                    int number = Integer.parseInt(num);

                    if (number < 0 || number > 255) {
                        System.out.println("IP адрес некорректен.");
                        return;
                    }
                }

                System.out.println("IP адрес корректен.");
            } else {
                System.out.println("IP адрес некорректен.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Некорректное регулярное выражение.");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный IP адрес.");
        }
    }
}
