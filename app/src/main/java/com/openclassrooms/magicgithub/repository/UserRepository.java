package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.List;

/**
 * Couche Repository qui gère les données des utilisateurs
 * Suit le pattern Repository pour séparer la logique métier de la source de données
 */
public class UserRepository {

    private final ApiService apiService; // Service qui gère les appels API

    /**
     * Constructeur qui initialise le repository avec un service API
     * @param apiService Service qui gère les interactions avec l'API
     */
    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Récupère la liste des utilisateurs
     * @return Liste des utilisateurs depuis l'API
     */
    public List<User> getUsers() {
        return apiService.getUsers();
    }

    /**
     * Génère et ajoute un utilisateur aléatoire
     */
    public void generateRandomUser() {
        apiService.generateRandomUser();
    }

    /**
     * Supprime un utilisateur de la liste
     * @param user Utilisateur à supprimer
     */
    public void deleteUser(User user) {
        apiService.deleteUser(user);
    }
}
