package com.senla.bankomat.service.impl;

import com.senla.bankomat.service.BaseService;
import org.apache.log4j.Logger;

public class CheckBalanceServiceImpl extends BaseService {
    private static final Logger LOGGER = Logger.getLogger(CheckBalanceServiceImpl.class);
    private static final CheckBalanceServiceImpl checkBalanceService = new CheckBalanceServiceImpl();

    public static CheckBalanceServiceImpl getInstance() {
        return checkBalanceService;
    }

    @Override
    public void execute() {
        LOGGER.info("The balance on card is: " + getClients().stream()
                .filter(c -> c.getClientId() == getLoggedClientId())
                .findFirst()
                .get()
                .getBalance());
    }
}
