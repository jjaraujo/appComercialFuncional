import app.jm.funcional.controller.LeituraJson;

public class Teste {

	public static void main(String[] args) {
		String s = "\"empresaCliente':{'dataCadastro':{'year':2018,'month':6,'dayOfMonth':12,'hourOfDay':22,'minute':50,'second':55},'plano':0,'dataVencimento':{'year':2018,'month':6,'dayOfMonth':12,'hourOfDay':22,'minute':50,'second':55},'login':'KSAFE@','senha':'','tipoUsuario':0,'pessoa':{'nomePessoa':'Joao Maria','nomeFantasia':'KSAFE','sexo':0,'logradouro':'','bairro':'','cep':0,'numero':0,'municipio':{'estado':{'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'estado':{'id':0,'empresaClienteId':0,'isPegandoAtributosSuperClass':false,'idAnterior':0},'rgIE':0,'cpfCNPJ':'','nascimento':'','telefone1':'','telefone2':'','email':'ksafe','id':4359331,'empresaClienteId':0,'dataExclusao':{'year':2018,'month':6,'dayOfMonth':12,'hourOfDay':22,'minute':50,'second':55},'isPegandoAtributosSuperClass':false,'idAnterior':0},'id':3,'empresaClienteId':0,'dataExclusao':{'year':2018,'month':6,'dayOfMonth':12,'hourOfDay':22,'minute':50,'second':55},'isPegandoAtributosSuperClass':false,'idAnterior':0}\"";
		LeituraJson.jsonParaTabela(s);

	}

}
