// Абстрактный класс Человек
abstract class Person {
    private String name;
    private int age;
    private String gender;

    // Конструктор по умолчанию
    public Person() {
        this.name = "";
        this.age = 0;
        this.gender = "";
    }

    // Конструктор с параметрами
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры и сеттеры для полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Абстрактные методы, описывающие поведение объекта
    public abstract void introduce();

    public abstract void work();
}

// Дочерний класс Студент
class Student extends Person {
    private String university;
    private int year;

    // Конструктор по умолчанию
    public Student() {
        super();
        this.university = "";
        this.year = 0;
    }

    // Конструктор с параметрами
    public Student(String name, int age, String gender, String university, int year) {
        super(name, age, gender);
        this.university = university;
        this.year = year;
    }

    // Геттеры и сеттеры для полей
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Переопределение методов родительского класса
    @Override
    public void introduce() {
        System.out.println("Меня зовут " + getName() + ", я студент " + getUniversity() + " " + getYear() + " курса.");
    }

    @Override
    public void work() {
        System.out.println("Я учусь и занимаюсь на кафедре.");
    }
}

// Дочерний класс Преподаватель
class Teacher extends Person {
    private String department;
    private String subject;

    // Конструктор по умолчанию
    public Teacher() {
        super();
        this.department = "";
        this.subject = "";
    }

    // Конструктор с параметрами
    public Teacher(String name, int age, String gender, String department, String subject) {
        super(name, age, gender);
        this.department = department;
        this.subject = subject;
    }

    // Геттеры и сеттеры для полей
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Перегрузка метода work
    public void work(int hours) {
        System.out.println("Я преподаю предмет " + getSubject() + " на кафедре " + getDepartment() + " " + hours + " часов в неделю.");
    }

    // Переопределение методов родительского класса
    @Override
    public void introduce() {
        System.out.println("Меня зовут " + getName() + ", я преподаватель на кафедре " + getDepartment() + ".");
    }

    @Override
    public void work() {
        System.out.println("Я преподаю на кафедре.");
    }
}

// Дочерний класс Ассистент преподавателя
class TeachingAssistant extends Person {
    private String department;
    private int hours;

    // Статическая переменная для подсчета созданных объектов
    private static int count = 0;

    // Конструктор по умолчанию
    public TeachingAssistant() {
        super();
        this.department = "";
        this.hours = 0;
        count++;
    }

    // Конструктор с параметрами
    public TeachingAssistant(String name, int age, String gender, String department, int hours) {
        super(name, age, gender);
        this.department = department;
        this.hours = hours;
        count++;
    }

    // Геттеры и сеттеры для полей
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    // Геттер для статической переменной count
    public static int getCount() {
        return count;
    }

    // Перегрузка метода work
    public void work(String task) {
        System.out.println("Я помогаю преподавателю на кафедре " + getDepartment() + " выполнить задание: " + task);
    }

    // Переопределение методов родительского класса
    @Override
    public void introduce() {
        System.out.println("Меня зовут " + getName() + ", я ассистент преподавателя на кафедре " + getDepartment() + ".");
    }

    @Override
    public void work() {
        System.out.println("Я помогаю преподавателю на кафедре.");
    }
}

public class classe {
    public static void main(String[] args) {
        // Создание объектов и вызов методов
        Student student = new Student("Иван", 20, "мужской", "МГУ", 2);
        student.introduce();
        student.work();

        Teacher teacher = new Teacher("Анна", 35, "женский", "МФТИ", "Математика");
        teacher.introduce();
        teacher.work();
        teacher.work(10);

        TeachingAssistant ta1 = new TeachingAssistant("Петр", 25, "мужской", "МГТУ", 15);
        ta1.introduce();
        ta1.work();
        ta1.work("Подготовить презентацию");

        TeachingAssistant ta2 = new TeachingAssistant("Мария", 23, "женский", "МГТУ", 20);
        ta2.introduce();
        ta2.work();
        ta2.work("Проверить домашние задания");

        // Вывод количества созданных объектов
        System.out.println("Количество созданных ассистентов: " + TeachingAssistant.getCount());
    }
}
