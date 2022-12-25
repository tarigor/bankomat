package com.senla.bankomat.service;

public interface IConsoleService {
    int login(int[] cardNumber, int pinCode);

    boolean logout();
}
