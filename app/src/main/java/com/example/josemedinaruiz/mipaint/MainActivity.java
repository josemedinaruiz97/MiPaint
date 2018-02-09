package com.example.josemedinaruiz.mipaint;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;

public class MainActivity extends AppCompatActivity implements ColorPickerDialogListener {
    private VistaPintada vistaPintada;
    private String array[] = {"Linea", "Cuadrado", "Elipse", "Circulo", "Poligonal"};
    private String array1[] = {"10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30"};

    private void init() {
        vistaPintada = findViewById(R.id.vistaPintada);
        vistaPintada.setColor(Color.RED);
        Button btnFigura = findViewById(R.id.btnFigura);
        btnFigura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoFigura();
            }
        });
        Button btnColor = findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoColor();
            }
        });
        Button btnFondo = findViewById(R.id.btnFondo);
        btnFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoFondo();
            }
        });
        Button btnGrosor = findViewById(R.id.btnGrosor);
        btnGrosor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoTamaño();
            }
        });
    }

    private void mostrarDialogoFigura() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Seleccciona una forma")
                .setItems(array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        vistaPintada.setDibujo(array[which]);
                    }
                });
        builder.show();
    }

    private void mostrarDialogoTamaño() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Seleccciona un tamaño")
                .setItems(array1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        vistaPintada.setTamaño(Integer.parseInt(array1[which]));
                    }
                });
        builder.show();
    }

    private void mostrarDialogoColor() {
        ColorPickerDialog.newBuilder().setDialogId(1).setColor(Color.GRAY).show(this);
    }

    private void mostrarDialogoFondo() {
        ColorPickerDialog.newBuilder().setDialogId(2).setColor(Color.GRAY).show(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    @Override
    public void onColorSelected(int dialogId, int color) {
        Log.v("xyxyxy", color + "");
        if (dialogId == 1) {
            vistaPintada.setColor(color);
        } else {
            vistaPintada.setFondo(color);
        }

    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
