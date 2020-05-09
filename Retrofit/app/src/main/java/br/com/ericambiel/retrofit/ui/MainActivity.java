package br.com.ericambiel.retrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.ericambiel.retrofit.R;
import br.com.ericambiel.retrofit.model.ui.CEPResponse;
import br.com.ericambiel.retrofit.rest.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText edtCep;
    CardView cdvResultado;
    TextView txvLogradouto, txvBairro, txvLocalidade, txvUf, txvCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCep =           findViewById(R.id.edtCep       );
        cdvResultado =     findViewById(R.id.cvdResultado );
        txvLogradouto =    findViewById(R.id.txvLogradouro);
        txvBairro =        findViewById(R.id.txvBairro    );
        txvLocalidade =    findViewById(R.id.txvLocalidade);
        txvUf =            findViewById(R.id.txvUf        );
        txvCep =           findViewById(R.id.txvCep       );

        edtCep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 8) {
                    initRetrofit(s.toString());
                }
            }
        });
    }

    private void initRetrofit(String cep) {
        RetrofitConfig.cepService.getCEP(cep).enqueue(new Callback<CEPResponse>() {
            @Override
            public void onResponse(Call<CEPResponse> call, Response<CEPResponse> response) {
                Log.i("==RESPOSTA RETROFIT", response.body().getLocalidade());
                txvCep.setText(response.body().getCep());
                txvLogradouto.setText(response.body().getLogradouro());
                txvBairro.setText(response.body().getBairro());
                txvLocalidade.setText(response.body().getLocalidade());
                txvUf.setText(response.body().getUf());
                cdvResultado.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<CEPResponse> call, Throwable t) {
                Log.i("==ERRO RETROFIT", t.getMessage());
            }
        });
    }
}
