package br.com.ericambiel.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tela2Fragment extends Fragment {

    public Tela2Fragment() { } // Required empty public constructor

    private TextView txvTexto;
    private Button btnVoltar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tela2, container, false);

        bindView(view);
        getBundle();
        clickVoltar();

        return view;
    }

    private void bindView(View view) {
        txvTexto = view.findViewById(R.id.txvTexto);
        btnVoltar = view.findViewById(R.id.btnVoltar);
    }

    private void getBundle() {
        Bundle bundle = getArguments();
        assert bundle != null;
        txvTexto.setText(bundle.getString("txvTexto"));
    }

    private void clickVoltar() {
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });
    }
}
