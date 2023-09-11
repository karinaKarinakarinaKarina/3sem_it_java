
class Main {
    // task1
    public static void convert(int gallon) {
        double litres = gallon * 3.785;
        System.out.println( gallon + " галлонов - это "+ litres + " литров.");
    }
    
    // task2
    public static void fitCalc(int minutes, int intense) {
        int calories = 0;
        if (intense ==1 || intense ==2 || intense ==3) {
            calories = intense*minutes;
            System.out.println("Вы сожгли " + calories + " калорий. Вы молодцы!");
        }
        else { 
            System.out.println("Кажется, вы ввели неправильное значение интенсивности тренировки. Проверьте данные.");
        }
    }
    
    // task3
    public static void containers(int boxes, int bags, int barrels) {
        int tovary = 20 * boxes + 50 * bags + 100 * barrels;
        System.out.println("На вашем складе " + tovary + " товаров :)");
    }
    
    // task4
    public static void triangletype(int x, int y, int z) {
        if ((x +y < z) || (x + z < y) || (y + z < x)) {
            System.out.println("Не является треугольником");
        }
        else {
            if ((x == y ) && ( y ==z)){
                System.out.println("Треугольник является равносторонним");
            }
            else if ( (x== y ) || (y ==z) ||  (x ==z)) {
                System.out.println("Треугольник является равнобедренным");
            }
            else {
                System.out.println("Треугольник является разносторонним");
            }
        }
    }
    
    // task5
    public static int ternaryEvaluation(int a, int b) {
        return (( a < b ) ? b : a);
    }
    
    // task6 
    public static int howManyItems(double fabricLength, double pieceWidth, double pieceHeight) {
    double totalFabricArea = fabricLength * 2;
    double pieceArea = pieceWidth * pieceHeight;
    int numOfPieces = (int) (totalFabricArea / pieceArea);
    return numOfPieces;
    }
    
    // task7
    public static void factorial(int digital) {
        int i = 1;
        int result =1;
        while (i <=digital) {
            result *= i;
            i++;
        }
        System.out.println("Факториал числа " + digital + " - " + result);
    }
    
    // task8 
    public static void gcd(int a, int b) {
        int gcdd = 0;
        for (int i = 1; ((i < a) && (i < b)); i ++) {
            if ((a % i == 0) && (b % i == 0)) {
                gcdd = i ;
                continue;
            }
        }
        System.out.println("Наибольший общий делитель чисел " + a + " и " + b + " - " + gcdd);
   }
   
    // task9
    public static void ticketSailer(int tickets, int price) {
        int commission = 100;
        int revenue = (price - commission) * tickets; // общая выручка
        System.out.println("Общая выручка: " + revenue);
    }

    // task10
    public static void tables(int students, int desks) {
        int tablesNeeded = (students + students % 2) /2 ; // количество нужных столов
        if (tablesNeeded < desks) {
            System.out.println("0");
        }
        else { 
            int tablesMissing = tablesNeeded - desks; 
            System.out.println(tablesMissing);
        } 
    }

    
    
    public static void main(String[] args) {
        // task1
        convert(5);
        convert(3);
        
        // task2 
        fitCalc(15,1);
        fitCalc(41,3);
        
        // task3
        containers(5,0,2);
        containers(4,1,4);
        
        // task4
        triangletype(5,5,5);
        triangletype(5,1,1);
        triangletype(3,4,5);
        
        // task5 
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));
        
        // task6 
        System.out.println(howManyItems(22,1.4, 2));
        System.out.println(howManyItems(100,2,2));
        
        // task7
        factorial(7);
        factorial(5);
        
        // task8
        gcd(48,18);
        gcd(52,8);
        gcd(259,28);
        
        // task9 
        ticketSailer(70,1500);
        ticketSailer(53,1250);

        // task 10
        tables(5,2);
        tables(31,20);
        tables(123,58);
    }
}