package mx.uv.listi._9.Saludar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
public class SaludarControlador {
    Saludador s;

    @RequestMapping("/")
    public String home() {
        return "<ul><li><a href='/altas'>Altas</a></li>"
                + "<li><a href='/bajas'>Bajas</a></li>"
                + "<li><a href='/cambios'>Cambios</a></li>"
                + "<li><a href='/consultas'>Consultas</a></li></ul>";
    }

    // Ejemplos de endpoints no adecuados
    @RequestMapping("/altas")
    public String altas() {
        return "altas";
    }

    @RequestMapping("/bajas")
    public String bajas() {
        return "bajas";
    }

    @RequestMapping("/cambios")
    public String cambios() {
        return "cambios";
    }

    @RequestMapping("/consultas")
    public String consultas() {
        return "consultas";
    }

    // Ejemplos de endopints Si adecuados porque siguen el modelo REST
    @RequestMapping(value = "/Saludar", method = RequestMethod.POST)
    public String altasREST() {
        return "altas";
    }

    @RequestMapping(value = "/Saludar", method = RequestMethod.DELETE)
    public String bajasREST() {
        return "bajas";
    }

    @RequestMapping(value = "/Saludar", method = RequestMethod.PUT)
    public String cambiosREST() {
        return "cambios";
    }

    @RequestMapping(value = "/Saludar", method = RequestMethod.GET)
    public String consultasREST() {
        return "consultas";
    }

    // --------------------------
    // @GetMapping("/saludar1")
    // public String saludarPath1() {
    // }

    @GetMapping(value = { "/saludar1", "/saludar1/{nombre}" })
    public Saludador saludarPath1(@PathVariable(required = false) String nombre) {
        if (nombre != null)
            return new Saludador(nombre);
        else {
            return new Saludador("Valor por default");
        }
    }

    // Recepcion de parámetros de tipo query string.
    @GetMapping("/query")
    public void saludarQuery(@RequestParam String nombre) {
        System.out.println(nombre);
    }

    // Recepción de parámetros estructurados.
    @PostMapping("/crearsaludo")
    public String saludoCrear(@RequestBody Saludador parametro) {
        s = parametro;
        System.out.println(parametro.getContenido());
        return "Éxito";
    }

    @GetMapping("/obtenersaludo")
    public Saludador saludoObtener() {
        return s;
    }

}