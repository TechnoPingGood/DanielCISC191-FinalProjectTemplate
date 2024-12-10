package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Request;
import edu.sdccd.cisc191.template.Response;
import edu.sdccd.cisc191.template.SerializationUtil;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkClient
{
    private String host;
    private int port;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public NetworkClient(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    public void connect()
    {
        try
        {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Response sendRequest(Request request) throws Exception
    {
        out.writeObject(request);
        return (Response) in.readObject();
    }

    public void disconnect()
    {
        try
        {
            in.close();
            out.close();
            socket.close();
            System.out.println("Disconnected from server.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

