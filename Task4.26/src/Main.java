import java.util.Scanner;

//Посчитать количество чисел от A до B (целые) таких, что цифры числа, рассмотренные по
//порядку слева направо, образуют арифметическую или геометрическую прогрессию. Будем
//считать, что все однозначные и двухзначные числа образуют арифметическую прогрессию. Для
//определения, подходит ли число под требования задачи, реализовать функцию. Также
//реализовать функцию для подсчета кол-ва таких чисел от 1 до n. Запрещено использовать строки
//и массивы.
public class Main {
    // функция для подсчета количества чисел от a до b таких, что они образуют арифметическую прогрессию
    public static int countArithmeticGeometricProgression(int a, int b) {
        if (a > b) return 0;
        int count = 0; // счетчик чисел
        for (int i = a; i <= b; i++) {
            if ((isArithmeticProgression(i) || isGeometricProgression(i))) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    // функция для определения, подходит ли число под арифметическую прогрессию
    public static boolean isArithmeticProgression(int number) {
        if (number < 100) {
            return true;
        }
        int lastDigit = number % 10;
        int secondLastDigit = (number / 10) % 10;
        return lastDigit - secondLastDigit == secondLastDigit - (number / 100) % 10;
    }

    // функция для определения, подходит ли число под геометрическую прогрессию
    public static boolean isGeometricProgression(int number) { //например 931
        if (number < 100)
            return false;
        int lastdegit = number % 10;//1
        number = number/10;//93
        int secondlastdegit = number % 10;// 3
        int firstdegit = number/10;//9
        if (secondlastdegit != 0 && lastdegit != 0) {
            return (((double) secondlastdegit / firstdegit) == ((double) lastdegit / secondlastdegit));
        }
        if (secondlastdegit == 0 && lastdegit == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите A: ");
        int a = scanner.nextInt();
        System.out.print("Введите B: ");
        int b = scanner.nextInt();
        int n = countArithmeticGeometricProgression(a, b);
        System.out.println("Количество чисел от " + a + " до " + b + " таких, что они образуют арифметическую или геометрическую прогрессию: " + n);
        scanner.close();
    }
}


