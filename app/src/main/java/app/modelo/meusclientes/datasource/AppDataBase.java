package app.modelo.meusclientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.model.Cliente;


///criando banco de dados
public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "MeusClientes.sqlite";
    private static final int DB_version = 1;

    SQLiteDatabase db; //objeto que acessa o BD

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_version);
        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");

        db = getWritableDatabase();
    }

    //cria o banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());
        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente criada..." + ClienteDataModel.criarTabela());

    }

    ///"controle de versão" faz as alteraçõs da versao
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }


//    /**
//     * método para incluir dados no banco de dados
//     *
//     * @return
//     */
    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        //regra de negocio

        try {
            ///o que deve ser realizado?
            //Salvar os dados

            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "Insert " + e.getMessage());

        }
        return retorno; ///TRUE OR FALSE
    }

//    /**
//     * método para deletar dados no banco de dados
//     *
//     * @return
//     */
    public boolean deleteById(String tabela, int id) {

        db = getWritableDatabase();

        boolean retorno = false;

        //regra de negocio

        try {
            ///o que deve ser realizado?
            //deletar os dados

            ///retorno = db.insert(tabela, null, dados) > 0;
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "Delete " + e.getMessage());

        }
        return retorno; ///TRUE OR FALSE
    }

    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        //regra de negocio

        try {
            ///o que deve ser realizado?
            //Alterar os dados

            retorno = db.update(tabela, dados, "=id?", new String[]{String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "Insert " + e.getMessage());

        }
        return retorno; ///TRUE OR FALSE
    }

    public List<Cliente> getAllClientes(String tabela) {

        db = getWritableDatabase();
        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){

            do{

                obj = new Cliente();
///pega o retorno do cursor para popular o DB
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                obj.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.TELEFONE)));
                clientes.add(obj);

                Log.i("Listar", "getAllClientes: "+obj.getNome());
            }while (cursor.moveToNext());

        }

    return clientes;
    }
}
