package com.example.homework01_assignment01;

public class ColorInfo
{
    //values of saved colors
    private int red;
    private int green;
    private int blue;

    //constructor
    public ColorInfo(int red, int green, int blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    //gets red value
    public int getRed()
    {

        return red;
    }

    //gets green value
    public int getGreen()
    {
        return green;
    }

    //gets blue value
    public int getBlue()
    {
        return blue;
    }

    // Get the hexadecimal color
    public String getHexColor()
    {
        return String.format("%02X%02X%02X", red, green, blue);
    }
}