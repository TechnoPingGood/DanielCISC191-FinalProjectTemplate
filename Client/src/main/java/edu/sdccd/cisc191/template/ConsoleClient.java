package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.NetworkClient;
import edu.sdccd.cisc191.template.Request;
import edu.sdccd.cisc191.template.Response;
import edu.sdccd.cisc191.template.MenuItem;
import java.util.List;
import java.util.Scanner;

public class ConsoleClient
{
    private NetworkClient networkClient = new NetworkClient("localhost", 12345);
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        new ConsoleClient().start();
    }

    public void start()
    {
        networkClient.connect();
        boolean running = true;
        while (running)
        {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice)
            {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    manageTables();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        networkClient.disconnect();
    }

    private void printMenu()
    {
        System.out.println("=== Restaurant Client ===");
        System.out.println("1. View Menu");
        System.out.println("2. Place Order");
        System.out.println("3. Manage Tables");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void viewMenu()
    {
        try {
            Request request = new Request();
            request.setAction("GET_MENU");
            Response response = networkClient.sendRequest(request);
            if ("SUCCESS".equals(response.getStatus())) {
                List<MenuItem> menu = (List<MenuItem>) response.getPayload();
                menu.forEach(item -> System.out.println(item.getName() + " - $" + item.getPrice()));
            } else {
                System.out.println("Error: " + response.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private void placeOrder()
    {
        // Implementation for placing an order via console
        System.out.println("Place Order functionality not yet implemented.");
    }

    private void manageTables()
    {
        // Implementation for managing tables via console
        System.out.println("Manage Tables functionality not yet implemented.");
    }
}
