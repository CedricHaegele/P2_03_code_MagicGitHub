package com.openclassrooms.magicgithub;

import android.app.Application;

import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.repository.UserRepository;

import androidx.annotation.VisibleForTesting;

/**
 * Point d'entrée principal de l'application
 * Cette classe est instanciée en premier lors du démarrage de l'app
 */
public class MagicGithubApplication extends Application {

    private UserRepository userRepository;

    // ---

    public UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    @VisibleForTesting
    public void resetUserRepository() {
        userRepository = null;
    }
}
