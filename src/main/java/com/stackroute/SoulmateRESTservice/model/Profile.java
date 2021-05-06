package com.stackroute.SoulmateRESTservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
public class Profile {
    @Id
    private int id;
    private String name;
    private String gender;
    private int age;
}
