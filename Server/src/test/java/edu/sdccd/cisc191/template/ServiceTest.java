package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ServiceTest
{
    @Test
    public void testGetMenu()
    {
        MenuService menuService = new MenuService();
        List<MenuItem> menu = menuService.getMenu();
        assertNotNull(menu);
        assertFalse(menu.isEmpty());
    }
}
