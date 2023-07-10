package com.scaler.splitwise.strategies.settleupstrategy;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.UserExpense;
import com.scaler.splitwise.repositories.UserExpenseRepository;
import com.scaler.splitwise.services.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TwoSetsSettleUpStrategy implements SettleUpStrategy {
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    public TwoSetsSettleUpStrategy(UserExpenseRepository userExpenseRepository){
        this.userExpenseRepository=userExpenseRepository;
    }
    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        List<UserExpense> allUserExpensesForTheseExpenses = userExpenseRepository.findAllByExpenseIn(expenses);


        for(Expense expense: expenses){

        }
        return null;
    }
}
