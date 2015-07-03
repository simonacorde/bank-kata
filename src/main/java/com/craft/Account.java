package com.craft;

import org.springframework.stereotype.Service;

import java.util.List;


public interface Account {

    void deposit(int amount);

    void withdraw(int amount);

    void printStatement();

}