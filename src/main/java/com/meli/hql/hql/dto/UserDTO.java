package com.meli.hql.hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.hql.hql.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String name;

    @JsonProperty("password")
    private String password;

    public UserDTO(User user) {
        this.id =  user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
