package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;
import java.util.List;

//visibilité publique, Classe UserRepository
public class UserRepository {
// constante, visibilité privée, Type ApiService nom apiservice
    private final ApiService apiService; // TODO: A utiliser
//visibilité publique,
    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
            }

    public List<User> getUsers() {
        // TODO: A modifier

        return apiService.getUsers();
    }

    public void generateRandomUser() {
        // TODO: A modifier
        apiService.generateRandomUser();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        apiService.deleteUser(user);
    }
}
