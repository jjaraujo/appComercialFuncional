package app.jm.funcional.model.entidades.vendas;

import java.util.Calendar;

import app.jm.funcional.model.Tabela;

public class Caixa extends Tabela {
	
	private Calendar data;
	private double valorTotal;
	private double valorTotalAVista;
	private double valorTotalAPrazo;
	private double valorDesconto;
	
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public double getValorTotalAVista() {
		return valorTotalAVista;
	}
	public void setValorTotalAVista(double valorTotalAVista) {
		this.valorTotalAVista = valorTotalAVista;
	}
	public double getValorTotalAPrazo() {
		return valorTotalAPrazo;
	}
	public void setValorTotalAPrazo(double valorTotalAPrazo) {
		this.valorTotalAPrazo = valorTotalAPrazo;
	}
}
