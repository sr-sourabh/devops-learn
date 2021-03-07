package com.iiitb.devopscalc.core;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class RequestDto implements Serializable {
    private int number;
    private int base;
    private int operation;
}
