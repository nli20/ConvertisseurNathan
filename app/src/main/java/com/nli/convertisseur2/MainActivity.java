package com.nli.convertisseur2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText editTextNumber;
    TextView textView2;
    private Button buttonID;
    private AlertDialog.Builder alertDialog;

    public void convert(View view){
        Double kilometres;
        Double metres;

        editTextNumber=findViewById(R.id.editTextNumber);
        textView2=findViewById(R.id.textView2);
        kilometres=Double.parseDouble(editTextNumber.getText().toString());
        metres=kilometres*1000;
        textView2.setText(String.valueOf(metres));

        InputMethodManager mgr=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonID=findViewById(R.id.buttonID);
        buttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog=new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Mon message");
                alertDialog.setMessage("Voulez vous quitter l'application ?");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog=alertDialog.create();
                dialog.show();
            }
        });

    }
}