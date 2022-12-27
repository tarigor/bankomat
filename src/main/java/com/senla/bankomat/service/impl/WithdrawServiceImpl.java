package com.senla.bankomat.service.impl;

import com.senla.bankomat.exceptions.NotSufficientBalanceException;
import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.IWithdrawService;
import org.apache.log4j.Logger;

import java.io.IOException;

public class WithdrawServiceImpl extends BaseService implements IWithdrawService {
    private static final Logger LOGGER = Logger.getLogger(WithdrawServiceImpl.class);
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();
    private static final CheckBalanceServiceImpl checkBalanceService = CheckBalanceServiceImpl.getInstance();

    @Override
    public void execute() throws IOException, NotSufficientBalanceException {

        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                checkBalanceService.execute();
                double withdrawAmount = getDoubleFromConsole("Please enter the amount for withdraw");
                //checkMoneyInBankomat(withdrawAmount);
                checkCurrentBalance(withdrawAmount);
                double balanceAfterWithdraw = Math.round((getClients().get(i).getBalance() - withdrawAmount) * 100.0) / 100.0;
                LOGGER.info("balance after withdraw -> " + balanceAfterWithdraw);
                getClients().get(i).setBalance(balanceAfterWithdraw);
            }
        }
        fileService.writeToFile(getClients());
    }

    private void checkCurrentBalance(double withdrawAmount) throws NotSufficientBalanceException {
        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                if (getClients().get(i).getBalance() - withdrawAmount < 0) {
                    throw new NotSufficientBalanceException("Not enough money on the balance to withdraw");
                }
            }
        }
    }
}
