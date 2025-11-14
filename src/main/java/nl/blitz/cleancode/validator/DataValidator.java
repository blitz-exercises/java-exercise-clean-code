package nl.blitz.cleancode.validator;

class DataValidator {
    public boolean validate(String input) {
        if (input == null) {
            return false;
        }
        if (input.length() < 3) {
            return false;
        }
        if (input.length() > 50) {
            return false;
        }
        if (!input.matches("[a-zA-Z0-9]+")) {
            return false;
        }
        return true;
    }

    public boolean checkEmail(String email) {
        if (email == null) {
            return false;
        }
        if (!email.contains("@")) {
            return false;
        }
        if (!email.contains(".")) {
            return false;
        }
        return true;
    }

    public boolean validateAge(int age) {
        if (age < 0) {
            return false;
        }
        if (age > 150) {
            return false;
        }
        return true;
    }

    public boolean isNotInvalid(String str) {
        if (str == null) {
            return true;
        }
        if (str.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean flag(String data, int type) {
        if (type == 1) {
            return validate(data);
        } else if (type == 2) {
            return checkEmail(data);
        } else {
            return false;
        }
    }
}

