import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] box = str.split(" ");

        check_lenght(box);


        try {
            System.out.println(sum(Integer.parseInt(box[0]), Integer.parseInt(box[2]), box[1]));
        } catch (NumberFormatException e) {

            try {
                int ra_result = rim_number_val(box);
                arab_to_rim(ra_result);


            } catch (IllegalArgumentException ex) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления или вы задали числа вне диапазона от 1 до 10 и от I до X");
                System.exit(0);
            }

        }
    }


    public static void check_lenght(String[] box) {
        if (3 != box.length) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
    }

    public static int sum(int a, int b, String c) {
        if ((a<0||a>10)||(b<0||b>10)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
                System.exit(0);
            }
        }

            int sumsum = 0;
            switch (c) {
                case "/" -> {
                    sumsum = a / b;
                }
                case "*" -> {
                    sumsum = a * b;
                }
                case "+" -> {
                    sumsum = a + b;
                }
                case "-" -> {
                    sumsum = a - b;
                }

            }
            return sumsum;

    }



    public static int rim_number_val(String[] box) {
        Rim[] rimBase = Rim.values();
        Rim digits = Rim.valueOf(box[0]);
        int val1 = digits.getArab();
        Rim digits2 = Rim.valueOf(box[2]);
        int val2 = digits.getArab();

        if (sum(val1, val2, box[1]) < 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел и нулей");
                System.exit(0);
            }

        }
        return sum(val1, val2, box[1]);
    }
    public static void arab_to_rim(int ra_result){
        int units = ra_result % 10;
        int tens = (ra_result % 100) / 10;
        int hundreds = (ra_result % 1000) / 100;

        if (hundreds != 0) {
        RimHundreds[] rimHundredsBase = RimHundreds.values();
        RimHundreds rim_hundreds = rimHundredsBase[hundreds];
        System.out.print(rim_hundreds.toString());}
        if (tens != 0){
        RimTens[] rimTensBase = RimTens.values();
        RimTens rim_tens = rimTensBase[tens];
        System.out.print(rim_tens.toString());}
        if (units != 0){
        RimUnits[] rimUnitsBase = RimUnits.values();
        RimUnits rim_units = rimUnitsBase[units];
        System.out.print(rim_units.toString());}

    }

}