/* 
 * recursion means a function that call itself.....
 * Questions Covered.....
 * -> Numbers arrangement in descending order aslike  5,4,3,2,1.
 * -> Numbers arrangement in Ascending order as like   1,2,3,4,5.
 * -> Factorial of any number n is the product of all positive integers less than or equal to n
 * -> sum of all natural numbers  from 1 to n (n inclusive)
 * -> Fibonaccci series till nth term...
 * -> Print x^n (Stack height = n)
 * -> Print x^n (Stack  height > logn)
 */

import java.util.Scanner;

public class recursion {
    
    public static int calcPower(int x, int n){
        if (n == 0) { // base case 1
            return 1;
        }

        if (x == 0 ) { //base case 2
            return 0;
        }
        //if n is even
        if (n % 2 == 0) {
            return calcPower(x, n/2) * calcPower(x, n/2);
        }
        else{ //n is odd
            return calcPower(x, n/2) * calcPower(x, n/2) * x;
        }
    }

    public static void main(String[] args) {
        int x = 2, n = 5;
        int ans = calcPower(x, n);
        System.out.println(ans);
    }
}
