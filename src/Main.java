import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner((System.in));
        System.out.print("Type: ");
        String[] calc_str = input.nextLine().split(" ");

        if (calc_str.length != 3) {
            System.out.println("Incorrect type");
            return;
        }

        String x = calc_str[0], method = calc_str[1], y = calc_str[2];
        boolean roman_a = false, roman_b = false, default_a = false, default_b = false;
        String[] default_values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] roman_values = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        int a, b, k = 1, roman_a_value = 0, roman_b_value = 0;
        for (String s : roman_values) {
            if (x.equals(s)) {
                roman_a = true;
                roman_a_value = k;
            }
            if (y.equals(s)) {
                roman_b = true;
                roman_b_value = k;
            }
            k++;
        }
        for (String s : default_values) {
            if (x.equals(s)) {
                default_a = true;
            }
            if (y.equals(s)) {
                default_b = true;
            }
        }

        if ((default_a != default_b) || (roman_a != roman_b)) {
            System.out.println("Incorrect type");
            return;
        }

        int answer = 0, index = 0;
        if (default_a) {
            a = Integer.parseInt(x);
            b = Integer.parseInt(y);
            switch (method) {
                case "+" -> answer = a + b;
                case "-" -> answer = a - b;
                case "*" -> answer = a * b;
                case "/" -> answer = a / b;
            }
        }
        else {
            switch (method) {
                case "+" -> index = roman_a_value + roman_b_value;
                case "-" -> index = roman_a_value - roman_b_value;
                case "*" -> index = roman_a_value * roman_b_value;
                case "/" -> index = roman_a_value / roman_b_value;
            }
            int main_index;
            if (index > 10 && index < 40) {
                main_index = index / 10;
                System.out.print("Answer = ");
                for (int i = 0; i < main_index; i++) {
                    System.out.print("X");
                }
                if (index % 10 != 0) {
                    System.out.println(roman_values[index % 10 - 1]);
                }
            } else if (index >= 40 && index < 50) {
                if (index == 40) {
                    System.out.println("Answer = XL");
                } else {
                    System.out.println("Answer = XL" + roman_values[index % 10 - 1]);
                }
            } else if (index >= 50 && index < 90) {
                System.out.print("Answer = L");
                main_index = index / 10;
                for (int i = 0; i < main_index - 5; i++) {
                    System.out.print("X");
                }
                if (index % 10 != 0) {
                    System.out.println(roman_values[index % 10 - 1]);
                }
            } else if (index == 90) {
                System.out.println("Answer = XC");
            } else if (index > 90 && index < 100) {
                System.out.print("Answer = XC" + roman_values[index % 10 - 1]);
            } else if (index == 100) {
                System.out.println("C");
            } else {
                System.out.println("Answer = "+ roman_values[index % 10 - 1]);
            }
            return;
        }
        System.out.println("Answer = " + answer);
    }
}