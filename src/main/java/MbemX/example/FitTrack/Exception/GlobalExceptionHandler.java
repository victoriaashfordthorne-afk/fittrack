package MbemX.example.FitTrack.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> gererErreursValidation(
            MethodArgumentNotValidException ex) {


        Map<String,String> erreurs = new HashMap<>();


        ex.getBindingResult()
                .getFieldErrors()
                .forEach(erreur ->
                        erreurs.put(
                                erreur.getField(),
                                erreur.getDefaultMessage()
                        )
                );


        return erreurs;
    }


    }


