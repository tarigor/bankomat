package com.senla.bankomat.service;

public interface IClientService {
    double checkBalance(int clientId);

    boolean withdrawMoney(int clientId, double moneyAmount);

    boolean topUpBalance(int clientId, double moneyAmount);
}
