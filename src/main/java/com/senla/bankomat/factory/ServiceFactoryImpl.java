package com.senla.bankomat.factory;

import com.senla.bankomat.exceptions.ServiceMissingException;
import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.constants.MenuItems;
import com.senla.bankomat.service.impl.*;

public class ServiceFactoryImpl {
    private static final ServiceFactoryImpl serviceFactory = new ServiceFactoryImpl();

    public static ServiceFactoryImpl getInstance() {
        return serviceFactory;
    }

    public BaseService getService(MenuItems menuItems) throws ServiceMissingException {
        switch (menuItems) {
            case CHECK_BALANCE:
                return new CheckBalanceServiceImpl();
            case TOP_UP:
                return new TopUpServiceImpl();
            case WITHDRAW:
                return new WithdrawServiceImpl();
            case LOGIN:
                return new LoginServiceImpl();
            case LOG_OUT:
                return new LogoutServiceImpl();
            default:
                throw new ServiceMissingException("Illegal service type");
        }
    }

}
