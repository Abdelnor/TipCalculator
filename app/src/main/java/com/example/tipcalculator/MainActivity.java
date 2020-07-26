package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textoporcentagem;
    private TextView textgorjeta;
    private TextView total;
    private SeekBar seekGorjeta;

    private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.txtValor);
        textoporcentagem = findViewById(R.id.txtPorcentagem);
        textgorjeta = findViewById(R.id.txtGorjeta);
        total = findViewById(R.id.txtTotal);
        seekGorjeta = findViewById(R.id.seekBarGorjeta);

        //Add Listener

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                textoporcentagem.setText(Math.round(porcentagem )+" %");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valorRec = editValor.getText().toString();
        if(valorRec == null || valorRec.equals("")){
            Toast.makeText(getApplicationContext(), R.string.semValor, Toast.LENGTH_LONG).show();
        }else{
            //Converter String para Double
            double valorDigitado = Double.parseDouble(valorRec);
            //Calcular a gorjeta
            double gorjeta = valorDigitado * (porcentagem/100);
            double totall = gorjeta + valorDigitado;
            //Exibir a gorjeta
            textgorjeta.setText("R$ "+String.format("%.2f",gorjeta));
            total.setText("R$ "+String.format("%.2f",totall));
        }
    }

}