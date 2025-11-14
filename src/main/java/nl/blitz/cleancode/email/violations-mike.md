# violations found

## the password is just said in plain text here which is not safe
    public EmailService() {
        smtpHost = "smtp.example.com";
        smtpPort = 587;
        username = "admin@example.com";
        password = "password123";
    }

# this entire class needs to be in its own file
        class EmailServiceHelper {
        public void connect(String host, int port) {
            // connection logic
        }

        public void authenticate(String user, String pass) {
            // authentication logic
        }

        public void sendEmail(String to, String subject, String body) {
            // send email logic
        }

        public void disconnect() {
            // disconnect logic
        }
    }