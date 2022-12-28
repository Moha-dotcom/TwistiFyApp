package com.Priemier.UserMicroservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountUser {
    private int userId;
    private String email;
    private String password;
}
