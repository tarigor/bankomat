package com.senla.bankomat.service.impl;

import com.senla.bankomat.constants.MenuItems;
import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.IConsoleMenuViewService;

import java.util.Map;
import java.util.TreeMap;

public class ConsoleMenuViewServiceImpl extends BaseService implements IConsoleMenuViewService {
    private static final ConsoleMenuViewServiceImpl consoleMenuViewService = new ConsoleMenuViewServiceImpl();

    public static ConsoleMenuViewServiceImpl getInstance() {
        return consoleMenuViewService;
    }

    @Override
    public Map<Integer, MenuItems> showMenu() {
        if (getLoggedClientId() == 0) {
            return composeMenu(Map.of(0, MenuItems.LOGIN));
        } else {
            return composeMenu(Map.of(0, MenuItems.CHECK_BALANCE, 1, MenuItems.TOP_UP, 2, MenuItems.WITHDRAW, 3, MenuItems.LOG_OUT));
        }
    }

    private Map<Integer, MenuItems> composeMenu(Map<Integer, MenuItems> menuItemsMap) {
        System.out.println("---------------------");
        for (Map.Entry<Integer, MenuItems> entry : new TreeMap<>(menuItemsMap).entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getDescription());
        }
        System.out.println("---------------------");
        return menuItemsMap;
    }

}
