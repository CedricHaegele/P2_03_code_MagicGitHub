package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;

import java.util.List;

/**
 * Interface définissant les opérations possibles sur l'API
 * Suit le pattern Interface Segregation Principle de SOLID
 */
public interface ApiService {
    /**
     * Récupère la liste des utilisateurs
     * @return Liste des utilisateurs
     */
    List<User> getUsers();

    /**
     * Supprime un utilisateur
     * @param user Utilisateur à supprimer
     */
    void deleteUser(User user);

    /**
     * Génère un nouvel utilisateur aléatoire
     */
    void generateRandomUser();
}
