package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserExpense extends BaseModel{
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType userExpenseType;
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
}
