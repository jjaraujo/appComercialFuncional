import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import app.jm.funcional.controller.FuncoesSql;
import app.jm.funcional.controller.LeituraJson;
import app.jm.funcional.model.Tabela;
import app.jm.funcional.model.entidades.cadastral.pessoas.Pessoa;

public class Teste {

	public static <T> void main(String[] args) {
		
		String s = "{\"pessoa':[{'nomePessoa':'Joao Maria','nomeFantasia':'','sexo':0,'logradouro':'','bairro':'','cep':0,'numero':0,'municipio':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'estado':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'rgIE':0,'cpfCNPJ':'','nascimento':'','telefone1':'','telefone2':'','email':'ksafe@','idNaEmpresa':0,'id':215241,'empresaClienteId':2,'dataExclusao':{'year':1969,'month':11,'dayOfMonth':31,'hourOfDay':21,'minute':0,'second':0},'isPegandoAtributosSuperClass':false,'idAnterior':0},{'nomePessoa':'Joao Maria','nomeFantasia':'KSAFE','sexo':0,'logradouro':'','bairro':'','cep':0,'numero':0,'municipio':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'estado':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'rgIE':0,'cpfCNPJ':'','nascimento':'','telefone1':'','telefone2':'','email':'jjaraujo@','idNaEmpresa':0,'id':1484962,'empresaClienteId':2,'dataExclusao':{'year':1969,'month':11,'dayOfMonth':31,'hourOfDay':21,'minute':0,'second':0},'isPegandoAtributosSuperClass':false,'idAnterior':0},{'nomePessoa':'JOao','nomeFantasia':'KSAFE','sexo':0,'logradouro':'','bairro':'','cep':0,'numero':0,'municipio':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'estado':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'rgIE':0,'cpfCNPJ':'','nascimento':'','telefone1':'','telefone2':'','email':'jjaraujo@','idNaEmpresa':0,'id':1673773,'empresaClienteId':2,'dataExclusao':{'year':1969,'month':11,'dayOfMonth':31,'hourOfDay':21,'minute':0,'second':0},'isPegandoAtributosSuperClass':false,'idAnterior':0},{'nomePessoa':'Joao Junior','nomeFantasia':'','sexo':0,'logradouro':'','bairro':'','cep':0,'numero':0,'municipio':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'estado':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'rgIE':0,'cpfCNPJ':'','nascimento':'','telefone1':'','telefone2':'','email':'','idNaEmpresa':0,'id':2791972,'empresaClienteId':2,'dataExclusao':{'year':1969,'month':11,'dayOfMonth':31,'hourOfDay':21,'minute':0,'second':0},'isPegandoAtributosSuperClass':false,'idAnterior':0},{'nomePessoa':'Joao Maria','nomeFantasia':'','sexo':0,'logradouro':'','bairro':'','cep':0,'numero':0,'municipio':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'estado':{'idNaEmpresa':0,'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'rgIE':0,'cpfCNPJ':'','nascimento':'','telefone1':'','telefone2':'','email':'jjaraujo@','idNaEmpresa':0,'id':8383139,'empresaClienteId':2,'dataExclusao':{'year':1969,'month':11,'dayOfMonth':31,'hourOfDay':21,'minute':0,'second':0},'isPegandoAtributosSuperClass':false,'idAnterior':0}]\"";
		
		List tabelas = LeituraJson.jsonParaList(s);
		
	}

}
