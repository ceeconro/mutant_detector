package com.detector.mutantdetector.entiry;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "users")
public class User {
	
	@Id
    int id;
    String name;
    String age;

}
