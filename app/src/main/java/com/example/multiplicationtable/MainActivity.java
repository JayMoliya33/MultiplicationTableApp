package com.example.multiplicationtable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backpressedtime;
    private Toast backToast;

    SeekBar seekBar;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
        {
            // for custom actionbar
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.customactionbar));
            actionBar.setTitle("Multiplication Table");
        }

        tv1 = (TextView)findViewById(R.id.showtext);
        tv2 = (TextView)findViewById(R.id.numbers);
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                int ans = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                String num = String.valueOf(progress+1);
                tv1.setText(num);
                StringBuffer buffer = new StringBuffer();
                int n = progress+1;
                for(int i=1;i<=10;i++)
                {
                     ans = (n*i);
                     buffer.append("\n"+ n+" * "+i+" = "+ans+"\n");
                }
                 tv2.setText(buffer);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
		// This method will Automatically 
		// Called when user touches seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
		// This method will Automatically 
		// Called when user stops touching seekbar
            }
        });
    }

    // Backpressedbutton Code
    @Override
    public void onBackPressed() {
        if(backpressedtime+2000>System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else
        {
            backToast = Toast.makeText(getApplicationContext(),"Press again back to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backpressedtime = System.currentTimeMillis();
    }
}
