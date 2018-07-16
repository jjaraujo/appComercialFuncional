package app.jm.funcional.model.entidades.cadastral.pessoas;

import app.jm.funcional.model.dao.IConnection;

@SuppressWarnings("serial")
public class Usuario extends APessoa {

	public String login;
	public String senha;
	private int tipoUsuario;
	// public EmpresaCliente empresaCliente;

	@Override
	public void geraId(IConnection con) {
		con.countIdNaEmpresa(this);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public boolean isbackup() {
		return false;
	}
	
}
