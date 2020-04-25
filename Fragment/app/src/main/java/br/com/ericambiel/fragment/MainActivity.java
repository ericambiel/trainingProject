package br.com.ericambiel.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gerência os Fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Trás os métodos para add, remover e etc um Fragment.
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Onde o fragment vai ser exibido e qual fragment vai ser exibido.
        transaction.add(R.id.container, new Tela1Fragment());

        // Iniciar transação
        transaction.commit();
    }
}
