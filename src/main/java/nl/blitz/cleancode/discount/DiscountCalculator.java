package nl.blitz.cleancode.discount;

import java.util.Calendar;
import java.util.Date;

class DiscountCalculator {
    public double calculateDiscount(double price, String customerType, Date purchaseDate) {
        double discount = 0;
        
        // check if it's black friday
        Calendar cal = Calendar.getInstance();
        cal.setTime(purchaseDate);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (month == 10 && day == 25) {
            discount = price * 0.3;
        }
        
        // apply customer type discount
        if (customerType.equals("PREMIUM")) {
            discount += price * 0.1;
        } else if (customerType.equals("GOLD")) {
            discount += price * 0.15;
        } else if (customerType.equals("VIP")) {
            discount += price * 0.2;
        }
        
        // check bulk discount
        if (price > 1000) {
            discount += price * 0.05;
        }
        
        return discount;
    }

    public boolean isValidDiscountCode(String code) {
        // call external API directly
        try {
            java.net.URL url = new java.net.URL("http://api.discountservice.com/validate?code=" + code);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            return responseCode == 200;
        } catch (Exception e) {
            return false;
        }
    }

    public double applyDiscountCode(double price, String code) {
        if (isValidDiscountCode(code)) {
            return price * 0.9;
        }
        return price;
    }
}

