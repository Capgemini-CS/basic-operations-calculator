package calculator.operations;

public class TwoNumbersOperations {

    public static void main(String[] args) {
        if (args.length == 3) {
            if (checkIfAllArgumentsAreValid(args[0], args[1], args[2])) {
                int firstNumber = Integer.parseInt(args[0]);
                int secondNumber = Integer.parseInt(args[1]);
                String operation = args[2];

                calculate(firstNumber, secondNumber, operation);

            }
        }
    }

    public static void calculate(int firstNumber, int secondNumber, String operation) {
        float result = 0;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumberIsNotZero(secondNumber)) {
                    result = firstNumber / secondNumber;
                } else
                    System.out.println("The division is not possible because second number is equals to zero.");
                    System.exit(0);
                break;
        }
        System.out.println("Result of operation is: " + result);
    }

    public static boolean checkIfAllArgumentsAreValid(String firstNumber, String secondNumber, String operation) {
        if (isValueNumeric(firstNumber) && isValueNumeric(secondNumber) && valueIsOneOfTheOperators(operation)) {
            return true;
        }
        return false;
    }

    public static boolean isValueNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("The argument is not numeric.");
            return false;
        }
        return true;
    }

    public static boolean valueIsOneOfTheOperators(String value) {
        String allowedOperators = "+-*/";
        if(allowedOperators.contains(value)){
            return true;
        }else{
            System.out.println("The argument is not one of the operators (+, -, *, /).");
           return false;
        }
    }

    public static boolean secondNumberIsNotZero(int value) {
        if (value != 0) {
            return true;
        }
        return false;
    }

}
