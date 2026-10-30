package com.example.homework01_assignment01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ColorAdapter extends ArrayAdapter<ColorInfo>
{
    public ColorAdapter(Context context, ArrayList<ColorInfo> colors)
    {
        super(context, 0, colors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        ColorInfo colorInfo = getItem(position);

        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.color_cell, parent, false);
        }

        TextView cellHexText = convertView.findViewById(R.id.cellHexText);

        if (colorInfo != null)
        {

            //display hex value
            String savedColorText = "Red: " + colorInfo.getRed() + "   Green: " + colorInfo.getGreen() + "   Blue: " + colorInfo.getBlue() + "\nHex: " + colorInfo.getHexColor();

            cellHexText.setText(savedColorText);

            //get rgb values
            int red = colorInfo.getRed();
            int green = colorInfo.getGreen();
            int blue = colorInfo.getBlue();

            //set to saved color
            int color = Color.rgb(red, green, blue);
            cellHexText.setBackgroundColor(color);

            double brightness = (red * 0.299) + (green * 0.587) + (blue * 0.114);

            if (brightness > 150)
            {
                cellHexText.setTextColor(Color.BLACK);
            }
            else
            {
                cellHexText.setTextColor(Color.WHITE);
            }
        }

        return convertView;
    }
}