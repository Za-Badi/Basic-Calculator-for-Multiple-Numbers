// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner ;
import java.util.ArrayList;
import java.util.List;
public class main {

    public static void main(String[] args) {
        System.out.print("Enter two or three numbers from 1 to 10 seperated by arithmetic operators (+,-,*,/): ");

        Scanner scanner = new Scanner(System.in);
        String enteredValue = scanner.nextLine().trim();
        calculator(enteredValue);
        scanner.close();
    }

    public static void calculator(String enteredOperation) {
        String newLine = System.getProperty("line.separator");

        char[] validOperators= {'+','-','*','/'};
        List<Integer> operater_index=new ArrayList<>();
        List<Character> operatorEnteredValue=new ArrayList<>();
        int operatorsCounter = 0;
        int num1 =0;
        int num2 =0;
        int num3=0;

        for (int j=1; j < enteredOperation.length(); j++) {
            for(int i = 0; i < validOperators.length; i++) {
                if(validOperators[i] == enteredOperation.charAt(j)) {
                    operater_index.add(j) ;
                    operatorEnteredValue.add(enteredOperation.charAt(j));
                    operatorsCounter++;
                }
            }
        }

        if (operatorsCounter>2) {
            System.out.print("Please enter two or three numbers only seprated by arithmetic operators " );
            return;
        }

        for(int i =1; i<operater_index.size(); i++) {
            if( operater_index.get(i)==operater_index.get(i-1)+1) {
                System.out.print ( "Please enter one operator between numbers");
                return;
            }
        }

        if (operater_index.size()==1) {
            try {

                if(enteredOperation.charAt(0)=='-') {
                    System.out.print ( "Please enter positive numbers from 0 to 10  only");
                    return;
                } else if(enteredOperation.charAt(0)=='+') {
                    num1 =Integer.parseInt(enteredOperation.substring(operater_index.get(0)-1,operater_index.get(0)).trim());

                } else {
                    num1 =Integer.parseInt(enteredOperation.substring(operater_index.get(0)-1,operater_index.get(0)).trim());

                }


                num2 =Integer.parseInt((enteredOperation.substring(operater_index.get(0)+1)).trim());

            } catch (final NumberFormatException e) {
                System.out.print ( "Please enter numbers only.");
                return;
            }
        }
        if (operater_index.size()==2) {
            try {

                if(enteredOperation.charAt(0)=='-') {

                    System.out.print ( "Please enter positive numbers from 0 to 10  only");
                    return;
                } else if(enteredOperation.charAt(0)=='+') {

                    num1 =Integer.parseInt(enteredOperation.substring(operater_index.get(0)-1,operater_index.get(0)).trim());

                } else {


                    num1 =Integer.parseInt(enteredOperation.substring(operater_index.get(0)-1,operater_index.get(0)).trim());

                }
                //   num1 =Integer.parseInt((enteredOperation.substring(0,operater_index.get(0))).trim());
                num2 =Integer.parseInt((enteredOperation.substring(operater_index.get(0)+1,operater_index.get(1))).trim());
                num3 =   Integer.parseInt((enteredOperation.substring(
                                               (operater_index.get(1)+1))
                                          ).trim());
            } catch (final NumberFormatException e) {
                System.out.print ( "Please enter numbers only. ");
                return;
            }

        }


        if(numberValueBetween1And10(num1)&& numberValueBetween1And10(num2)) {
            if(operatorEnteredValue.size()==1) {
                double total= simpleCal(num1, num2, operatorEnteredValue.get(0));

                System.out.print( "The result of "+enteredOperation+"= "+total+newLine);
                
            }

            else if (operatorEnteredValue.size()==2&&numberValueBetween1And10(num3)) {
                {

                    if (operatorEnteredValue.get(1)=='*' || operatorEnteredValue.get(1)=='/') {

                        double result = simpleCal(num2, num3, operatorEnteredValue.get(1));
                        double total = simpleCal(result, num1,operatorEnteredValue.get(0));
                        System.out.print( "The result of "+enteredOperation+"= "+total+newLine);
                    } else {

                        double result = simpleCal(num1, num2, operatorEnteredValue.get(0));
                        double total = simpleCal(result, num3,operatorEnteredValue.get(1));
                        System.out.print( "The result of "+enteredOperation+"= "+total+newLine);

                    }


                }

            }


        } else {
            System.out.print ("Please enter Numbers between numbers 1 and 10 only");
            return;
        }
    }

    public static boolean  numberValueBetween1And10(int num) {
        if(num>0&&num<=10) {
            return true;
        } else return false;
    }

    public static double simpleCal(  double number1, double  number2,  char operator) {
        double result=0;
        switch (operator) {
        // performs addition between numbers
        case '+':
            result = number1 + number2;
            break;
        // performs subtraction between numbers
        case '-':
            result = number1 - number2;
            break;
        // performs multiplication between numbers
        case '*':
            result = number1 * number2;
            break;
        // performs division between numbers
        case '/':
            result = number1 / number2;
            break;
        default:
            System.out.println("Invalid operator!");
            break;
        }
        return result;
    }




}