package com.Priemier.UserMicroservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    private String email;
    private String password;

}
