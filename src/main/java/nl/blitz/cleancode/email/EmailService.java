package nl.blitz.cleancode.email;

public class EmailService {
    private String smtpHost;
    private int smtpPort;
    private String username;
    private String password;

    public EmailService() {
        smtpHost = "smtp.example.com";
        smtpPort = 587;
        username = "admin@example.com";
        password = "password123";
    }

    public void send(String to, String subject, String body) {
        EmailServiceHelper helper = new EmailServiceHelper();
        helper.connect(smtpHost, smtpPort);
        helper.authenticate(username, password);
        helper.sendEmail(to, subject, body);
        helper.disconnect();
    }

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
}

