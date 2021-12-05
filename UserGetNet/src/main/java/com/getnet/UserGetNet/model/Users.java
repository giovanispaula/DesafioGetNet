package com.getnet.UserGetNet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Campo não informado!")
    @Column(nullable = false)
    private String name;

    @Pattern(regexp = "^(?=.*[0-9])(?!.*(.)\\1)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%¨&*()_+])(?=\\S+$).{9,}$", message = "Senha deve possuir 9 caracteres não repetidos, sendo 01 digito, 01 letra maiúscula, 01 letra minuscula e 01 caracter especial")
    @Column(nullable = false)
    private String password;

    @Email(message = "Campo inválido!")
    @NotBlank(message = "Campo não informado!")
    @Column(nullable = false)
    private String email;

    public Users(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
