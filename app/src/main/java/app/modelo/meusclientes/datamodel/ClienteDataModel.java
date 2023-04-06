package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    ///Modelo Objeto Relacional - transforna um objeto em uma tabela
    //Toda Classe Data Model tem que ter a seguinte estrutura


    // 1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    // 2 - Atributos um para um com os nomes dos campos
    public static final String ID = "id"; ///no SQLite = integer
    public static final String NOME = "nome"; ///no SQLite = text
    public static final String TELEFONE = "telefone"; // no SQLite = text
    public static final String EMAIL = "email";// no SQLite = text
    public static final String CEP = "cep"; // no SQLite = integer
    public static final String LOGRADOURO = "logradouro";// no SQLite = text
    public static final String NUMERO = "numero";// no SQLite = text
    public static final String BAIRRO = "bairro";// no SQLite = text
    public static final String CIDADE = "cidade";// no SQLite = text
    public static final String ESTADO = "estado";// no SQLite = text
        public static final String TERMOS_DE_USO = "termos_de_uso";// no SQLite =integer

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // 4 - Método para gerar o Script para criar a tabela
    public static String criarTabela(){

        //Concatenação de String
        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, " ;
        queryCriarTabela += TELEFONE+" text, ";
        queryCriarTabela += EMAIL+" text, ";
        queryCriarTabela += CEP+" integer, ";
        queryCriarTabela += LOGRADOURO+" text, ";
        queryCriarTabela += NUMERO+" text, ";
        queryCriarTabela += BAIRRO+" text, ";
        queryCriarTabela += CIDADE+" text, ";
        queryCriarTabela += ESTADO+" text, ";
        queryCriarTabela += TERMOS_DE_USO+" integer ";
        queryCriarTabela += ")";
        //queryCriarTabela = "Parte 01, Parte02, Parte03, Parte 04


        return queryCriarTabela;
    }
    // 5 - Queries de consultas gerais

}
