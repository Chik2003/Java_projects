import java.util.*;

public class first {
    public static void main(String Args[]) {
        for (int i = 0; i < 100; i++) {
            System.out.println("welcome to code");
            System.out.println("Enter Your Name :");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            System.out.println("Welcome Mr." + name);
            Scanner Gen = new Scanner(System.in);
            System.out.print("Are you a male or female?\nPlease enter M/F:");
            char Gender=Gen.next().charAt(0);
            if ((Gender == 'M') || (Gender=='m')){
                System.out.println("\nHello Mr." +name+",Your are Male.");
            }
            else if((Gender == 'F')||(Gender=='f')){
                System.out.println("\nHello Mrs."+name+",You are Female.");
            }else{
                System.out.println("Invalid Input! Please Enter M/F only!");
            }

            System.out.println("enter Your age " + name + " sir-->");
            Scanner nm = new Scanner(System.in);
            int age = nm.nextInt();
            System.out.println("Sir your age is " + age);
            if (age <= 5) {
                System.out.println("You are too small to use this software");
            } else {
                System.out.print("Please select the type of user you want to create: \n1.Teacher\n2.Student\n3.Administrator:\t");
                Scanner num = new Scanner(System.in);
                int Value = num.nextInt();
                switch (Value) {
                    case 1:
                        System.out.println("you Are an teacher. that's Great!!");
                        System.out.println("as a Teacher which subject you teach in school: \n1. Java \n2. Python \n3. Web Dev");
                        Scanner sub = new Scanner (System.in);
                        int NUM = sub.nextInt();
                        switch(NUM){
                            case 1 :
                                System.out.println("You are a Java Teacher");
                                break;
                            case 2:
                                System.out.println("You are a Python Teacher");
                                break;
                            case 3:
                                System.out.println("you are a Web Developer Teacher");
                        }
                        break;
                    case 2:
                        System.out.println("Wow Champ! That well to know you are a student");
                        System.out.println("So" + name + "which Subject you love to do? \n1. Java \n2. Python \n3. Web Dev");
                        Scanner SUB = new Scanner (System.in);
                        int Coun = SUB.nextInt();
                        switch(Coun){
                            case 1 :
                                System.out.println("Ohh You want to be a software or mobile developer!\n want to start learning");
                                Scanner ans = new Scanner(System.in);
                                char Ans=ans.next().charAt(0);
                                if ((Ans == 'Y') || (Ans == 'y')){
                                System.out.println("Start Learning about Java");
                            }else {
                                   continue;
                                }
                                break;
                            case 2:
                                System.out.println("You want to be a \n1. Python developer or \n2. Data Scientist");
                                Scanner Choice = new Scanner(System.in);
                                int choice = Choice.nextInt();
                                switch (choice){
                                    case 1:
                                        System.out.println("Lets learn about new about python developer");
                                    break;
                                    case 2:
                                        System.out.println("lets take look on Data scientist Course");
                                        break;
                                    default:
                                        System.out.println("Don't worry try Again!");
                                }
                                break;
                            case 3:
                                System.out.println("So "+ name +"you want to be a website maker!!! cool");
                                Scanner Wb = new Scanner(System.in);
                                char Web=Gen.next().charAt(0);
                                if ((Web == 'Y') || (Web == 'y')){
                                    System.out.println("Let's Learn Champ");
                                } else {
                                    continue;
                                }
                        }
                        break;
                    default:
                        System.out.println("might be there is an mistake....");
                }
                System.out.print("Please enter the number of days you will be using this software:");
                Scanner days = new Scanner(System.in);
                int dys = nm.nextInt();
                float cost = (float) (dys * .02);
                System.out.printf("The total amount to pay is $%.2f ", cost);
                System.out.printf("The total cost of using this software for %d days is $ %.2f ", dys, cost);
            }
        }
    }
}

