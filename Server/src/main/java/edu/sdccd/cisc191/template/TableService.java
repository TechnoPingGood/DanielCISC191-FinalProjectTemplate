package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Table;
import java.util.ArrayList;
import java.util.List;

public class TableService
{
    private List<Table> tables = new ArrayList<>();

    public TableService()
    {
        for(int i = 0; i <= 9; i++)
        {
            Table table = new Table();
            table.setTableId(String.valueOf(i));
            table.setNumber(i);
            table.setCapacity(4);
            table.setOccupied(false);
            tables.add(table);
        }
    }

    public List<Table> getTables()
    {
        return tables;
    }

    public void occupyTable(String tableId)
    {
        tables.stream()
                .filter(t -> t.getTableId().equals(tableId))
                .forEach(t -> t.setOccupied(true));
    }

    public void freeTable(String tableId)
    {
        tables.stream()
                .filter(t -> t.getTableId().equals(tableId))
                .forEach(t -> t.setOccupied(false));
    }
}
