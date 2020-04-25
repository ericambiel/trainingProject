package br.com.ericambiel.colecoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando uma lista de frutas
        ArrayList<String> listaFrutas = new ArrayList<>();
        listaFrutas.add("Selecione uma fruta");
        listaFrutas.add("Banana");
        listaFrutas.add("Jaca");
        listaFrutas.add("Melão");
        listaFrutas.add("Pera");
        listaFrutas.add("Maça");
        listaFrutas.add("Uva");
        listaFrutas.add("Abacaxi");

        // Criando um Adpater
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, // Contexto onde vai ser apresentado
                android.R.layout.simple_spinner_dropdown_item, // O Layout que vai ser apresentado
                listaFrutas // Oque vai apresentar
        );
        // Instanciar componentes
        Spinner spnFrutas = findViewById(R.id.spnFrutas);
        final TextView txvResultado = findViewById(R.id.txvResultado);

        // Add o adapter ao spn
        spnFrutas.setAdapter(adapter);

        //Criando o listener do item selecionado
        spnFrutas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                txvResultado.setText(item);
                txvResultado.setTextColor(getColor(R.color.colorPrimaryDark));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Clique do botão
        findViewById(R.id.btnTela1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir tela 2
                startActivity(new Intent(MainActivity.this, Tela2Activity.class));
            }
        });
    }
}
