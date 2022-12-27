package com.senla.bankomat.service;

import com.senla.bankomat.constants.MenuItems;

import java.util.Map;

public interface IConsoleMenuViewService {
    Map<Integer, MenuItems> showMenu();
}
