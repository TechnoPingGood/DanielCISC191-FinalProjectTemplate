package edu.sdccd.cisc191.template;

import java.io.Serializable;
import lombok.Data;

@Data
public class Table implements Serializable
{
    private String tableId;
    private int number;
    private int capacity;
    private boolean occupied;
}
