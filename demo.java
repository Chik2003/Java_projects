import java.util.*;

public class demo{
    public static void main(String Args[]){
        for (int i = 0; i < 100; i++) {
            System.out.println("welcome to code");
            System.out.println("Enter Your Name :");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            System.out.println("Welcome Mr."+ name);
            System.out.println("Enter your Age sir :"+" ");
            Scanner nm = new Scanner(System.in);
            int age = nm.nextInt();
            Scanner Gen = new Scanner(System.in);
            System.out.print("Are you a male or female?\nPlease enter M/F:");
            char Gender=Gen.next().charAt(0);
            if ((Gender == 'M') || (Gender=='m')){
                System.out.println("\nHello Mr." +name+",Your are "+ age + " years old and You are Male.");
            }
            else if((Gender == 'F')||(Gender=='f')){
                System.out.println("\nHello Mrs."+name+",You are " +
                        age+"years old and You are Female.");
            }else{
                System.out.println("Invalid Input! Please Enter M/F only!");
            }
            System.out.println("\nDo you want to continue?(Y/N):");
            char c=sc.next().charAt(0);
            if ((c == 'Y') || (c=='y'))
                continue;
            else
            break;
        }

        Scanner nm = new Scanner(System.in);
int age = nm.nextInt();
System.out.println("Sir your age is"+ age);
if(age <= 5){
            System.out.println("You are too small to use this software");
        } else{
            System.out.print("Please select the type of user you want to create: \n1.Teacher\n2.Student\n3.Administrator:\t");
            Scanner num = new Scanner(System.in);
            int Value = num.nextInt();
            switch
            (Value) 
            {
                case 1 :
                    System.out.println("you Are an teacher. that's Great!!");
                    break;
                case 2 :
                    System.out.println("Wow Champ! That well to know you are a student");
                    break;
                default:
                    System.out.println("might be there is an mistake....");
            }
            System.out.print("Please enter the number of days you will be using this software:");
            Scanner days = new Scanner(System.in);
            int dys = nm.nextInt();
            float cost = (float)(dys * .02);
            System.out.printf("The total amount to pay is $%.2f",cost);
            System.out.printf("The total cost of using this software for %d days is $ %.2f", dys, cost);
                }
            }
        }     