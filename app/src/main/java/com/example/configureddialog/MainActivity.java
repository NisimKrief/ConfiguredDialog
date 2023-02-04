package com.example.configureddialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * Main activity1.

 *  @author	Nisim Doron Krief <nisimandroi@gmail.com>
 *  @version	1.0
 *  @since	04/02/2023 (the date of the package the class was added)
 *  @info Program that uses Alert Dialog, buttons and options menu to show stuff like
 *  Title, positive/neutral/negative buttons, RGB Color, Clearing Screen, MultipleChoice options, RadioButtons, EditText using AlertDialog. */
public class MainActivity extends AppCompatActivity {
    /**
     * The Adb.
     */
    AlertDialog.Builder adb;
    /**
     * The Adb 2.
     */
    AlertDialog.Builder adb2;
    /**
     * The Adb 3.
     */
    AlertDialog.Builder adb3;
    /**
     * The Ll.
     */
    LinearLayout LL;
    /**
     * The Rand.
     */
    Random rand = new Random();
    /**
     * The Color.
     */
    int[] color = {0, 0, 0};
    /**
     * The Colors.
     */
    final String[] colors = {"Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Change Color");
        adb.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                color[which] = 0;
            }
        });

        adb2 = new AlertDialog.Builder(this);
        adb2.setCancelable(false);
        adb2.setTitle("Change Multiple Color");
        adb2.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        adb2.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                if(isChecked) color[which] = 255;
                else if(color[which] == 255) color[which] = 0;
            }
        });
        adb2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });


        adb3 = new AlertDialog.Builder(this);

        LL = (LinearLayout) findViewById(R.id.LL);


    }

    /**
     * Alert dialog 1.
     *
     * Shows adb by clicking on the first button.
     */
    public void AlertDialog1(View view) {
        color[0] = 0; color[1] = 0; color[2] = 0;
        adb.show();
    }

    /**
     * Alert dialog 2.
     *
     * shows adb2 by clicking on the second button
     */
    public void AlertDialog2(View view) {
        color[0] = 0; color[1] = 0; color[2] = 0;
        adb2.show();

    }

    /**
     * Reset color.
     *
     * Reset the background color to White by clicking on the third button
     */
    public void ResetColor(View view) {
        LL.setBackgroundColor(Color.WHITE);
    }

    /**
     * Alert dialog 3.
     *
     * shows adb3 by clicking on the fourth button
     */
    public void AlertDialog3(View view) {
        adb3.setCancelable(false);
        adb3.setTitle("AlertDialog3");
        final EditText eT = new EditText(this);
        eT.setHint("Enter Text");
        adb3.setView(eT);
        adb3.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String str = eT.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb3.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
                eT.setText("");
            }
        });
        adb3.show();

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getTitle().toString().equals("Credits")){
            Intent Si = new Intent(this,MainActivity2.class);
            startActivity(Si);

        }



        return true;
    }
}

