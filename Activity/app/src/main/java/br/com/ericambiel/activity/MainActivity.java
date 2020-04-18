package br.com.ericambiel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Responsavel por apresentar o layout.
        setContentView(R.layout.activity_main);

        //Instanciar os componentes visuais.
        Button btnTela1 = findViewById(R.id.btnTela1);

        // Ouve o click do botão
        btnTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Para abrir uma nova activity, necessário acriar um Intent.
                Intent intentTela2 = new Intent(MainActivity.this, Tela2Activity.class);

                //Passando parametro via Intent
                intentTela2.putExtra("texto", "Deu certo! \nTela 2");

                // Executar a intent
                startActivity(intentTela2);
            }
        });
    }
}
