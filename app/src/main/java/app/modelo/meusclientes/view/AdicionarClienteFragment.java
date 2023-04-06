package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {
///DECLARAÇÃO GLOBAL DOS atributos (PUBLIC)
    ///Fragment - Classe responsável pela camada de visão (layout)
    View view;

    TextView txtTitulo;
    EditText editNomeCompleto;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;
    CheckBox chkTermosDeUso;
    Button btnCancelar;
    Button btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;
    public AdicionarClienteFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.adicionar_cliente_fragment, container, false);

        iniciarComponentesDeLayout();
        escutarEventosDosBotoes();

        return view;
    }



    /**
     * Inicializar os componentes da tela para add os clientes/ layout
     */
    private void iniciarComponentesDeLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novoCliente);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }

    private void escutarEventosDosBotoes() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 boolean isDadosOk = true;

                 if(TextUtils.isEmpty(editNomeCompleto.getText())){

                     isDadosOk = false;
                     editNomeCompleto.setError("Digite o Nome Completo...");
                     editNomeCompleto.requestFocus();
                 }
                if(TextUtils.isEmpty(editTelefone.getText())){

                    isDadosOk = false;
                    editTelefone.setError("Digite o Telefone...");
                    editTelefone.requestFocus();
                }
                if(TextUtils.isEmpty(editEmail.getText())){

                    isDadosOk = false;
                    editEmail.setError("Digite o Email...");
                    editEmail.requestFocus();
                }
                if(TextUtils.isEmpty(editCep.getText())){

                    isDadosOk = false;
                    editCep.setError("Digite o CEP...");
                    editCep.requestFocus();
                }
                if(TextUtils.isEmpty(editLogradouro.getText())){

                    isDadosOk = false;
                    editLogradouro.setError("Digite o Logradouro...");
                    editLogradouro.requestFocus();
                }
                if(TextUtils.isEmpty(editNumero.getText())){

                    isDadosOk = false;
                    editNumero.setError("Digite o Número...");
                    editNumero.requestFocus();
                }
                if(TextUtils.isEmpty(editBairro.getText())){

                    isDadosOk = false;
                    editBairro.setError("Digite o Bairro...");
                    editBairro.requestFocus();
                }
                if(TextUtils.isEmpty(editCidade.getText())){

                    isDadosOk = false;
                    editCidade.setError("Digite o Cidade...");
                    editCidade.requestFocus();
                }
                if(TextUtils.isEmpty(editEstado.getText())){

                    isDadosOk = false;
                    editEstado.setError("Digite o Estado...");
                    editEstado.requestFocus();
                }

                 if (isDadosOk){

                     //Popular os dados no obj cliente.

                     novoCliente.setNome(editNomeCompleto.getText().toString());
                     novoCliente.setTelefone(editTelefone.getText().toString());
                     novoCliente.setEmail(editEmail.getText().toString());
                     //Cast
                     novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                     novoCliente.setLogradouro(editLogradouro.getText().toString());
                     novoCliente.setNumero(editNumero.getText().toString());
                     novoCliente.setBairro(editBairro.getText().toString());
                     novoCliente.setCidade(editCidade.getText().toString());
                     novoCliente.setEstado(editEstado.getText().toString());

                     novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());



                     clienteController.incluir(novoCliente);
                     Log.i(AppUtil.TAG, "onClick:Dados Corretos ");
                 }else {
                     //notificar o usuario: toast, push notification, alertdialog
                     Log.i(AppUtil.TAG, "onClick:Dados Incorretos ");
                 }

            }
        });
    }

}
