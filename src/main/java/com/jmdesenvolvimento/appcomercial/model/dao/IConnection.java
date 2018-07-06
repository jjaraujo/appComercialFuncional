package com.jmdesenvolvimento.appcomercial.model.dao;

import java.util.List;

import com.jmdesenvolvimento.appcomercial.model.Tabela;
import com.jmdesenvolvimento.appcomercial.model.entidades.cadastral.pessoas.EmpresaCliente;

public interface IConnection {
    int countIdEntidade(Tabela t);
    void insert(Tabela t);
    void insert(List<?> t);
    void update(Tabela t, boolean b);
    void close();
    void execSQL(String sql);
    List<?> selectAll(Tabela tabela,String where, boolean pegaExcluidos);
    List<?>  selectAll(Tabela tabela, String where, boolean pegaExcluidos,String[] selectionArgs,String groupBy,String orderBy,String limit);
    void deleteLogico(Tabela tabela);
    Tabela select(Tabela tabela, String id, String where,String groupBy,String orderBy, String limit);
    int countIdEntidadeCriacao(Tabela tabela);
    
    public default EmpresaCliente selectEmpresaCliente() {
    	return (EmpresaCliente) select(new EmpresaCliente(), null, null, null, null, null);
    }
}
