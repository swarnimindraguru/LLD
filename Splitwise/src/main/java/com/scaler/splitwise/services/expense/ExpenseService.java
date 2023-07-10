package com.scaler.splitwise.services.expense;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.models.UserExpense;
import com.scaler.splitwise.repositories.UserExpenseRepository;
import com.scaler.splitwise.repositories.UserRepository;
import com.scaler.splitwise.strategies.settleupstrategy.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ExpenseService {
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;
@Autowired
    public ExpenseService(UserRepository userRepository, UserExpenseRepository userExpenseRepository){
        this.userRepository=userRepository;
        this.userExpenseRepository=userExpenseRepository;
    }
    public List<Transaction> settleUpUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            //throw Exception
            return  null;
        }

        List<UserExpense> userExpenses = userExpenseRepository.findAllByUser(userOptional.get());

        List<Expense> expenseInvolvingUser = new ArrayList<>();
        for(UserExpense userExpense : userExpenses) {
            expenseInvolvingUser.add(userExpense.getExpense());
        }

        return null;
    }
}
