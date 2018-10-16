import java.util.Scanner;

public class SciCalculator
{
    public static void main(String[] args)
    {
        //variable declarations
        double currentResult = 0.0; //current result
        double firstOperand = 0.0; //first operand
        double secondOperand = 0.0; //second operand

        String firstInput = ""; //user inputs, converted into operands
        String secondInput = "";

        int calcNumber = 0; //number of calculations
        double totalCalc = 0.0; //sum of calculations

        String lineBreak = "";

        boolean running = true; //run while true

        int selection = 0;
        Scanner scanner = new Scanner(System.in);


        while (running) //run while true
        {

            if (calcNumber > 0) //set line break after first loop
            {
                lineBreak = "\n";
            }

            if (selection >= 0 && selection < 7)
            {
                System.out.println(lineBreak + "Current Result: " + currentResult); //menu and user choices

                System.out.println("\nCalculator Menu");
                System.out.println("---------------");
                System.out.println("0. Exit Program");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exponentiation");
                System.out.println("6. Logarithm");
                System.out.println("7. Display Average");
            }

            System.out.print("\nEnter Menu Selection: "); //user input selection

            selection = scanner.nextInt();

            //set user input equal to operands; define input of "RESULT"
            if (1 <= selection && 6 >= selection)
            {
                System.out.print("\nEnter first operand: ");
                firstInput = scanner.next();

                System.out.print("Enter second operand: ");
                secondInput = scanner.next();

                if (firstInput.equals("RESULT"))
                {
                    firstOperand = currentResult;
                }
                else
                {
                    firstOperand = Double.parseDouble(firstInput);
                }

                if (secondInput.equals("RESULT"))
                {
                    secondOperand = currentResult;
                }
                else
                {
                    secondOperand = Double.parseDouble(secondInput);
                }
            }

            switch (selection)
            {
                case 0: //exit
                    running = false;
                    break;
                case 1: //addition
                    currentResult = firstOperand + secondOperand;
                    calcNumber += 1;
                    totalCalc += currentResult;
                    break;
                case 2: //subtraction
                    currentResult = firstOperand - secondOperand;
                    calcNumber += 1;
                    totalCalc += currentResult;
                    break;
                case 3: //multiplication
                    currentResult = firstOperand * secondOperand;
                    calcNumber += 1;
                    totalCalc += currentResult;
                    break;
                case 4: //division
                    currentResult = firstOperand / secondOperand;
                    calcNumber += 1;
                    totalCalc += currentResult;
                    break;
                case 5: //exponentiation
                    currentResult = Math.pow(firstOperand, secondOperand);
                    calcNumber += 1;
                    totalCalc += currentResult;
                    break;
                case 6: //logarithm
                    firstOperand = Math.log(firstOperand);
                    secondOperand = Math.log(secondOperand);
                    currentResult = secondOperand / firstOperand;
                    calcNumber += 1;
                    totalCalc += currentResult;
                    break;
                case 7: //statistics
                    if (calcNumber > 0)
                    {
                        double calcAverage = totalCalc / calcNumber;
                        calcAverage = Math.round(calcAverage * 100) / 100.00;
                        System.out.println("\nSum of calculations: " + totalCalc);
                        System.out.println("Number of calculations: " + calcNumber);
                        System.out.println("Average of calculations: " + calcAverage);
                    }
                    else
                    {
                        System.out.println("\nError: No calculations yet to average!");
                    }
                    break;
                default: //catch statement for invalid input
                    System.out.println("\nError: Invalid selection!");
                    break;
            }


        }
        System.out.print("\nThanks for using this calculator. Goodbye!");
    }
}
