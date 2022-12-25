package com.senla.bankomat.service;

import com.senla.bankomat.service.constants.MenuItems;

import java.util.Map;

public interface IConsoleMenuViewService {
    Map<Integer, MenuItems> showMenu();
}
