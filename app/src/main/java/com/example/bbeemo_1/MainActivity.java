package com.example.bbeemo_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bbeemo_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;


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
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("예",dialogListener);

        binding.backbutton.setOnClickListener(view ->
        {
            builder.setMessage("정말로 종료하시겠습니까?");
            builder.create();
            alertDialog = builder.create();
            alertDialog.show();

        });


        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity_2.class);
                startActivity(intent);
            }
        });




    }



    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
