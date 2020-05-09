package br.com.ericambiel.sqlite.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import br.com.ericambiel.sqlite.R;
import br.com.ericambiel.sqlite.apapter.MensagemAdapter;
import br.com.ericambiel.sqlite.model.Mensagem;
import br.com.ericambiel.sqlite.util.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    private EditText edtTitulo, edtMensagem;
    private Button btnGravar;
    private RecyclerView rcvResultado;

    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        clickBtn();
        setRecycler();
    }

    private void bindView() {
        edtTitulo = findViewById(R.id.editTitulo);
        edtMensagem = findViewById(R.id.edtMensagem);
        btnGravar = findViewById(R.id.btnGravar);
        rcvResultado = findViewById(R.id.rcvResultado);

        dbHelper = new DataBaseHelper(MainActivity.this);
    }

    private void clickBtn() {
        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capture();
            }
        });
    }

    private void capture() {
        String titulo = edtTitulo.getEditableText().toString().trim().toUpperCase();
        String mensagem = edtMensagem.getEditableText().toString().trim();

        if (titulo.isEmpty()){
          edtTitulo.setError("Campo obrigatório");
          edtMensagem.requestFocus();
        } else if (mensagem.isEmpty()){
            edtMensagem.setError("Campo obrigatório");
            edtMensagem.requestFocus();
        } else {
            dbHelper.create(new Mensagem(titulo, mensagem));
            edtMensagem.getText().clear();
            edtTitulo.getText().clear();

            setRecycler();
        }
    }


    private void setRecycler() {
        RecyclerView.LayoutManager
                layoutManager = new LinearLayoutManager(
                        MainActivity.this, RecyclerView.VERTICAL, false);

        // Retorna uma lista
        ArrayList<Mensagem> mensagens = dbHelper.readAll();
        // Setar um layout
        rcvResultado.setLayoutManager(layoutManager);
        // Seta Adapter
        rcvResultado.setAdapter(new MensagemAdapter(this, mensagens));
    }
}
