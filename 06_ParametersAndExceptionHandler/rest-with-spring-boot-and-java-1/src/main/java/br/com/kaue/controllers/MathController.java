package br.com.kaue.controllers;

import br.com.kaue.exceptions.UnsuportedMathOperationException;
import br.com.kaue.simplemath.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static br.com.kaue.converters.ConverterNumero.*;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    //Endpoint da API e seus parametros obrigatórios
    @RequestMapping(value = "/soma/{numeroUm}/{numeroDois}",
            //Metodo da API
            method = RequestMethod.GET)
    public Double soma(
            //Recupera dados da url
            @PathVariable(value = "numeroUm") String numeroUm,
            @PathVariable(value = "numeroDois") String numeroDois
        //Lançando uma exception
        ) throws Exception{

        // Validando se a String é numerica
        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        //Convertendo e somando os dois numero
        return math.soma(convertToDouble(numeroUm), convertToDouble(numeroDois));
    }

    @RequestMapping(value = "/subtracao/{numeroUm}/{numeroDois}",
            //Metodo da API
            method = RequestMethod.GET)
    public Double subtracao(
            //Recupera dados da url
            @PathVariable(value = "numeroUm") String numeroUm,
            @PathVariable(value = "numeroDois") String numeroDois
        //Lançando uma exception
        ) throws Exception{

        // Validando se a String é numerica
        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        //Convertendo e subtraindo os dois numero
        return math.subtracao(convertToDouble(numeroUm), convertToDouble(numeroDois));
    }
    @RequestMapping(value = "/divisao/{numeroUm}/{numeroDois}",
            //Metodo da API
            method = RequestMethod.GET)
    public Double divisao(
            //Recupera dados da url
            @PathVariable(value = "numeroUm") String numeroUm,
            @PathVariable(value = "numeroDois") String numeroDois
        //Lançando uma exception
        ) throws Exception{

        // Validando se a String é numerica
        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        //Convertendo e divisao os dois numero
        return math.divisao(convertToDouble(numeroUm), convertToDouble(numeroDois));
    }
    @RequestMapping(value = "/multiplicacao/{numeroUm}/{numeroDois}",
            //Metodo da API
            method = RequestMethod.GET)
    public Double multiplicacao(
            //Recupera dados da url
            @PathVariable(value = "numeroUm") String numeroUm,
            @PathVariable(value = "numeroDois") String numeroDois
        //Lançando uma exception
        ) throws Exception{

        // Validando se a String é numerica
        if(!isNumeric(numeroUm) || !isNumeric(numeroDois)) {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }

        //Convertendo e multiplicacao os dois numero
        return math.multiplicacao(convertToDouble(numeroUm), convertToDouble(numeroDois));
    }

}
