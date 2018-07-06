package com.jmdesenvolvimento.appcomercial.model.entidades.cadastral.pessoas;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.jmdesenvolvimento.appcomercial.model.Tabela;

public class EmpresaCliente extends APessoa {

    private Calendar dataCadastro;
    private int plano;
    private Calendar dataVencimento;
    private String email;
    private String senha;

//    @Override
//    public void setMapAtributos(HashMap<String, Object> map) {
//        id = (int) map.get(getIdNome());
//        pessoa = (Pessoa) map.get("pessoa");
//        dataCadastro = (Calendar) map.get("dataCadastro");
//        plano = (int) map.get("plano");
//        dataVencimento = (Calendar) map.get("dataVencimento");
//    }

    @Override
    public List<Tabela> getListValoresIniciais() {
        return null;
    }

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getPlano() {
		return plano;
	}

	public void setPlano(int plano) {
		this.plano = plano;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
    
    
}
