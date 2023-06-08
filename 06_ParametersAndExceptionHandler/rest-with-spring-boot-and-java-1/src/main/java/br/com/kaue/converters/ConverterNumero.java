package br.com.kaue.converters;

public class ConverterNumero {
    //Convertendo o valor da String para Double
    public static Double convertToDouble(String strNumero) {
        if(strNumero == null) return 0D;
        //Pensando no cenário da nossa moeda se o usuário colocar o valor com vircula vai converter para ponto como a convenção americanda
        String number = strNumero.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    //Verificando se o valor é numerico
    public static boolean isNumeric(String strNumero) {
        if(strNumero == null) return false;
        String number = strNumero.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
