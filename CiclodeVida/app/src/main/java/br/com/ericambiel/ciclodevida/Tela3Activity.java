package br.com.ericambiel.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Tela3Activity extends AppCompatActivity {
    private final String TAG = "--- Tela 3 ---";

    //Vai acessar do XML para o método.
    public void clickTela3(View view) {
        if(view.getId() == R.id.btnTela3){
            // Abrir tela 2 de forma estática.
            startActivity(new Intent(Tela3Activity.this, MainActivity.class));
            // Removendo todas as telas anteriores do empilhamento.
            finishAffinity();
        } else {
            onBackPressed();
//            finishAndRemoveTask(); Em versões anteriores fechava a aplicação
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
