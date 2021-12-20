package com.machine.mvcdesignpatternbuttonclicks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.machine.mvcdesignpatternbuttonclicks.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {
    Button bt1, bt2, bt3;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);

        model = new Model();
        model.addObserver(this);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:{
                model.setValueAtIndex(0);
                break;
            }
            case R.id.bt2:{
                model.setValueAtIndex(1);
                break;
            }
            case R.id.bt3:{
                model.setValueAtIndex(3);
                break;
            }
        }
    }

    //function to update the view after
    // the values are modified by model
    @Override
    public void update(Observable observable, Object o) {

        //changing text of the button
        //according to updated values
        bt1.setText("Count: "+model.getValueAtIndex(0));
        bt2.setText("Count: "+model.getValueAtIndex(1));
        bt3.setText("Count: "+model.getValueAtIndex(2));
    }
}