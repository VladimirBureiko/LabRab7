package com.example.vovab.labrab7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView really;
    TextView maximum;
    Button bn;
    float x = 0,y = 0,z= 0;
    float maxX = 0, maxY = 0, maxZ = 0;
    ImageView im;
    SensorManager sn;
    Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = (ImageView)findViewById(R.id.imageView);

        im.setImageResource(R.drawable.angry_bird);
        bn = (Button)findViewById(R.id.button);
        really = (TextView)findViewById(R.id.textView);
        maximum = (TextView)findViewById(R.id.textView2);
        sn = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s = sn.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maximum.setText("MAX X = " + 0 + " MAX Y = "+ 0 + " Z MAX = "+ 0);
            }
        });
    }
    public final void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
    @Override
    public final void onSensorChanged(SensorEvent event)
    {
        x = event.values[0];
        if(x>maxX)
        {
            maxX = x;
        }
        y = event.values[1];
        if(y>maxY)
        {
            maxY = y;
        }
        z = event.values[2];
        if(z>maxZ)
        {
            maxZ = z;
        }
        really.setText("X = " + x + " Y = "+ y+ " Z = "+ z);
        maximum.setText("MAX X = " + maxX + " MAX Y = "+ maxY+ " Z MAX = "+ maxZ);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        sn.registerListener(this, s,SensorManager.SENSOR_DELAY_NORMAL);
    }


}
