package space.nullpoint.secretsanta0;

import space.nullpoint.secretsanta0.mail.Mail;
import space.nullpoint.secretsanta0.model.Gender;
import space.nullpoint.secretsanta0.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Mixer.stir(getUsers());
        Mail.sendAllMail(users);
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            while (!(s = reader.readLine()).isEmpty()) {
                String[] line = s.split("\t");
                if (line.length < 3) continue;

                String email = line[0];
                String name = line[1];
                Gender gender = (line[2].equals("Мужской")) ? Gender.Man : Gender.Woman;

                users.add(new User(name, email, gender));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
