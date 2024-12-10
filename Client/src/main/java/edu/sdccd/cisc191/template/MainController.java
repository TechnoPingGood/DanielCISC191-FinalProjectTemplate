package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.NetworkClient;
import edu.sdccd.cisc191.template.Request;
import edu.sdccd.cisc191.template.Response;
import edu.sdccd.cisc191.template.MenuItem;
import edu.sdccd.cisc191.template.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.List;

public class MainController
{
    @FXML
    private ListView<String> listView;

    @FXML
    private Label statusLabel;

    private NetworkClient networkClient = new NetworkClient("localhost", 12345);

    @FXML
    public void initialize()
    {
        networkClient.connect();
    }

    @FXML
    private void handleViewMenu()
    {
        try
        {
            Request request = new Request();
            request.setAction("GET_MENU");
            Response response = networkClient.sendRequest(request);
            if("SUCCESS".equals(response.getStatus()))
            {
                List<MenuItem> menu = (List<MenuItem>) response.getPayload();
                listView.getItems().clear();
                menu.forEach(item -> listView.getItems().add(item.getName()));
                statusLabel.setText("Menu loaded successfully");
            }
            else
            {
                statusLabel.setText("Error: " + response.getMessage());
            }
        } catch (Exception e) {
            statusLabel.setText("Exception: " + e.getMessage());
        }
    }

    @FXML
    private void handlePlaceOrder()
    {
        statusLabel.setText("Place Order functionality not yet implemented.");
    }

    @FXML
    private void handleManageTables()
    {
        statusLabel.setText("Manage Tables functionality not yet implemented.");
    }
}
