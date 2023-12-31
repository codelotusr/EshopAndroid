package com.coursework.eshop.model;


public class Motherboard extends Product {
    private String socket;
    private String chipset;
    private String memoryType;
    private int maxMemorySize;
    private int maxMemoryFrequency;

    public Motherboard(String title, String description, String socket, String chipset, String memoryType, int memorySize, int memoryFrequency) {
        super(title, description);
        this.socket = socket;
        this.chipset = chipset;
        this.memoryType = memoryType;
        this.maxMemorySize = memorySize;
        this.maxMemoryFrequency = memoryFrequency;
    }


}
