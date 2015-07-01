package com.craft;

import java.time.Clock;
import java.util.List;

public interface Account {

    void deposit(int amount);

    void withdraw(int amount);

    void printStatement();
}