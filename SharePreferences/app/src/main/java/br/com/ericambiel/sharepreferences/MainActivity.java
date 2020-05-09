package br.com.ericambiel.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Gravar SharedPreference
     * @param view
     */
    public void gravar(View view){
        EditText edtMensagem = findViewById(R.id.edtMensagem);
        String mensagem = edtMensagem.getEditableText().toString().trim();
        if(mensagem.isEmpty()){
            edtMensagem.setError("Campo obrigatório");
            edtMensagem.requestFocus();
        } else {
            SharedPreferences preferences = getSharedPreferences("mensagem", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("mensagem", mensagem);
            editor.apply();

            edtMensagem.getText().clear();
        }
    }

    /**
     * Recuperar SharedPreference
     * @param view
     */
    public void recuperar(View view){
        TextView txvResultado = findViewById(R.id.txvResultado);

        SharedPreferences preferences = getSharedPreferences("mensagem", MODE_PRIVATE);
        String mensagem = preferences.getString("mensagem", "Erro Shared");

        txvResultado.setText(mensagem);
    }
}
