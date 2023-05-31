package com.example.specification.init;

import com.example.specification.model.UserProfile;
import com.example.specification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public InitDatabase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initUsers();
    }

    private void initUsers() {
        createUser("John", "Doe", "johnDoe", "johnDoe@gmail.com");
        createUser("Tom", "Doe", "tomDoe", "tomDoe@gmail.com");
        createUser("Mohamed", "Bahrini", "mbahrini", "mohamed.bahrini@gmail.com");
    }

    private void createUser(String firstName, String lastName, String userName, String email) {
        UserProfile user = new UserProfile();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(userName);
        user.setEmail(email);
        userRepository.save(user);
    }
}
