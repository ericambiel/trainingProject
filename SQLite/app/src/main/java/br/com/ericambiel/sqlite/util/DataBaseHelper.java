package br.com.ericambiel.sqlite.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.com.ericambiel.sqlite.model.Mensagem;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME         = "db_mensagens";
    private static final int    DB_VERSION      = 1             ;
    private static final String TABLE           = "mensagem"    ;
    private static final String COLUMN_ID       = "id"          ;
    private static final String COLUMN_TITLE    = "titulo"      ;
    private static final String COLUMN_MESSAGE  = "mensagem"    ;

    public DataBaseHelper(
            @Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * Criara as tabelas no SQLite
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Não cria hashes caso concatene uma string
        StringBuffer sQL = new StringBuffer();
        sQL.append("CREATE TABLE " + TABLE + " (");
        sQL.append(COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,");
        sQL.append(COLUMN_TITLE + " TEXT,");
        sQL.append(COLUMN_MESSAGE + " TEXT);");

        db.execSQL(sQL.toString());
    }
    // Atualizar o DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void create(Mensagem mensagem) {
        StringBuffer sQL = new StringBuffer();
        sQL.append("INSERT INTO " + TABLE + " (" + COLUMN_TITLE + ", " + COLUMN_MESSAGE + ") ");
        sQL.append("VALUES " + "(");
        sQL.append("'" + mensagem.getTitulo() + "', '" + mensagem.getMensagem() + "');");

        getWritableDatabase().execSQL(sQL.toString());
    }

    /**
     * Faz consulta na tabela mensagem e trás somente um valor pelo id
     * @param id ID da mensagem
     * @return Mensagem com id indicado
     */
    public Mensagem read(int id) {
        String sQL = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_ID + " " + id;

        Cursor cursor = getReadableDatabase().rawQuery(sQL, null);

        Mensagem mensagem = new Mensagem();

        while (cursor.moveToNext()){
            mensagem.setId(cursor.getInt(0));
            mensagem.setTitulo(cursor.getString(1));
            mensagem.setMensagem(cursor.getString(2));
        }

        cursor.close();

        return mensagem;
    }

    /**
     * Faz consulta na tabela mensagem e trás todos os valores na tabela
     * @return Array com todas as mensagens da tabela mensagem
     */
    public ArrayList<Mensagem> readAll() {
        String sQL = "SELECT * FROM " + TABLE;

        Cursor cursor = getReadableDatabase().rawQuery(sQL, null);

        ArrayList<Mensagem> mensagens = new ArrayList<>();

        while (cursor.moveToNext()) {
            Mensagem mensagem = new Mensagem();
            mensagem.setId(cursor.getInt(0));
            mensagem.setTitulo(cursor.getString(1));
            mensagem.setMensagem(cursor.getString(2));

            mensagens.add(mensagem);
        }
        cursor.close();

        return mensagens;
    }

    public void update(Mensagem mensagem) {
        StringBuffer sQL = new StringBuffer();
        sQL.append("UPDATE " + TABLE + " SET ");
        sQL.append(COLUMN_TITLE + " = '" + mensagem.getTitulo() + "', ");
        sQL.append(COLUMN_MESSAGE + " = '" + mensagem.getMensagem() + "' ");
        sQL.append("WHERE " + COLUMN_ID + " = " + mensagem.getId() + ";" );

        getWritableDatabase().execSQL(sQL.toString());
    }

    public void delete(int id) {
        String sQL = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = " + id + ";";

        getWritableDatabase().execSQL(sQL);
    }
}
