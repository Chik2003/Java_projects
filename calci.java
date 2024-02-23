import java.util.Scanner;

/**
 * it contains all over 4 major operators and successfully working within a for loop 
 * the Major operators are +, - , *, /
 * 1. Addition, 2. Subtract, 3. Multiplication, 4. Divide
 * the For loop is starting with zero and ends up at 100 number of tasks.
 * that means it only perform 100 task at single runs.
 * calculator
 */
public class calci {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
    System.out.print("Enter The first value: ");
    Scanner sc = new Scanner(System.in);
    double num1 = sc.nextDouble();
    System.out.print("Enter the Second Number: ");
    double num2 = sc.nextDouble();
    System.out.println("Now! Choose the Operator  you want to use \n1. + (Addition) \n2. - (Subtraction) \n3. * (Multiplication) \n4. / (Divide)");
    System.out.print("Enter the operator Here: ");
            char  op=sc.next().charAt(0);
    switch (op) {
        case '+':
        System.out.println(num1 + " + "+ num2 +" = "+ (num1+num2));
            break;

            case '-':
            System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
            break;

            case '*':
            System.out.println(num1 + " * " + num2 + " = " +(num1*num2));
            break;
            case '/':
            System.out.println(num1 +  " / " + num2 + " =" + (num1/num2));
            break;

        default:
        System.out.println("Wrong Input You Entered!");
            break;
    }

System.out.println();
    }
}
}