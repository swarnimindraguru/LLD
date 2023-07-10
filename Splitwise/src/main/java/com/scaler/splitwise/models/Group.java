package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group extends BaseModel {
    private String description;
    @ManyToMany
    private List<User> members;
    private String name;
    @ManyToOne
    private User createdBy;
}
