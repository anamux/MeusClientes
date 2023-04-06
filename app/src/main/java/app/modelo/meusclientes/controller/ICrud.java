package app.modelo.meusclientes.controller;

import java.util.List;

public interface ICrud<T> {

    //métodos de persistencia de dados no BD:
    //Incluir,
    public boolean incluir(T obj);

    // alterar,
    public boolean alterar(T obj);

    // deletar,
    public boolean deletar(int id);

    // listar
    public List<T> listar();

}
