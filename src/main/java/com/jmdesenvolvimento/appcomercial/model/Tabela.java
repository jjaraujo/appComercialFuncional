package com.jmdesenvolvimento.appcomercial.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.jmdesenvolvimento.appcomercial.controller.FuncoesSql;
import com.jmdesenvolvimento.appcomercial.controller.VariaveisControleG;
import com.jmdesenvolvimento.appcomercial.controller.funcoesGerais.FuncoesGerais;
import com.jmdesenvolvimento.appcomercial.controller.funcoesGerais.VerificaTipos;
import com.jmdesenvolvimento.appcomercial.model.entidades.Entidade;

public abstract class Tabela implements Serializable {

	/**
	 * Informar instancias da tabela que cont�m valores a serem inseridos no banco
	 */
	public abstract List<Tabela> getListValoresIniciais();

	private HashMap<String, Object> map;
		
	public int id;

	public int empresaCliente = VariaveisControleG.empresaCliente == null ? 0 : VariaveisControleG.empresaCliente.getId() ;

	public Calendar dataExclusao;

	private boolean isPegandoAtributosSuperClassNOBASE;

	public boolean getPrecisaRegistroInicial() {
		return false;
	}

	public int getId() {
		id = id == 0 ? FuncoesGerais.getIdUnico() : id;
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Calendar dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public int getEmpresaCliente() {
		empresaCliente = VariaveisControleG.empresaCliente == null ? 0 : VariaveisControleG.empresaCliente.getId();
		return empresaCliente;
	}

	public void setEmpresaCliente(int empresaCliente) {
		this.empresaCliente = empresaCliente;
	}

	/**
	 * Busca o nome da classe, que ser� sempre o mesmo da tabela.
	 * 
	 * @param minusculo
	 *            - retorna o nome completamente minusculo
	 */
	public String getNomeTabela(boolean minusculo) {
		String nome = this.getClass().getSimpleName();
		return minusculo ? nome.substring(0, 1).toLowerCase().concat(nome.substring(1)) : nome;
	}
	

	/** @return Retorna o caminho da tabela no banco de dados */
	public String getCaminhoTabelaBanco(int tipoSql) {
		String nome = this.getClass().getSimpleName();
		if (tipoSql == FuncoesSql.SQL_SERVER) {
			return FuncoesSql.caminhoBanco() + "." + nome;
		}
		return nome;
	}
	
	 public void setMapAtributos(HashMap<String, Object> map){
	       for(String s :map.keySet()) {
	           Field field = null;
	           try {
	                field = this.getClass().getDeclaredField(s);
	           } catch (NoSuchFieldException e) {
	               try {
	                   field = this.getClass().getField(s);
	               } catch (NoSuchFieldException e1) {
	                   e1.printStackTrace();
	               }
	           }
	           try {
	               field.setAccessible(true);
	               field.set(this,map.get(s));
	           } catch (IllegalAccessException e) {
	               e.printStackTrace();
	           }
	       }
	    }

	/**
	 * @param carregaMapNovamente - se true, os dados da tabela serão carregados novamente no map
	 * @return Retorna o map com todos os atributos da classe e atributos  e seus valores
	 */
	  public HashMap<String, Object> getMapAtributos(boolean carregaMapNovamente) {

	        // retornar� o map da memória se ele j� tiver sido criado uma vez ou se nao
	        if (map != null && !carregaMapNovamente && !isPegandoAtributosSuperClassNOBASE ) {
	            return map;
	        }

	        map = isPegandoAtributosSuperClassNOBASE ? map : new HashMap<String, Object>();

	        map.put("id",0);
        	map.put("dataExclusao",FuncoesGerais.getCalendarNulo());
        	map.put("empresaCliente",0);
	        
	        Field[] fields = getClass().getDeclaredFields();
	        if(!isPegandoAtributosSuperClassNOBASE) {
	            isPegandoAtributosSuperClassNOBASE = true;
	            getMapAtributos(false);
	            fields = getClass().getFields();
	       //     Log.i("Fields super", fields.length +"");
	        }
	        isPegandoAtributosSuperClassNOBASE = false;

	        //caso o id da tabela tenha valor > 0, ser� adicionado no map o valor atual
//	        int id = getId() == 0 ? 0 : getId();
//	        map.put(getIdNome(), id);

	        // caso a dataExclusao nao tenha nenhum valor, ser� criado um valor vazio
//	        Calendar dataExclusao = getDataExclusao() == null ? FuncoesGerais.getCalendarNulo() : getDataExclusao();
//	        map.put(getDataExclusaoNome(), dataExclusao);

	        for (Field field : fields) {
	            field.setAccessible(true);
	//
	            //verifica se a vari�vel � est�tica
	            int modifiers = field.getModifiers();
	            if (Modifier.isStatic(modifiers) || field.getName().contains("NOBASE")) {
	                continue;
	            }

	            try {
	                Object objectField = null;
	                try {
	                    objectField = !FuncoesGerais.classIsFinal(field.getType()) ? field.getType().newInstance() : null;
	                } catch (InstantiationException e) {
	                    // variaveis que nao podem ser instanciadas
	                        objectField = field.getType().getName().toLowerCase().contains("boolean") ? field.get(this) : null;
	                   if(objectField == null)
	                        e.printStackTrace();
	                }

	                // caso o field seja uma entidade, ser� adicionado o  na chave no map para ficar igual ao banco
	                if (VerificaTipos.isTabela(field, this)) {

	                    Tabela object = FuncoesGerais.getFieldTypeTabela(this, field) == null ?
	                            FuncoesGerais.getNovaInstanciaTabela(field) :
	                            FuncoesGerais.getFieldTypeTabela(this, field);
	                    object.getMapAtributos(false);
	                    map.put(field.getName(),object);// + FuncoesGerais.prefixoChaveEstrangeira(), object);

	                } else {
	                    if (field.get(this) == null) { // neste IF, valores que podem estar nulos
	                        if (VerificaTipos.isBoolean(objectField, field)) {
	                            map.put(field.getName(), FuncoesGerais.booleanToint(field.getBoolean(this)));
	                        } else if (VerificaTipos.isString(objectField, field)) {
	                            map.put(field.getName(), "");
	                        } else if (VerificaTipos.isList(objectField, field)) {
	                            map.put(field.getName(), new ArrayList<>());
	                        } else if (VerificaTipos.isCalendar(objectField, field)) {
	                            map.put(field.getName(), FuncoesGerais.getCalendarNulo());
	                        } else {
	                            map.put(field.getName(), 0);
	                        }
	                    } else {
	                        map.put(field.getName(), field.get(this));
	                    }
	                }
	            } catch (IllegalAccessException e) {
	                e.printStackTrace();
	            }
	        }
	        return map;
	    }
	public String getIdNome() {
		return "id";
	}
	
	public String getNomeTabelaNomeId() {
		return getNomeTabela(false) + "." + getIdNome() ;
	}

	public String getDataExclusaoNome() {
		return "dataExclusao";
	}

	public String prefixoDataExclusao() {
		return "dataExclusao";
	}

	/**
	 * Verifica se a tabela � uma entidade
	 */

	public boolean isEntidade() {
		try {
			Entidade e = (Entidade) this;
			return true;
		} catch (ClassCastException e) {
			return false;
		}
	}

	/**
	 * Busca o nome de todos os atributos do map e adiciona em uma unica linha,
	 * separados por virgula. Ideal em uso de SQL
	 */
	public String getNomesAtibutosInLinha() {
		Set<String> set = getMapAtributos(false).keySet();
		String array = "";
		for (String s : set) {
			array += ", " + s;
		}
		return array;
	}

	/** Busca o nome de todos os atributos do map */

	public String[] getNomesAtributos() {
		Object[] o = getMapAtributos(false).keySet().toArray();
		String[] strings = new String[o.length];
		for (int i = 0; i < o.length; i++) {
			strings[i] = o[i] + "";
		}
		return strings;
	}
	
	public void anulaMapAtributo(){
        map = null;
    }

}
