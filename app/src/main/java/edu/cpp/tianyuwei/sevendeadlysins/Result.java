package edu.cpp.tianyuwei.sevendeadlysins;
import java.util.Arrays;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


import static edu.cpp.tianyuwei.sevendeadlysins.MainActivity.array;

public class Result extends AppCompatActivity {

  HorizontalBarChart mChart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mChart = (HorizontalBarChart)findViewById(R.id.chart1);
        setData(7,50);


    }
    private void setData(int count, int range){

        ArrayList<BarEntry>yVals = new ArrayList<>();
        float barWidth = 9f;
        float spaceForbar = 10f;
        for(int i=0; i<count;i++)
        {
            float val = (float)array[i];
            yVals.add(new BarEntry(i*spaceForbar,val));
        }
        BarDataSet set1;
        set1 = new BarDataSet(yVals, "Data set1");
        BarData data = new BarData(set1);
        data.setBarWidth(barWidth);
        mChart.setData(data);

    }


}
