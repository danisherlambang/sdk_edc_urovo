package com.sample.urovo.test;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sample.urovo.function.ufunction;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void goBeep(View v) {

        try {
            ufunction uf = new ufunction();
            String sDate = uf.GetDate();
            Log.d("TEST", "Date=" + sDate);
            int nDelay = 200;   //millisecond
            uf.setBeep(activity, context, nDelay);
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void goLED(View v){

        try {
            ufunction uf = new ufunction();
            int nColor = 1;     //blue
            uf.setOnLED(activity, context, nColor);
            sleep(1000);
            uf.setOffLED(activity, context, nColor);

            nColor = 2;     //yellow
            uf.setOnLED(activity, context, nColor);
            sleep(1000);
            uf.setOffLED(activity, context, nColor);

            nColor = 3;     //green
            uf.setOnLED(activity, context, nColor);
            sleep(1000);
            uf.setOffLED(activity, context, nColor);

            nColor = 4;     //red
            uf.setOnLED(activity, context, nColor);
            sleep(1000);
            uf.setOffLED(activity, context, nColor);


        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    public void goPrintText(View v){

        try {
            ufunction uf = new ufunction();
            String sDate = uf.GetDate();
            Log.d("TEST", "Date=" + sDate);
            String sPrint = "Test Print 1234567890";
            int nFont = 1;
            int nAlign = 0;
            int nBold = 0;
            uf.setPrintText(activity, context, sPrint, nFont, nAlign, nBold);
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    public void goPrintQR(View v){

        try {
            ufunction uf = new ufunction();
            String sQR = "TestQR1234567890";
            int nAlign = 1;
            int nOffset = 0;
            int nHeight = 300;
            uf.setPrintQR(activity, context, sQR, nAlign, nOffset, nHeight);
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    private Bitmap getLogoBitmap(Context context, int id) {
        BitmapDrawable draw = (BitmapDrawable) context.getResources().getDrawable(id);
        Bitmap bitmap = draw.getBitmap();
        return bitmap;
    }

    public void goPrintImage(View v){
        try {
            Bitmap bImage = getLogoBitmap(this, R.drawable.logo_gamatepat);
            ufunction uf = new ufunction();
            int nAlign = 1;
            int nOffset = 0;
            int nHeight = 300;
            uf.setPrintImage(activity, context, bImage, nAlign, nOffset, nHeight);
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    public void goLineFeed(View v){
        try {
            ufunction uf = new ufunction();
            uf.setLineFeed(context);
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }


}