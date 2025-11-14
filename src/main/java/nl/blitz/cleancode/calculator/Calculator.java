package nl.blitz.cleancode.calculator;

class Calculator {
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

    public boolean check(double x) {
        return x > 0 && x < 100;
    }

    public boolean isThisFalse(double val) {
        if (val < 0) {
            return true;
        }
        return false;
    }

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

    public void doStuff(double d) {
        // increment d by 1
        d = d + 1;
        // check if d is greater than 10
        if (d > 10) {
            // print message
            System.out.println("Value is greater than 10");
        }
    }
}

