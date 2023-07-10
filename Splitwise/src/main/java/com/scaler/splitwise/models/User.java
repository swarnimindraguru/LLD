package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    private String name;
    private String phone;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;
    @ManyToMany(mappedBy = "members")
    private List<Group> groups;
}
