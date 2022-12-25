package com.senla.bankomat.service.impl;

import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.IWithdrawService;

public class WithdrawServiceImpl extends BaseService implements IWithdrawService {
    @Override
    public void execute() {
        System.out.println("in withdraw service");
    }
}
