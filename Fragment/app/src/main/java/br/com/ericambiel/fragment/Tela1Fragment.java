package br.com.ericambiel.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tela1Fragment extends Fragment {

    public Tela1Fragment() { } // Required empty public constructor

    private View view;
    private EditText edtTexto;
    private Button btnTela1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Objeto com tela inflada, podemos modificar antes de retornar.
        view = inflater.inflate(R.layout.fragment_tela1, container, false);

        bindView(view);
        clickTela1();

        return view;
    }

    /**
     * Função para vincular ou instanciar objetos
     * @param view View do fragment
     */
    private void bindView(View view) {
        // Vincula/Instancia
        edtTexto = view.findViewById(R.id.edtTexto);
        btnTela1 = view.findViewById(R.id.btnTela1);
    }

    /**
     * Captura texto do fragmento tela 1 e valida se esta preenchido
     */
    private void capture(){
        String texto = edtTexto.getEditableText().toString().trim();
        if(texto.isEmpty()){
            edtTexto.setError("Campo obrigatório");
            // edtTexto.requestFocus(); // Dar foco no componente, não necessário só possui um edt.
        } else {
            // Criando objeto Bundle
            Bundle bundle = new Bundle();
            bundle.putString("txvTexto",texto);

            // Criando objeto de transporte
            Fragment fragmenteTela2 = new Tela2Fragment();
            fragmenteTela2.setArguments(bundle); // Entrega bundle para fragment tela2

            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null; // Siga as linhas abaixo se não for nulo
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Inicia transporte
            transaction.replace(R.id.container, fragmenteTela2);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // Limpar caixa de texto
        edtTexto.getText().clear();
    }

    /**
     * Captura click do botão
     */
    private void clickTela1() {
        btnTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capture();
            }
        });
    }
}
