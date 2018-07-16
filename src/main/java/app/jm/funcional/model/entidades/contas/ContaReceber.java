package app.jm.funcional.model.entidades.contas;

import java.util.Calendar;

import app.jm.funcional.model.entidades.Entidade;
import app.jm.funcional.model.entidades.cadastral.pessoas.Cliente;
import app.jm.funcional.model.entidades.vendas.TipoPagamento;import app.jm.funcional.model.tabelasIntermediarias.TabelaParcelasPagamento;

public class ContaReceber extends Entidade {

    private TipoPagamento tipoPagamento;
    private TabelaParcelasPagamento tabelaParcelasPagamento;
    private Cliente cliente;
    private Calendar dataVencimento;


    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TabelaParcelasPagamento getParcelasPagamento() {
        return tabelaParcelasPagamento;
    }

    public void setParcelasPagamento(TabelaParcelasPagamento parcelasPagamento) {
        this.tabelaParcelasPagamento = parcelasPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente venda) {
        this.cliente = venda;
    }

    public TabelaParcelasPagamento getTabelaParcelasPagamento() {
        return tabelaParcelasPagamento;
    }

    public void setTabelaParcelasPagamento(TabelaParcelasPagamento tabelaParcelasPagamento) {
        this.tabelaParcelasPagamento = tabelaParcelasPagamento;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
