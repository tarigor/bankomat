package com.senla.bankomat.service.impl;

import com.senla.bankomat.constants.MenuItems;
import com.senla.bankomat.exceptions.*;
import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.IMenuRoutine;
import com.senla.bankomat.service.factory.ServiceFactoryImpl;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;

public class MenuRoutineImpl extends BaseService implements IMenuRoutine {
    private static final MenuRoutineImpl menuRoutine = new MenuRoutineImpl();
    private static final ServiceFactoryImpl serviceFactory = ServiceFactoryImpl.getInstance();

    public static MenuRoutineImpl getInstance() {
        return menuRoutine;
    }

    public void menuCommandExecute(Map<Integer, MenuItems> itemsHashMap)
            throws InputErrorException, NoSuchClientException, IOException, NoSuchCardException,
            AccountBlockException, ServiceMissingException, NotSufficientBalanceException,
            MissingMenuItemException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException {
        serviceFactory.getService(itemsHashMap.get(getIntFromConsole("Select the desire action"))).execute();
    }
}
