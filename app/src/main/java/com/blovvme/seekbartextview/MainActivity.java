package com.blovvme.seekbartextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv5;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    SeekBar seekBar,seekBar2,seekBar3;
    double amount;//car cost
    double rate;//interest rate of the loan
    double year;//year of the loan
    double emi;//total payment of the loan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        //Amount
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setText(String.valueOf(progress));
                amount = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Rate
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv2.setText(String.valueOf(progress));
                rate = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Years
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv3.setText(String.valueOf(progress));
                year = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
    //result onClick
    public void result(View view) {
        if (amount ==0 || rate == 0 || year == 0){
            tv5.setText("0");
        }else {
            rate = rate / (12 * 100);
            year = year * 12 ;
            emi = (amount * rate * Math.pow(1 + rate, year)) / (Math.pow(1 + rate, year) - 1);
            //converts to string it was a double
            tv5.setText(emi + "");
        }

    }

    //onCLickL Reset textView
    public void onReset(View view) {
            //clear the seekbar or scrollbar
            tv1.setText("");
            tv2.setText("");
            tv3.setText("");
            tv5.setText("");
            seekBar.setProgress(0);
            seekBar2.setProgress(0);
            seekBar3.setProgress(0);
        }

}
