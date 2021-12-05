package com.getnet.UserGetNet.config;

import com.getnet.UserGetNet.model.Users;
import com.getnet.UserGetNet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Component
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception{
        userRepository.save(new Users("GetNet", "EtPd8!gof", "getnet@getnet.com"));
        userRepository.save(new Users("Giovani", "Gio02)get", "giovani@getnet.com"));
        userRepository.save(new Users("Tester", "Test!23dk", "Tester@getnet.com"));
    }
}
