package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MenuService {
    private List<MenuItem> menu;
    private Map<String, MenuItem> menuMap;

    public MenuService()
    {
        menu = new ArrayList<>();
        menuMap = new HashMap<>();
        for(MenuItem item : menu)
        {
            menuMap.put(item.getId(), item);
        }
    }

    public MenuItem getMenuItemById(String id)
    {
        return menuMap.get(id);
    }

    public List<MenuItem> getMenu()
    {
        return menu;
    }

    public List<MenuItem> getMenuSortedByName()
    {
        return menu.stream()
                .sorted(Comparator.comparing(MenuItem::getName))
                .collect(Collectors.toList());
    }

    public List<MenuItem> getMenuSortedByPrice()
    {
        return menu.stream()
                .sorted(Comparator.comparingDouble(MenuItem::getPrice))
                .collect(Collectors.toList());
    }
}
