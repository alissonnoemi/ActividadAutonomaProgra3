package com.itsqmet.tiendaBeauty.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping ("/")
    public String mostrarHome() {
        return "index";
    }
    @GetMapping ("/marcas")
    public String mostrarMarcas() {
        return "pages/marcas";
    }
}
