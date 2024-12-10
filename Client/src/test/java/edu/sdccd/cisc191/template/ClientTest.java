package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.NetworkClient;
import edu.sdccd.cisc191.template.Request;
import edu.sdccd.cisc191.template.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest
{
    @Test
    public void testSendRequest()
    {
        NetworkClient client = new NetworkClient("localhost", 12345);
        client.connect();
        Request request = new Request();
        request.setAction("GET_MENU");
        try
        {
            Response response = client.sendRequest(request);
            assertNotNull(response);
            assertEquals("SUCCESS", response.getStatus());
            assertNotNull(response.getPayload());
        } catch (Exception e)
        {
            fail("Exception occurred: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
