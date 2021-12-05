package com.getnet.UserGetNet.controller;

import com.getnet.UserGetNet.error.CustomError;
import com.getnet.UserGetNet.model.Users;
import com.getnet.UserGetNet.repositories.UserRepository;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
@Api(value = "users", tags = "Usuários Getnet")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    POST para cadastrar novo usuário.
        @ApiOperation(value = "Cadastro de novos usuários", nickname = "saveUserUsingPOST", response = Users.class)
        @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = Users.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Users saveUser(@ApiParam(value = "Cadastro" ,required=true ) @Valid @RequestBody Users user) throws Exception {
        return userRepository.save(user);

    }

//    GET para buscar usuário por Id.
        @ApiOperation(value = "Buscar usuário por Id", nickname = "findUserByIdUsingGET", response = Users.class)
        @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Users.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/users/{id}")
    public Optional<Users> findUserById(@ApiParam(value = "Digitar número do Id do usuário a ser buscado",required=true) @PathVariable("id") Long id) throws Exception {
        Optional<Users> u = userRepository.findById(id);
        if (u.isPresent()) {
            return userRepository.findById(id);
        } else {
            throw new CustomError("Usuário não encontrado pelo id: " + id);
        }
    }

//    GET para listar todos os usuários
        @ApiOperation(value = "Lista de Usuários", nickname = "findAllUsersUsingGET", response = Users.class, responseContainer = "List")
        @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Users.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/users")
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

//    PUT para atualizar um usuário buscando pelo Id.
        @ApiOperation(value = "Atualizar dados de usuário", nickname = "updateUserUsingPUT", response = Users.class)
        @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Users.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@ApiParam(value = "Digitar id do usuário a ser alterado",required=true) @PathVariable("id") Long id, @RequestBody Users newUser) throws Exception {
        Optional<Users> u = userRepository.findById(id);

        if (u.isPresent()) {
            Users user = u.get();
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            userRepository.save(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } else {
            throw new CustomError("Usuário não encontrado pelo id: " + id);
        }
    }

//    GET para filtrar usuários por nome.
        @ApiOperation(value = "Buscar usuário por nome", nickname = "findUserByNameUsingGET", response = Users.class, responseContainer = "List")
        @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Users.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/users/filter/{name}")
    @ResponseBody
    public ResponseEntity<List<Users>> findUserByName(@ApiParam(value = "Digitar nome ou parte do nome",required=true)@PathVariable("name") String name){
            List<Users> user = userRepository.findUserByName(name);
            return new ResponseEntity<List<Users>>(user, HttpStatus.OK);
    }
}
