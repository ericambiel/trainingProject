package br.com.ericambiel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tela3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        // Recuperar valor do Bundle
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");


        // Instanciar o componente TextView da tela 3
        TextView txvTela3 = findViewById(R.id.txvTela3);

        //Add o texto
        txvTela3.setText(nome);
    }
}
