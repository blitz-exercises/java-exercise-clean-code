package nl.blitz.cleancode.calculator;

class Calculator {
    // wist niet hoe ik deze methode verder binnen java kan opschonen er is vast wel
    // een manier om gebaseerd op de imput van String te kunnen detecteren welke operator
    // het is om niet dat lelijke nested if statements te hebben
    // heb voor nu om het iets duidelijk te maken gekozen om de operator als string mee te laten
    // geven
    public double executeCalculation(double a, double b, String operator) {
        if (operator == "+") {
            return a + b;
        } else if (operator == "-") {
            return a - b;
        } else if (operator == "*") {
            return a * b;
        } else if (operator == "/") {
            if (b == 0) {
                return -1;
            }
            return a / b;
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }
    }

    public boolean isBetweenZeroAndOneHundred(double x) {
        return x > 0 && x < 100;
    }

    public boolean isGreaterThanZero(double val) {
        if (val < 0) {
            return true;
        }
        return false;
    }

    public double sumAll(double[] arrgs) {
        double temporary = 0;
        for (int i = 0; i < arrgs.length; i++) {
            temporary = temporary + arrgs[i];
        }
        return temporary;
    }

    public double subtractAll(double[] arrgs) {
        double temporary = 0;
        for (int i = 0; i < arrgs.length; i++) {
            temporary = temporary - arrgs[i];
        }
        return temporary;
    }

    public void addUntilTen(double d) {
        d = d + 1;
        if (d > 10) {
            System.out.println("Value is greater than 10");
        }
    }
}

