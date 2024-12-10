package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Order;
import edu.sdccd.cisc191.template.SerializationUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class DataPersistence
{
    private static final String ORDERS_FILE = "orders.json";

    public static void saveOrders(List<Order> orders) throws Exception
    {
        String json = SerializationUtil.serialize(orders);
        try (FileWriter writer = new FileWriter(new File(ORDERS_FILE)))
        {
            writer.write(json);
        }
    }

    public static List<Order> loadOrders() throws Exception
    {
        File file = new File(ORDERS_FILE);
        if (!file.exists())
        {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(file))
        {
            return SerializationUtil.deserialize(reader.toString(), List.class);
        }
    }
}
