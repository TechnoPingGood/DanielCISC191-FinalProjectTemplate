package edu.sdccd.cisc191.template;

import java.io.Serializable;
import lombok.Data;

@Data
public class Response implements Serializable {
    private String status;
    private Object payload;
    private String message;
}
