//===============================================================================
//        Name          : Spencer Fritz
//      Date Due        : 30 October 2026
//Homework 01 Program 01: RGB Color Slider
//===============================================================================

package com.example.homework01_assignment01;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.Button;
import java.util.ArrayList;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{
    //variables
    SeekBar redSeekBar;
    SeekBar greenSeekBar;
    SeekBar blueSeekBar;
    TextView redText;
    TextView greenText;
    TextView blueText;
    TextView hexText;
    LinearLayout mainLayout;
    Button saveButton;
    ArrayList<ColorInfo> colorList;
    ListView colorListView;
    ColorAdapter colorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle("HW01_RGB");
        }

        //connect variables to xml
        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);
        redText = findViewById(R.id.redText);
        greenText = findViewById(R.id.greenText);
        blueText = findViewById(R.id.blueText);
        hexText = findViewById(R.id.hexText);
        mainLayout = findViewById(R.id.mainLayout);
        saveButton = findViewById(R.id.saveButton);
        colorListView = findViewById(R.id.colorListView);

        colorList = new ArrayList<>();
        colorAdapter = new ColorAdapter(this, colorList);
        colorListView.setAdapter(colorAdapter);


        //red slider
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                redText.setText("Red: " + progress);
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
            }
        });

        //green slider
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                greenText.setText("Green: " + progress);
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
            }
        });

        //blue slider
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                blueText.setText("Blue: " + progress);
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
            }
        });

        //save button listener
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                int red = redSeekBar.getProgress();
                int green = greenSeekBar.getProgress();
                int blue = blueSeekBar.getProgress();

                ColorInfo newColor = new ColorInfo(red, green, blue);

                colorList.add(newColor);
                colorAdapter.notifyDataSetChanged();
                //sets the sliders back to black
                redSeekBar.setProgress(0);
                greenSeekBar.setProgress(0);
                blueSeekBar.setProgress(0);
            }
        });

        colorListView.setOnItemClickListener((parent, view, position, id) ->
        {

            ColorInfo selectedColor = colorList.get(position);

            redSeekBar.setProgress(selectedColor.getRed());
            greenSeekBar.setProgress(selectedColor.getGreen());
            blueSeekBar.setProgress(selectedColor.getBlue());

        });
    }
    private void updateColor()
    {

        int red = redSeekBar.getProgress();
        int green = greenSeekBar.getProgress();
        int blue = blueSeekBar.getProgress();

        //change background
        int color = Color.rgb(red, green, blue);
        mainLayout.setBackgroundColor(color);

        //convert to hexadecimal value
        String hexColor = String.format("%02X%02X%02X", red, green, blue);

        hexText.setText("Hex Representation:   " + hexColor);

        //detects how dark the background is
        double brightness = (red * 0.299) + (green * 0.587) + (blue * 0.114);

        if (brightness > 150)
        {
            //background bright = dark text
            redText.setTextColor(Color.BLACK);
            greenText.setTextColor(Color.BLACK);
            blueText.setTextColor(Color.BLACK);
            hexText.setTextColor(Color.BLACK);

        }
        else
        {

            //background dark = bright text
            redText.setTextColor(Color.WHITE);
            greenText.setTextColor(Color.WHITE);
            blueText.setTextColor(Color.WHITE);
            hexText.setTextColor(Color.WHITE);
        }
    }

}