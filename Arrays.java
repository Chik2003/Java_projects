/**
 * defining an Arrays
 * type[] arrayName = newtype[size]
 * type = int, char, string
 * arrayName= what you have to put the name of array
 * new= it is a keyword
 * size = what is the size of an array you want.
*/
import java.util.*;
public class Arrays {

    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int numbers[] = new int[size];
  
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();

        }

        boolean isAscending = true;

        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i+1]) {
                isAscending = false;

            }

        }

        if (isAscending) {
            System.out.println("This Is sorted in  ascending order");
        } else {
            System.out.println("This Is not sorted in ascending order");
        }
      }
    }
