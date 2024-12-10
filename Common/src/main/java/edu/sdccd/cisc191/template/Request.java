package edu.sdccd.cisc191.template;

import java.io.Serializable;
import lombok.Data;

@Data
public class Request implements Serializable
{
    private String action;
    private Object payload;
}
