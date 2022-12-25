package com.senla.bankomat.service.impl;

import com.senla.bankomat.exceptions.*;
import com.senla.bankomat.factory.ServiceFactoryImpl;
import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.constants.MenuItems;

import java.io.IOException;
import java.util.Map;

public class MenuRoutineImpl extends BaseService {
    private static final MenuRoutineImpl menuRoutine = new MenuRoutineImpl();
    private static final ServiceFactoryImpl serviceFactory = ServiceFactoryImpl.getInstance();

    public static MenuRoutineImpl getInstance() {
        return menuRoutine;
    }

    public void menuCommandExecute(Map<Integer, MenuItems> itemsHashMap) throws InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException, ServiceMissingException {
        serviceFactory.getService(itemsHashMap.get(getIntFromConsole("Select the desire action"))).execute();
    }
}
