package com.skypan.android_13_imageview_picture_array;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num;
    private ImageView img;
    int[] image = {R.drawable.one,R.drawable.two,
            R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,
            R.drawable.seven,R.drawable.eight,
            R.drawable.nine,R.drawable.ten};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (EditText)findViewById(R.id.num);
        img = (ImageView)findViewById(R.id.img);
        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    for(int i=0;i<image.length;i++){
                        if((Integer.parseInt(num.getEditableText().toString()))==(i+1)){
                            img.setVisibility(View.VISIBLE);
                            img.setImageResource(image[i]);
                        }
                    }
                    if((Integer.parseInt(num.getEditableText().toString()))==0 || (Integer.parseInt(num.getEditableText().toString()))>10){
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                catch (Exception e){
                    img.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}