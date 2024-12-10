package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationUtil
{
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String serialize(Object obj) throws Exception
    {
        return mapper.writeValueAsString(obj);
    }

    public static <T> T deserialize(String json, Class<T> cls) throws Exception
    {
        return mapper.readValue(json, cls);
    }
}
