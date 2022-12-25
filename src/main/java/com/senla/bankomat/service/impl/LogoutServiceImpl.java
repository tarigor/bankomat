package com.senla.bankomat.service.impl;

import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.ILogoutService;

public class LogoutServiceImpl extends BaseService implements ILogoutService {
    @Override
    public void execute() {
        setLoggedClientId(0);
    }
}
