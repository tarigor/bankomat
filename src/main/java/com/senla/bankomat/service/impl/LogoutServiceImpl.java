package com.senla.bankomat.service.impl;

import com.senla.bankomat.service.BaseService;

public class LogoutServiceImpl extends BaseService {
    @Override
    public void execute() {
        setLoggedClientId(0);
    }
}
