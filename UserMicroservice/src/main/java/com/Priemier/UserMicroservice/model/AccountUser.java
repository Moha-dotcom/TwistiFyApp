package com.Priemier.UserMicroservice.model;

import com.Priemier.UserMicroservice.ValidPassword;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "UserData")
public class AccountUser {
    @JsonSerialize(using= ToStringSerializer.class)

    private ObjectId userId;
    @Valid
    @NotBlank(message = "Username is not optional")
    @Size(
            min = 5,
            max = 14,
            message = "The  username '${validatedValue}' must be between {min} and {max} characters long"
    )
    private String username;
    @Valid
    @NotBlank(message = "email is not optional")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    private String email;
    @Valid
    @NotBlank(message = "password is not optional")
    @ValidPassword(message = "Invalid Password")
    private String password;

}
