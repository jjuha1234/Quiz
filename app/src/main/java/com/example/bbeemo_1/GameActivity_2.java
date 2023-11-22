package com.example.bbeemo_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bbeemo_1.databinding.ActivityGame2Binding;
import com.example.bbeemo_1.databinding.ActivityMainBinding;

public class GameActivity_2 extends AppCompatActivity {
    private AlertDialog alertDialog;

    private String correct ="r";
    private String answer;





    private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog == alertDialog&& which ==DialogInterface.BUTTON_POSITIVE)
            {
                showToast("종료");

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView CorrectImg;
        ImageView falseImg;

        super.onCreate(savedInstanceState);


        ActivityGame2Binding binding = ActivityGame2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=answer+".";

            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=answer+"-";

            }
        });

       binding.button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               answer=removeLastChar(answer);

           }
       });




       binding.button5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(correct.equals(answer))
               {


                   Toast toast=
                           Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                   ImageView correctimage=new ImageView(getApplicationContext());
                   correctimage.setImageResource(R.drawable.correcticon);
                   toast.setView(correctimage);
                   //위치 지정
                   toast.setGravity(Gravity.CENTER,50,50);
                   //여백 지정
                   toast.setMargin(1000, 1000);
                   toast.show();


               }
               else {

                   Toast toast=
                           Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                   ImageView incorrectimage=new ImageView(getApplicationContext());
                   incorrectimage.setImageResource(R.drawable.incorrecticon);
                   toast.setView(incorrectimage);
                   //위치 지정
                   toast.setGravity(Gravity.CENTER,50,50);
                   //여백 지정
                   toast.setMargin(1000, 1000);
                   toast.show();
               }
           }
       });





    }





    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
    public static String removeLastChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
}

