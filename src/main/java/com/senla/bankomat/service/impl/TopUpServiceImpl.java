package com.senla.bankomat.service.impl;

import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.ITopUpService;

import java.io.IOException;

public class TopUpServiceImpl extends BaseService implements ITopUpService {
    private final CheckBalanceServiceImpl checkBalanceService = CheckBalanceServiceImpl.getInstance();
    private final FileServiceImpl fileService = FileServiceImpl.getInstance();

    @Override
    public void execute() throws IOException {
        checkBalanceService.execute();
        double topUpAmount = getDoubleFromConsole("Please enter the desired value to top-up");
        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                getClients().get(i).setBalance(getClients().get(i).getBalance() + topUpAmount);
                System.out.println("new balance: " + getClients().get(i).getBalance());
            }
        }
        fileService.writeToFile(getClients());
    }
}
