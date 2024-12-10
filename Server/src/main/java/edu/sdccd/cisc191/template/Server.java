package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Request;
import edu.sdccd.cisc191.template.Response;
import edu.sdccd.cisc191.template.OrderService;
import edu.sdccd.cisc191.template.MenuService;
import edu.sdccd.cisc191.template.TableService;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
    private static final int PORT = 12345;
    private boolean running = true;
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    private MenuService menuService = new MenuService();
    private OrderService orderService = new OrderService();
    private TableService tableService = new TableService();

    public static void main(String[] args)
    {
        System.out.println("Server is running");
        new Server().start();
    }

    public void start()
    {
        try (ServerSocket serverSocket = new ServerSocket(PORT))
        {
            System.out.println("Server started and listening on port " + PORT);
            while (running)
            {
                Socket clientSocket = serverSocket.accept();
                executor.submit(() -> handleClient(clientSocket));
            }
            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket)
    {
        try (
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        )
        {
            Request request = (Request) in.readObject();
            Response response = processRequest(request);
            out.writeObject(response);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Response processRequest(Request request) {
        Response response = new Response();
        try
        {
            switch (request.getAction())
            {
                case "GET_MENU":
                    response.setPayload(menuService.getMenu());
                    response.setStatus("SUCCESS");
                    break;
                case "ADD_ORDER":
                    orderService.addOrder((edu.sdccd.cisc191.template.Order) request.getPayload());
                    response.setStatus("SUCCESS");
                    break;
                case "GET_TABLES":
                    response.setPayload(tableService.getTables());
                    response.setStatus("SUCCESS");
                    break;
                // Add more cases as needed
                default:
                    response.setStatus("ERROR");
                    response.setMessage("Unknown action: " + request.getAction());
            }
        } catch (Exception e)
        {
            response.setStatus("ERROR");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
