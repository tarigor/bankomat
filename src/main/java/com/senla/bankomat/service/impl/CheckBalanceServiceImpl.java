package com.senla.bankomat.service.impl;

import com.senla.bankomat.service.BaseService;

public class CheckBalanceServiceImpl extends BaseService {
    private static final CheckBalanceServiceImpl checkBalanceService = new CheckBalanceServiceImpl();

    public static CheckBalanceServiceImpl getInstance() {
        return checkBalanceService;
    }

    @Override
    public void execute() {
        System.out.println("The balance on card is: " + getClients().stream()
                .filter(c -> c.getClientId() == getLoggedClientId())
                .findFirst()
                .get()
                .getBalance());
    }
}
