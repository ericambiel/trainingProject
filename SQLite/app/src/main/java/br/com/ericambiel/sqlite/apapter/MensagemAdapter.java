package br.com.ericambiel.sqlite.apapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.ericambiel.sqlite.R;
import br.com.ericambiel.sqlite.model.Mensagem;
import br.com.ericambiel.sqlite.util.DataBaseHelper;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Mensagem> mensagens;

    public MensagemAdapter(Context context, ArrayList<Mensagem> mensagens) {
        this.context = context; // Contexto onde o Layout vai ser inflado.
        this.mensagens = mensagens;
    }

    /**
     * Instanciar a VIEW/Layout que queremos usar
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context).inflate(R.layout.row_recycle, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Responsável por add ao layout o que vier do Array Mensagens
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTitle.setText(mensagens.get(position).getTitulo());
        holder.mMessage.setText(mensagens.get(position).getMensagem());
        holder.mCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DataBaseHelper dbHelper = new DataBaseHelper(context);
                dbHelper.delete(mensagens.get(position).getId());
                notifyItemRemoved(position);
                mensagens.remove(position);
                return false;
            }
        });
    }

    /**
     * Descobre quantidades de itens que iram ter no RV
     * @return quantidade de itens em uma RV
     */
    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    /**
     * Classe responsavel por vincular componentes a cada item do Adpter
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle, mMessage;
        CardView mCard;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.txvTitulo);
            mMessage = itemView.findViewById(R.id.txvMensagem);
            mCard =  itemView.findViewById(R.id.cdvResultado);
        }
    }
}
