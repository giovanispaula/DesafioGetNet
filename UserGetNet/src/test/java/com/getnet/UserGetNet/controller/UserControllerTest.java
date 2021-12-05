package com.getnet.UserGetNet.controller;

import com.getnet.UserGetNet.model.Users;
import com.getnet.UserGetNet.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllTest() {
        assertEquals(userRepository.findAll().size(), 3);
    }

    @Test
    public void findUserByIdTest() throws Exception {
        Optional<Users> user = userController.findUserById(1L);

        if (user.isPresent()) {
            assertEquals("GetNet", user.get().getName());
            assertEquals("EtPd8!gof", user.get().getPassword());
            assertEquals("getnet@getnet.com", user.get().getEmail());
        } else {
            throw new Exception("Usuário não encontrado!");
        }
    }

    @Test
    public void saveUserTest() throws Exception {
        Users user = new Users("Testing", "ElgH8!gof", "testing@test.com");
        userRepository.save(user);

        assertEquals("Testing", user.getName());
        assertEquals("ElgH8!gof", user.getPassword());
        assertEquals("testing@test.com", user.getEmail());

    }

    @Test
    public void updateUserTest() {
        Users user = new Users("Testing", "ElgH8!gof", "testing@test.com");
        this.userRepository.save(user);

        user.setName("UpdatedUser");
        user.setPassword("Abc3!fop9");
        user.setEmail("update@update.com");
        this.userRepository.save(user);

        assertEquals("UpdatedUser", user.getName());
        assertEquals("Abc3!fop9", user.getPassword());
        assertEquals("update@update.com", user.getEmail());
    }

    @Test
    public void findUserByNameTest() throws Exception {
        List<Users> usersFilter = userRepository.findUserByName("Tester");

        assertEquals(1, usersFilter.size());

    }
}
