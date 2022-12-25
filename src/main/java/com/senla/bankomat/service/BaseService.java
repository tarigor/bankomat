package com.senla.bankomat.service;

import com.senla.bankomat.entity.Client;
import com.senla.bankomat.exceptions.AccountBlockException;
import com.senla.bankomat.exceptions.InputErrorException;
import com.senla.bankomat.exceptions.NoSuchCardException;
import com.senla.bankomat.exceptions.NoSuchClientException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseService {
    protected static int loggedClientId;
    protected static ArrayList<Client> clients = new ArrayList<>();

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

    public void execute() throws InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException {
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
