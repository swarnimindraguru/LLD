package com.scaler.splitwise;

import com.scaler.splitwise.commands.Command;
import com.scaler.splitwise.commands.CommandRegistry;
import com.scaler.splitwise.commands.RegisterUserCommand;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    private Scanner scanner;

    private CommandRegistry commandRegistry;
    @Autowired
    public SplitwiseApplication(CommandRegistry commandRegistry) {
        scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void run (String... args) throws Exception {
        while(true){
            System.out.println("Tell what you want to do?");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

}
