package edu.sdccd.cisc191.template;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Order implements Serializable
{
    private String orderId;
    private List<MenuItem> items;
    private String tableId;
    private String status;
}
