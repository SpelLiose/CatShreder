package com.spelloise.catshreder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView coordinatesOut;
    private float x;
    private float y;
    private String sDown;
    private String sMove;
    private String sUp;
    private String sOut;
    private final float XCat=900;
    private final float YCat=50;
    private final float DCat=50;
    View.OnTouchListener listener =new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            x=event.getX();
            y=event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    sDown="Нажатие."+"\n"+ "координата Х="+x+"\n"+"координата Y="+y;
                    sMove="";
                    sUp="";
                    sOut="";
                    if (x<(XCat+DCat)&&x>(XCat-DCat)&&y<(YCat+DCat)&&y>(YCat-DCat)) {
                        Toast toast= Toast.makeText(MainActivity.this, R.string.catFind, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.LEFT,(int) XCat-50,(int)YCat-500);
                        LinearLayout toastContainer=(LinearLayout) toast.getView();
                        ImageView catshreder =new ImageView(getApplicationContext());
                        catshreder.setImageResource(R.drawable.cat2);
                        toastContainer.addView(catshreder,1);
                        toast.show();

                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    sDown="";
                    sMove=""+"\n"+"Движение."+"\n"+"Координата Х="+x+"\n"+"Координата Y="+y;
                    if (x<(XCat+DCat)&&x>(XCat-DCat)&&y<(YCat+DCat)&&y>(YCat-DCat)) {
                        Toast toast= Toast.makeText(MainActivity.this, R.string.catFind, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.LEFT,(int) XCat-50,(int)YCat-600);
                        LinearLayout toastContainer=(LinearLayout) toast.getView();
                        ImageView catshreder =new ImageView(getApplicationContext());
                        catshreder.setImageResource(R.drawable.cat2);
                        toastContainer.addView(catshreder,1);
                        toast.show();

                    }
                    break;
                case MotionEvent.ACTION_UP:
                    sDown=""+"\n";
                    sMove=""+"\n";
                    sOut="";
                    sUp="\n"+"\n"+"Движение вверх."+"\n"+"Координата Х="+x+"\n"+"Координата Y="+y;

                    break;

            }
            coordinatesOut.setText(sDown+"\n"+sMove+"\n"+sUp+sOut);
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatesOut=findViewById(R.id.coordinatesOut);
        coordinatesOut.setOnTouchListener(listener);
    }
}