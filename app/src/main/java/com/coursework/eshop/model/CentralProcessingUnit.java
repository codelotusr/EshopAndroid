package com.coursework.eshop.model;


public class CentralProcessingUnit extends Product {
    private String socket;
    private int coreCount;
    private int coreFrequency;
    private int tdp;

    public CentralProcessingUnit(String title, String description, String socket, int coreCount, int coreFrequency, int tdp) {
        super(title, description);
        this.socket = socket;
        this.coreCount = coreCount;
        this.coreFrequency = coreFrequency;
        this.tdp = tdp;
    }



}
