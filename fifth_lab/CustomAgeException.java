package fifth_lab;

public class CustomAgeException extends Exception {
    public CustomAgeException(String message) {
        super(message);
    }
}

class AgeChecker {
    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст");
        }
    }

    public static void main(String[] args) {
        int age = 6;

        try {
            checkAge(age);
            System.out.println("Возраст допустим");
        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
