package com.senla.bankomat.service;

import com.senla.bankomat.entity.Client;
import com.senla.bankomat.exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseService {
    protected static int loggedClientId;
    protected static ArrayList<Client> clients = new ArrayList<>();
    protected static double bankomatBalance;

    private final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Client> getClients() {
        return clients;
    }

    protected static int getLoggedClientId() {
        return loggedClientId;
    }

    protected void setLoggedClientId(int loggedClientId) {
        BaseService.loggedClientId = loggedClientId;
    }

    public static double getBankomatBalance() {
        return bankomatBalance;
    }

    public static void setBankomatBalance(double bankomatBalance) {
        BaseService.bankomatBalance = bankomatBalance;
    }

    public void execute() throws InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException, NotSufficientBalanceException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException {
    }

    protected int getIntFromConsole(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    protected String getStringFromConsole(String message, String pattern) throws InputErrorException {
        System.out.println(message);
        try {
            return scanner.next(pattern);
        } catch (InputMismatchException e) {
            throw new InputErrorException("wrong input");
        }
    }

    protected double getDoubleFromConsole(String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }
}
