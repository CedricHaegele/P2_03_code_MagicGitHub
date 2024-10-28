package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public abstract class FakeApiServiceGenerator {


    static List<User> generateUsers() {
        return new ArrayList<>(FAKE_USERS);
    }

    public static List<User> FAKE_USERS = Arrays.asList(
            new User("001", "Jake", "https://avatars.githubusercontent.com/u/1?v=4"),
            new User("002", "Paul", "https://avatars.githubusercontent.com/u/2?v=4"),
            new User("003", "Phil", "https://avatars.githubusercontent.com/u/3?v=4"),
            new User("004", "Guillaume", "https://avatars.githubusercontent.com/u/4?v=4"),
            new User("005", "Francis", "https://avatars.githubusercontent.com/u/5?v=4"),
            new User("006", "George", "https://avatars.githubusercontent.com/u/6?v=4"),
            new User("007", "Louis", "https://avatars.githubusercontent.com/u/7?v=4"),
            new User("008", "Mateo", "https://avatars.githubusercontent.com/u/8?v=4"),
            new User("009", "April", "https://avatars.githubusercontent.com/u/9?v=4"),
            new User("010", "Louise", "https://avatars.githubusercontent.com/u/10?v=4"),
            new User("011", "Elodie", "https://avatars.githubusercontent.com/u/11?v=4"),
            new User("012", "Helene", "https://avatars.githubusercontent.com/u/12?v=4"),
            new User("013", "Fanny", "https://avatars.githubusercontent.com/u/13?v=4"),
            new User("014", "Laura", "https://avatars.githubusercontent.com/u/14?v=4"),
            new User("015", "Gertrude", "https://avatars.githubusercontent.com/u/15?v=4"),
            new User("016", "Chloé", "https://avatars.githubusercontent.com/u/16?v=4"),
            new User("017", "April", "https://avatars.githubusercontent.com/u/17?v=4"),
            new User("018", "Marie", "https://avatars.githubusercontent.com/u/18?v=4"),
            new User("019", "Henri", "https://avatars.githubusercontent.com/u/19?v=4"),
            new User("020", "Rémi", "https://avatars.githubusercontent.com/u/20?v=4")
    );

    public static List<User> FAKE_USERS_RANDOM = Arrays.asList(
            new User("021", "Lea", "https://avatars.githubusercontent.com/u/21?v=4"),
            new User("022", "Geoffrey", "https://avatars.githubusercontent.com/u/22?v=4"),
            new User("023", "Simon", "https://avatars.githubusercontent.com/u/23?v=4"),
            new User("024", "André", "https://avatars.githubusercontent.com/u/24?v=4"),
            new User("025", "Leopold", "https://avatars.githubusercontent.com/u/25?v=4")
    );
}
