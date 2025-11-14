package nl.blitz.cleancode.notification;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class NotificationSender {
    public void send(String recipient, String message, String type) {
        if (recipient == null) {
            return;
        }
        if (message == null) {
            return;
        }

        try {
            if (type.equals("EMAIL")) {
                sendEmail(recipient, message);
            } else if (type.equals("SMS")) {
                sendSMS(recipient, message);
            } else if (type.equals("PUSH")) {
                sendPush(recipient, message);
            }
        } catch (Exception e) {
            // ignore errors
        }
    }

    private void sendEmail(String email, String message) throws IOException {
        URL url = new URL("http://api.emailservice.com/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.getOutputStream().write(("email=" + email + "&message=" + message).getBytes());
        conn.getResponseCode();
    }

    private void sendSMS(String phone, String message) throws IOException {
        URL url = new URL("http://api.smsservice.com/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.getOutputStream().write(("phone=" + phone + "&message=" + message).getBytes());
        conn.getResponseCode();
    }

    private void sendPush(String deviceId, String message) throws IOException {
        URL url = new URL("http://api.pushservice.com/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.getOutputStream().write(("device=" + deviceId + "&message=" + message).getBytes());
        conn.getResponseCode();
    }

    public void logToFile(String message) {
        try {
            FileWriter writer = new FileWriter("notifications.log", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            // ignore
        }
    }
}

