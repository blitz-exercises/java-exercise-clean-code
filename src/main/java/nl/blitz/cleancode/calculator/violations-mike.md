# Violation I found in this project

## Vague method name with useless comments within the method
## changed to addUntilTen
public void doStuff(double d) {
        // increment d by 1
        d = d + 1;
        // check if d is greater than 10
        if (d > 10) {
            // print message
            System.out.println("Value is greater than 10");
        }
    }

## vague method name changed to isGreaterThanZero
public boolean isThisFalse(double val) {
        if (val < 0) {
            return true;
        }
        return false;
    }

## hard to read code
## calc is a abbreviation and vague
## contains int op which make the numbers do things differently than being a number (they subsitude for selecting operator)
## Nesting isn't looking great either also removed the final return -1 statement, becuase I could not figure out why you would default return a -1? replaced it with a exception if the operator provided isn't recognised
public double calc(double a, double b, int op) {
        if (op == 1) {
            return a + b;
        } else if (op == 2) {
            return a - b;
        } else if (op == 3) {
            return a * b;
        } else if (op == 4) {
            if (b == 0) {
                return -1;
            }
            return a / b;
        } else {
            return -1;
        }
    }

## very fague method, name does not tell me anything and within the code all the variables have abbreviations making it hard to understand whats going on, going to try to fix this to the best i can with what i can understand from reading the code.
## ended up splitting the method into 2 one that summs everything up and one thats substracts
public double process(double[] arr, boolean flag) {
        double tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                tmp = tmp + arr[i];
            } else {
                tmp = tmp - arr[i];
            }
        }
        return tmp;
    }