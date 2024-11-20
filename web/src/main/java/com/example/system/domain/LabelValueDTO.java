package com.example.system.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class LabelValueDTO implements Serializable {
    private String label;
    private String value;
    private String costType;
}
