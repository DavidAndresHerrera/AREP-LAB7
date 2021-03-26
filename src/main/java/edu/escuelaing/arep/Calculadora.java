package edu.escuelaing.arep;

import org.json.JSONObject;

import static spark.Spark.*;

public class Calculadora {
    public static void main(String[] args) {

        port(getPort());
        get("/cos",(req,res)->{
            String dato = req.queryParams("value");
            return respuestaCos(dato);

        });
        get("/ln",(req,res)->{
            String dato = req.queryParams("value");
            return respuestaLn(dato);

        });
    }

    private static Object respuestaLn(String dato) {
        JSONObject jsObject = new JSONObject();
        Double numero = Double.parseDouble(dato);
        double  total = Math.log(numero);
        jsObject.put("Operacion", "Logaritmo natural ");
        jsObject.put("Dato",dato);
        jsObject.put("Resultado",total);
        return jsObject;
    }

    private static Object respuestaCos(String dato) {
        JSONObject jsObject = new JSONObject();
        Double numero = Double.parseDouble(dato);
        double  total = Math.cos(numero);
        jsObject.put("Operacion", "Coseno");
        jsObject.put("Dato",dato);
        jsObject.put("Resultado",total);
        return jsObject;
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36001;
    }
}
