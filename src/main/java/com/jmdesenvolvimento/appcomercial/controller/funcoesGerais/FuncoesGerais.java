package com.jmdesenvolvimento.appcomercial.controller.funcoesGerais;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;

import com.jmdesenvolvimento.appcomercial.controller.TabelasMapeadas;
import com.jmdesenvolvimento.appcomercial.controller.VariaveisControleG;
import com.jmdesenvolvimento.appcomercial.model.Tabela;
import com.jmdesenvolvimento.appcomercial.model.dao.IConnection;
import com.jmdesenvolvimento.appcomercial.model.entidades.vendas.Venda;

/**Aqui ficam as funÃƒÂ§ÃƒÂµes que servem para Android e Java*/
public final class FuncoesGerais {

    private static boolean usandoDatePickerDialog;
    public static final String yyyyMMdd_HHMMSS = "yyyy-MM-dd hh:mm:ss";
    public static final String ddMMyyyy = "dd/MM/yyyy";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    
    public static int getIdUnico() {
    	int idEmpresa = VariaveisControleG.empresaCliente == null ? 0 : VariaveisControleG.empresaCliente.getId();
    	int i = (int) Math.random() * 10;
    	int i2 = (int) Math.random();
    	String idFuncionario = VariaveisControleG.funcionarioLogado == null ? i + "" : VariaveisControleG.funcionarioLogado.getId() + "";
    	long intAnt = (+new GregorianCalendar().getTimeInMillis());
    	String ss = String.valueOf(intAnt);
    	String s = ss.substring(ss.length() - 5,ss.length());
    	return Integer.parseInt(idEmpresa + idFuncionario + i2 + s);
    }
    
    public static int getIdUnicoVenda() {
    	int idEmpresa = VariaveisControleG.empresaCliente == null ? 0 : VariaveisControleG.empresaCliente.getId();
    	double i = Math.random();
    	long intAnt = (+new GregorianCalendar().getTimeInMillis());
    	String ss = String.valueOf(intAnt);
    	String s = ss.substring(ss.length() - 4,ss.length());
    	String idVendedor = VariaveisControleG.funcionarioLogado == null ? addZeros(Integer.parseInt(s), 4) : VariaveisControleG.funcionarioLogado.getId() + "";
    	IConnection iConnection = VariaveisControleG.iConnection;
    	int id = iConnection.countIdEntidade(new Venda()) + 1;
    	return Integer.parseInt(idEmpresa + idVendedor + id) ;
    	//191501153408
    	//1914016153911
    	//199018153652
    }

    public static String corrigeValoresCampos(String s) {
        if (s == null) {
            return "null";
        } else {
            return s;
        }
    }

    public static String converteNuloToVazio(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    public static int corrigeValoresCamposInt(String i) {
        i = FuncoesGerais.removePontosTracos(i);
        if (i == null || i.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(i);
        }
    }

    public static int corrigeValoresCamposInt(Object i) {
        if (i == null) {
            return 0;
        } else {
            return (int) i;
        }
    }

    public static long corrigeValoresCamposLong(String i) {
        i = FuncoesGerais.removePontosTracos(i);
        if (i == null || i.equals("")) {
            return 0;
        } else {
            return Long.parseLong(i);
        }
    }

    public static long corrigeValoresCamposLong(Object o) {
        if (o == null) {
            return 0;
        } else {
            return (long) o;
        }
    }

    public static Calendar corrigeValoresCalendar(Object o, String formato) {
        if (o == null) {
            return Calendar.getInstance();
        } else {
            return stringToCalendar(o+"", formato);
        }
    }

    public static double corrigeValoresCamposDouble(String i) {
        if (i == null || i.equals("")) {
            return 0;
        } else {
            return Double.parseDouble(i);
        }
    }

    public static double corrigeValoresCamposDouble(Object i) {
        if (i == null) {
            return 0.0;
        } else {
            return (double) i;
        }
    }

    public static boolean stringIsSomenteNumero(String query) {
        char[] ca = query.toCharArray();
        boolean d = false;
        for (char c : ca) {
            if (Character.isDigit(c) && !Character.isAlphabetic(c)) {
                d = true;
                break;
            } else {
                break;
            }
        }
        return d;
    }

    public static String removeCaracteresEspeciais(String string) {
    	return string;
//        return string
//                .replaceAll("[Ã£Ã¢Ã Ã¡Ã¤]", "a")
//                .replaceAll("[ÃªÃ¨Ã©Ã«&]", "e")
//                .replaceAll("[Ã®Ã¬Ã­Ã¯]", "i")
//                .replaceAll("[ÃµÃ´Ã²Ã³Ã¶]", "o")
//                .replaceAll("[Ã»ÃºÃ¹Ã¼]", "u")
//                .replaceAll("[ÃƒÃ‚Ã€Ã�Ã„]", "A")
//                .replaceAll("[ÃŠÃˆÃ‰Ã‹]", "E")
//                .replaceAll("[ÃŽÃŒÃ�Ã�]", "I")
//                .replaceAll("[Ã•Ã”Ã’Ã“Ã–]", "O")
//                .replaceAll("[Ã›Ã™ÃšÃœ]", "U")
//                .replace('Ã§', 'c')
//                .replace('Ã‡', 'C')
//                .replace('Ã±', 'n')
//                .replace('Ã‘', 'N')
//                ;
    }

    public static String removePontosTracos(String s) {
        return s.replace(".", "")
                .replace("-", "")
                .replace("_", "")
                .replace(",", "");
    }

    public static boolean fieldExtendsEntidade(Field f) {
        if (f.getType().getSuperclass() == null || f == null) {
            return false;
        }
        return f.getType().getSuperclass().toString().toLowerCase().trim().contains("entidade");
    }

//    public static String prefixoChaveEstrangeira() {
//        return "_idFK";
//    }

    public static String removeNullZeroFormularios(String s) {
        if(s == null){
            return " ";
        }
        String snovo = s.replace("null", "").replace("0.0", "").replace("0", "");
        if (snovo.equals("")) {
            return " ";
        } else {
            return s;
        }
    }

    public static Tabela getTabelaModificada(Tabela tabelaAntiga, Tabela tabelaAlterada, Tabela tabelaNova) {
        HashMap<String, Object> mapAntigo = tabelaAntiga.getMapAtributos(false);
        HashMap<String, Object> mapAlterado = tabelaAlterada.getMapAtributos(false);
        HashMap<String, Object> mapNovo = tabelaNova.getMapAtributos(false);

        Set<String> set = mapAntigo.keySet();
        for (String s : set) {
            if (!(mapAntigo.get(s) + "").equals(mapAlterado.get(s) + "")) {
                mapNovo.put(s, mapAlterado.get(s));
            }
        }
        mapNovo.put(tabelaAntiga.getIdNome(), tabelaAntiga.getId());
        tabelaNova.setMapAtributos(mapNovo);
        return tabelaNova;
    }

    public static String addZeros(int numero,int tamanhoTotal){
        String formatado = "" ;
        int tamanhoAtual = (numero+"").length();
        while( tamanhoAtual <  tamanhoTotal){
            formatado = "0" + formatado;
            tamanhoAtual ++;
        }
        return formatado + numero;
    }

    public static boolean intToBoolean(int i) {
        if (i == 1) {
            return true;
        }
        return false;
    }

    public static int booleanToint(boolean b) {
        if (b == true) {
            return 1;
        }
        return 0;
    }


    public static String formataTextoData(int dia, int mes, int ano){
        mes = mes + 1;
        String mesString = mes + "";
        String diaString = dia + "";
        if(mes < 10){
            mesString = "0" + mesString;
        }
        if(dia < 10){
            diaString = "0" + diaString;
        }
       return diaString+"/"+mesString+"/"+ano;
    }

   
    /**Usar um dos formados declarados nesta classe
     * Retorna null se valor == null ou valor == ""*/
    public static Calendar stringToCalendar(String valor,String formato){
        if(valor == null || valor.equals("")){
            return null;
        }
        try {
            SimpleDateFormat fd = new SimpleDateFormat(formato);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fd.parse(valor));
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Tabela getNovaInstanciaTabela(Field field){
        try {
            Type type = field.getType();
            String nomeType = type.toString().replace("class ", "");
            Tabela tabela = (Tabela) Class.forName(nomeType).newInstance();

            return tabela;

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
     }

    public static String calendarToString(Calendar calendar, String formato, boolean paraSql){
        if(calendar == null || calendar.getTimeInMillis() == 0 ){
            return null;
        }
            SimpleDateFormat fd = new SimpleDateFormat(formato);
        String data= "'"+ fd.format(calendar.getTime()) + "'";
        return paraSql == false ? data.replace("'","") : data;
    }

    /**@param nomeAtributo - Informe o nome do field na tabela
     * @param tabela - Informe o objeto tabela onde o valor serÃ¡ pegado
     * @return Retorna o valor do field de uma tabela pelo nome*/
    public static Object getValorFieldDeTabela(String nomeAtributo, Tabela tabela) {
        
    	 Class classe = tabela.getClass();
    	 try {
  
            Field f = getFieldDeTabela(nomeAtributo,  tabela);
            return f.get(tabela);
            
        } catch (IllegalAccessException e) {
     //       Log.e("IllegalAccessException", "NÃƒÂ£o foi possÃƒÂ­vel encontrar o objeto " + nomeAtributo + " da tabela " + tabela.getNomeTabela(false));
            e.printStackTrace();
            return null;
        }
    }
    
    /**@param nomeAtributo - Informe o nome do field na tabela
     * @param tabela - Informe o objeto tabela onde o field serÃ¡ pegado
     * @return Retorna o valor do field de uma tabela pelo nome*/
    public static Field getFieldDeTabela(String nomeAtributo, Tabela tabela) {
    	Class classe = tabela.getClass();
    	 Field f;
    	try {
            
            f = classe.getDeclaredField(nomeAtributo);
            f.setAccessible(true);
            return f;

        } catch (NoSuchFieldException e) {
            try {
				f = classe.getField(nomeAtributo);
				f.setAccessible(true);
				return f;
			} catch (NoSuchFieldException | SecurityException e1) {
				e1.printStackTrace();
			}
            return  null;
        }
    }


    public static String getPrefixoPK(){
        return "_pk";
    }

    public static Tabela instanciaTabelaPorField(Field field){
           Type type = field.getType();
           int i = 0;
           String nomeType = type.toString();
           Tabela tabela = TabelasMapeadas.getTabelaForNome(nomeType,false);
           return tabela;
    }

    public static Tabela getFieldTypeTabela(Tabela objectTabela, Field field){
    	Tabela tabela = instanciaTabelaPorField(field);
    	
    	try {
            
            Field tabelaField = objectTabela.getClass().getDeclaredField(tabela.getNomeTabela(true).trim());
            tabelaField.setAccessible(true);

            return (Tabela) tabelaField.get(objectTabela);

        }catch (NoSuchFieldException e) {
 //           Log.i("NoSuchFieldException", "Erro ao buscar atributo " + field.getName() + " na TABELA " + objectTabela.getNomeTabela(false));
        	Field tabelaField;
			try {
				tabelaField = objectTabela.getClass().getField(tabela.getNomeTabela(true).trim());
				tabelaField.setAccessible(true);
				 return (Tabela) tabelaField.get(objectTabela);
			} catch (NoSuchFieldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
        } catch (NullPointerException e) { 
  //          Log.i("NullPointerException", "Erro ao buscar atributo " + field.getName() + " - TABELA " + objectTabela.getNomeTabela(false));
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Calendar getCalendarNulo(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(0);
        return calendar;
    }

    public static boolean calendarIsNulo(Calendar calendar){
        return calendar.getTimeInMillis() == 0;
    }


    public static boolean classIsFinal(Object o){
        return Modifier.isFinal(o.getClass().getModifiers());
    }
    
 
}
