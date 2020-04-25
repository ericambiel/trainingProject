package br.com.ericambiel.mensagens;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = "Menssagens";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
    }

    private void bindView() {
        findViewById(R.id.btnToast).setOnClickListener(this);
        findViewById(R.id.btnAlert).setOnClickListener(this);
        findViewById(R.id.btnSnackbar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnToast:
                showToast();
                Log.i(TAG,"Show Toast");
                break;
            case R.id.btnAlert:
                showAlert();
                Log.i(TAG,"Show Alert");
                break;
            case R.id.btnSnackbar:
                showSnackbar(v);
                Log.i(TAG,"Show Snackbar");
                break;
            default:
                Log.i(TAG, "Ops... algo deu errado!");
        }
    }

    private void showToast() {
        Toast.makeText(this, R.string.text_toast, Toast.LENGTH_LONG).show();
    }

    // Rapida com textos curtos, mais utilizado
    private void showAlert() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_alert)
                .setMessage(R.string.message_alert)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.text_positivo), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "Clique do botão positivo");
                    }
                })
                .setNegativeButton(getString(R.string.text_negativo), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "Clique do botão negativo");
                    }
                })
                .setNeutralButton(getString(R.string.text_neutro), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "Clique do botão neutro");
                    }
                })
                .create() // Para versões mais antigas pode ser necessário um ou outro
                .show(); // Para versões mais antigas pode ser necessário um ou outro
    }

    private void showSnackbar(View view) {
        Snackbar.make(view, getString(R.string.text_snackbar), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.text_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i(TAG, "Clique do Snackbar");
                    }
                })
                .show();
    }
}
