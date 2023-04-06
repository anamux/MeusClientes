package app.modelo.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.datasource.AppDataBase;
import app.modelo.meusclientes.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObj;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObj = new ContentValues();
        ///Key, valor

        ////salva o dado/objeto na coluna Cliente no DataBase
        //ClienteDataModel ligação obj relacional

        dadoDoObj.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObj.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObj.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObj.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObj.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObj.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObj.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObj.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObj.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObj.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());

        //Enviar os dados (dadoDoObj) para a classe AppDatabase
        //utilizando um metodo que add o obj no BD, qualquer tabela

        return insert(ClienteDataModel.TABELA, dadoDoObj);
    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObj = new ContentValues();
        ///Key, valor


        ///Id é chave primária, salva automaticamente quando há novo registro
        //Sql -> UPDATE
        dadoDoObj.put(ClienteDataModel.ID, obj.getId());
        ////salva o dado/objeto na coluna Cliente no DataBase
        //ClienteDataModel ligação obj relacional
        dadoDoObj.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObj.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObj.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObj.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObj.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObj.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObj.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObj.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObj.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObj.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());

        //Enviar os dados (dadoDoObj) para a classe AppDatabase
        //utilizando um metodo que alterar o obj no BD, qualquer tabela
        //respeitando o ID ou PK (Primary key)
        return update(ClienteDataModel.TABELA, dadoDoObj);
    }

    @Override
    public boolean deletar(int id) {


        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);



       /* List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());


        //quantos elementos existem na lista? método "size"
        int totalClientes = lista.size();
        return lista;*/

    }

    public List <String> gerarListaDeClientesListView(){

        List<String> clientes = new ArrayList<>();
        for (Cliente obj: listar()) {

            clientes.add(obj.getId()+", "+obj.getNome()+ ", "+obj.getTelefone());

        }
        return clientes;
    }
}
