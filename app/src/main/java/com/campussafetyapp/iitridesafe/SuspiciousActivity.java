package com.campussafetyapp.iitridesafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class SuspiciousActivity extends AppCompatActivity {

    EditText infot;
    EditText titlet;
    Button submit;

    Reports report;
    String info;
    String title;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspicious);

        titlet = (EditText) findViewById(R.id.changeTitle);
        infot = (EditText) findViewById(R.id.editInfo);
        submit = (Button) findViewById(R.id.submitButton);

        infot.setMovementMethod(new ScrollingMovementMethod());
    }

    public void submitClicked(View view){
        date = new Date().toString();
        info = infot.getText().toString();
        title = titlet.getText().toString();
        report = new Reports(title, info, date);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if((infot.getText().toString() != "") && (titlet.getText().toString() != "")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    info = infot.getText().toString();
                    title = titlet.getText().toString();
                    date = new Date().toString();
                    report = new Reports(title, info, date);
                    SuspiciousActivity.super.onBackPressed();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SuspiciousActivity.super.onBackPressed();
                }
            });
            builder.setTitle("Unsaved Changes");
            builder.setMessage("Do you want to submit your report before exiting?");
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            super.onBackPressed();
        }
    }
}