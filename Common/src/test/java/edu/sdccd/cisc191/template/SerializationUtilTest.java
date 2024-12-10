package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem;
import edu.sdccd.cisc191.template.SerializationUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SerializationUtilTest
{
    @Test
    public void testSerializeDeserialize() throws Exception{
        MenuItem original = new MenuItem();
        original.setId("1");
        original.setName("Test Item");
        original.setDescription("Test Description");
        original.setPrice(9.99);
        original.setCategory("Test Category");

        String json = SerializationUtil.serialize(original);
        assertNotNull(json);

        MenuItem deserialized = SerializationUtil.deserialize(json, MenuItem.class);
        assertEquals(original, deserialized);
    }
}
