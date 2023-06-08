package br.com.kaue.controllers;

import br.com.kaue.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

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

}
