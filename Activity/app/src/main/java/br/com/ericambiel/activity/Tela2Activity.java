package br.com.ericambiel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        // Objetos da tela
        TextView txvTela2 = findViewById(R.id.txvTela2);
        Button   btnTela2 = findViewById(R.id.btnTela2);
        final EditText edtTela2 = findViewById(R.id.edtTela2);

        // Recuperar dados da outra Activity.
        String texto = getIntent().getStringExtra("texto");

        // Seta um texto em um TextView
        txvTela2.setText(texto);

        btnTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recuperar um valor de dentro do edtText
                String nome = edtTela2.getEditableText().toString().trim();

                // Criar e inicializar Intent
                Intent intentTela3 = new Intent(Tela2Activity.this, Tela3Activity.class);

                // Criar e inicializar Bundle
                Bundle bundle = new Bundle();

                // Add objetos ao bundle.
                bundle.putString("nome", "Seja bem vindo(a):\n" + nome);

                // Add bundle ao intent.
                intentTela3.putExtras(bundle);

                // Executar a intent(Abrir tela 3).
                startActivity(intentTela3);
            }
        });
    }
}
