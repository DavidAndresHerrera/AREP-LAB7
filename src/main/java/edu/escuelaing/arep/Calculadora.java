package edu.escuelaing.arep;

import org.json.JSONObject;

import static spark.Spark.*;

public class Calculadora {
    public static void main(String[] args) {

        port(getPort());
        get("/convertir",(req,res)->{
            String dato = req.queryParams("value");
            return respuestaConversion(dato);
        });

    }

    private static Object respuestaConversion(String dato) {
        JSONObject jsObject = new JSONObject();
        Double numero = Double.parseDouble(dato);
        Double cinco = new Double(5);
        Double nueve = new Double(9);
        Double  total = (numero - 32) * (cinco/nueve);
        jsObject.put("Conversion ", "grados fahrenheit a grados celsius ");
        jsObject.put("fahrenheit",numero);
        jsObject.put("celsius",total);
        return jsObject;
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36001;
    }
}
