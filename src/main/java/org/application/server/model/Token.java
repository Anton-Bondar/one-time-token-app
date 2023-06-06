package org.application.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Token {
   @Id
   private String id;
   @Indexed(unique = true)
   private String value;

    public Token() {
    }

    public Token(String id, String token) {
        this.id = id;
        this.value = token;
    }

    public Token(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
