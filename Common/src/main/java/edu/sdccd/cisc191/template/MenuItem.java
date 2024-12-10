package edu.sdccd.cisc191.template;

import java.io.Serializable;
import lombok.Data;

@Data
public class MenuItem implements Serializable
{
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
}
