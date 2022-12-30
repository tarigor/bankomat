package com.senla.bankomat.service.impl;

import com.senla.bankomat.exceptions.InputErrorException;
import com.senla.bankomat.exceptions.NotEnoughMoneyInBankomatException;
import com.senla.bankomat.exceptions.NotSufficientBalanceException;
import com.senla.bankomat.service.BaseService;

import java.io.IOException;

public class WithdrawServiceImpl extends BaseService {
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();
    private static final CheckBalanceServiceImpl checkBalanceService = CheckBalanceServiceImpl.getInstance();

    @Override
    public void execute() throws IOException, NotSufficientBalanceException, NotEnoughMoneyInBankomatException, InputErrorException {

        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).getClientId() == getLoggedClientId()) {
                checkBalanceService.execute();
                double withdrawAmount = getDoubleFromConsole("Please enter the amount for withdraw");
                checkCurrentBalance(withdrawAmount);
                checkMoneyInBankomat(withdrawAmount);
                double balanceAfterWithdraw = Math.round((getClients().get(i).getBalance() - withdrawAmount) * 100.0) / 100.0;
                System.out.println("balance after withdraw -> " + balanceAfterWithdraw);
                getClients().get(i).setBalance(balanceAfterWithdraw);
                setBankomatBalance(getBankomatBalance() - withdrawAmount);
            }
        }
        fileService.writeToFile(getBankomatBalance());
        fileService.writeToFile(getClients());
    }

    private void checkMoneyInBankomat(double withdrawAmount) throws NotEnoughMoneyInBankomatException {
        if (withdrawAmount > getBankomatBalance()) {
            throw new NotEnoughMoneyInBankomatException("Not enough money in bankomat to withdraw the requested amount");
        }
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
