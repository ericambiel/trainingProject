package br.com.ericambiel.colecoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //Lista
        ArrayList<String> list = new ArrayList<>();

        //Popular a lista
        for(int i = 1; i <= 100; i++) {
            list.add("Item: " + i);
        }

        // Criando o adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        // Instancia
        ListView lsvResultado = findViewById(R.id.lsvResultado);

        // Add o adapter ao listView
        lsvResultado.setAdapter(adapter);

        //Add o clique curto
        lsvResultado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(Tela2Activity.this, "Clicou no " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
