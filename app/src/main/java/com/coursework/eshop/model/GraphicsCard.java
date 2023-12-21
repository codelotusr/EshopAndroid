package com.coursework.eshop.model;


public class GraphicsCard extends Product {
    private String memoryType;
    private int memorySize;
    private int memoryFrequency;
    private int coreFrequency;
    private int tdp;


    public GraphicsCard(String title, String description, String memoryType, int memorySize, int memoryFrequency, int coreFrequency, int tdp) {
        super(title, description);
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.memoryFrequency = memoryFrequency;
        this.coreFrequency = coreFrequency;
        this.tdp = tdp;
    }


}
