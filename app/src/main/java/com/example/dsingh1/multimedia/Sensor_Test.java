package com.example.dsingh1.multimedia;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Sensor_Test extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor mSensor;
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("inside onCreate",">>");
        setContentView(R.layout.activity_sensor__test);
        textView1=(TextView)findViewById(R.id.x_cord);
        textView2=(TextView)findViewById(R.id.y_cord);
        textView3=(TextView)findViewById(R.id.z_cord);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        Log.d("inside onCreate11",">>");
       mSensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Log.d("inside onCreate22",">>");

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            Log.d("Sensor.TYPE_"," "+event.sensor.getType());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("x_cord",""+String.valueOf("X cord: "+event.values[0]));
            textView1.setText(String.valueOf("X cord: "+event.values[0]));
            textView2.setText(String.valueOf("Y cord: "+event.values[1]));
            textView3.setText(String.valueOf("Z cord: "+event.values[2]));


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume(){

        super.onResume();
        sensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause(){
        sensorManager.unregisterListener(this);
        super.onPause();

    }
}
