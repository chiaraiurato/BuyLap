package com.example.buylap;

public class ConstantNameTable {
    private ConstantNameTable(){
        throw new IllegalStateException("Utility class");
    }
    public static final String CPU = "cpu";
    public static final String RAM = "ram";
    public static final String MOTHERBOARD = "motherboard";
    public static final String SSD = "ssd";
    public static final String POWER_SUPPLY = "powersupply";
    public static final String VIDEO_CARD = "videocard";
}
