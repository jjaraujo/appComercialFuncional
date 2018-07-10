package com.jmdesenvolvimento.appcomercial.model.entidades.cadastral.pessoas;


import java.util.HashMap;
import java.util.List;

import com.jmdesenvolvimento.appcomercial.model.Tabela;
import com.jmdesenvolvimento.appcomercial.model.entidades.Entidade;

public class Funcionario  extends APessoa{

    private double comissao;
    private String usuario;
    private String senha;

//    @Override
//    public void setMapAtributos(HashMap<String, Object> map) {
//        id = (int) map.get("id_vendedor");
//        pessoa = (Pessoa) map.get("pessoa");
//        comissao = (double) map.get("comissao");
//        usuario = (String) map.get("usuario");
//        senha = (String) map.get("senha");
//    }
    
    @Override
    public long getId() {
    	return id;
    }
    
    public Double getComissao(){
        return this.comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	@Override
	public List<Tabela> getListValoresIniciais() {
		// TODO Auto-generated method stub
		return null;
	}
}
