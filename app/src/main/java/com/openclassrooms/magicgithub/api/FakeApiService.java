package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;

import java.util.List;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.generateUsers;

//classe implémentant interface ApiService
public class FakeApiService implements ApiService {
    //attribut de type List (interface) nommée users initialisée par generateUsers()
    private List<User> users = generateUsers();

    /**
     * Return a list of {@link User}
     * Those users must be gene rated by {@linkFakeApiServiceGenerator}
     *
     * @return
     */
    //@Override avant ces méthodes précisent qu'elles définissent les méthodes d'une classe mère ou d'une interface
    @Override
    public List<User> getUsers() {
        //TODO: A modifier
        return users;
    }

    /**
     * Generate a random {@link User} and add it {@link FakeApiService#users} list.
     * This user must be get from the {@link FakeApiServiceGenerator#FAKE_USERS_RANDOM} list.
     *
     * @param user
     */
    @Override
    public void generateRandomUser() {
//TODO: A modifier
        users.add(User.random());
    }

    /**
     * Delete a {@link User} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteUser(User user) {
//TODO: A modifier
        users.remove(user);
    }
}

