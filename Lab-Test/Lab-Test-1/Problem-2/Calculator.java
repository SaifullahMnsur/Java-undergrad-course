import java.util.Scanner;

class Calculator {
    public Calculator(){

    }

    public int calculate(int a, String operator, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                // check if the divisor is 0 or not
                if(b != 0)
                    return a / b;
                else
                    return 0;
            default:
                System.out.println("Invalid operator entered!");
                return -1;
        }
    }

    public double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                // check if the divisor is 0 or not
                if( b != 0)
                    return a / b;
                else
                    return 0;
            default:
                System.out.println("Invalid operator entered!");
                return -1;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        int condition = 1;
        do {
            System.out.println("Enter your expression with spaces (e.g. 2 + 4, 3.5 * 2.1): ");
            String input = sc.nextLine();
            input = input.trim(); // removes leading and trailing whitespaces
            String[] parts = input.split(" "); // split the input based on spaces

            // if we dont find 3 part( a , operator, b) then
            if (parts.length != 3) {
                System.out.println("Invalid input format! Please enter in the format: number operator number.");
                continue;
            }
            
            // if there are any decimal points in the input line
            if(input.contains(".")) {
                double a = Double.parseDouble(parts[0]); // convert string to double
                String operator = parts[1];
                double b = Double.parseDouble(parts[2]); // convert string to double

                double result = calculator.calculate(a, operator, b);
                System.out.println(a + " " + operator + " " + b + " = " + result);
            } else {
                int a = Integer.parseInt(parts[0]); // convert string to int
                String operator = parts[1];
                int b = Integer.parseInt(parts[2]); // convert string to int

                int result = calculator.calculate(a, operator, b);
                System.out.println(a + " " + operator + " " + b + " = " + result);
            }
            
            System.out.println("\nEnter 1 to continue!");
            condition = sc.nextInt();
            sc.nextLine();
        } while (condition == 1);
        System.out.println("\nProgramm finished!");
        sc.close();
    }
}
