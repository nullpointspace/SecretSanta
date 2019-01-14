package space.nullpoint.secretsanta0;

import lombok.Getter;
import space.nullpoint.secretsanta0.model.Gender;
import space.nullpoint.secretsanta0.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Mixer {

    @Getter
    private static long seed;
    private static Random random;

    static {
        seed = System.currentTimeMillis();
        System.out.println("Seed: " + seed);
        random = new Random(seed);
    }

    public static List<User> stir(List<User> men, List<User> women) {
        List<User> users = new ArrayList<User>();
        int k = Math.min(men.size(), women.size()) * 2;

        for (int i = 0; i < k; i++) {
            if ((i & 1) == 0) {
                int n = random.nextInt(men.size());
                users.add(men.remove(n));
            } else {
                int n = random.nextInt(women.size());
                users.add(women.remove(n));
            }
        }

        if (!women.isEmpty()) {
            men = women;
        }

        if (!men.isEmpty()) {
            while (!men.isEmpty()) {
                int n = random.nextInt(men.size());
                users.add(men.remove(n));
            }
        }

        return setWard(users);
    }

    public static List<User> stir(List<User> users) {
        List<User> men = new ArrayList<User>();
        List<User> women = new ArrayList<User>();

        for (User user : users) {
            if (user.getGender() == Gender.Man)
                men.add(user);
            else
                women.add(user);
        }

        return stir(men, women);
    }

    private static List<User> setWard(List<User> users) {
        for (int i = 0; i < users.size() - 1; i++) {
            users.get(i).setWard(users.get(i + 1));
        }
        users.get(users.size() - 1).setWard(users.get(0));
        return users;
    }
}
