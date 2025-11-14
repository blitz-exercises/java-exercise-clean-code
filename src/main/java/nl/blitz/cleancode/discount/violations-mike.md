# useless comments

# everything is in 1 class and alot of things are better off being split of into subclasses

#  maybe you want to move these to a seperate class but i also believe they could exist where they are now

    public boolean isValidDiscountCode(String code) {
        try {
            java.net.URL url =
                    new java.net.URL("http://api.discountservice.com/validate?code=" + code);
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