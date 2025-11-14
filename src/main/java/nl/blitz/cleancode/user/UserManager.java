package nl.blitz.cleancode.user;

import java.util.ArrayList;
import java.util.List;

class UserManager {
    public List<User> userList;
    public int cnt;
    public String nm;

    public UserManager() {
        userList = new ArrayList<>();
        cnt = 0;
    }

    public void add(String n, String e, int a, boolean v, boolean a2) {
        User u = new User();
        u.name = n;
        u.email = e;
        u.age = a;
        u.verified = v;
        u.active = a2;
        userList.add(u);
        cnt++;
    }

    public User find(String e) {
        for (User u : userList) {
            if (u.email.equals(e)) {
                return u;
            }
        }
        return null;
    }

    public boolean isNotInvalid(User u) {
        if (u == null) {
            return false;
        }
        if (u.age < 0 || u.age > 150) {
            return false;
        }
        if (u.email == null || !u.email.contains("@")) {
            return false;
        }
        return true;
    }

    public void process(User u, boolean includeDeleted, boolean sendEmail, boolean updateStats) {
        if (u == null) {
            return;
        }
        if (!includeDeleted && !u.active) {
            return;
        }
        // update user
        u.lastModified = System.currentTimeMillis();
        if (sendEmail) {
            // send email
            System.out.println("Email sent to " + u.email);
        }
        if (updateStats) {
            cnt++;
        }
    }

    public class User {
        public String name;
        public String email;
        public int age;
        public boolean verified;
        public boolean active;
        public long lastModified;
    }
}

