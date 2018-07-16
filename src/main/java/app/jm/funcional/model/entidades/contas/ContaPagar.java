package app.jm.funcional.model.entidades.contas;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import app.jm.funcional.model.Tabela;

public class ContaPagar extends Tabela {

    private double valor;
    private Calendar vencimento;
    private int tipoConta;
    public static final String[] TIPOS_CONTA = {""};


 
    @Override
    public List<Tabela> getListValoresIniciais() {
        return null;
    }
}
