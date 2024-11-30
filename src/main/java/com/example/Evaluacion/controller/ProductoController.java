
package com.example.Evaluacion.controller;

import com.example.Evaluacion.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ProductoController {

    // Ruta GET para mostrar el formulario
    @GetMapping("/formularioProducto")
    public String mostrarFormulario() {
        return "Registro"; // Nombre del archivo HTML que contiene el formulario
    }

    // Ruta POST para procesar el formulario
    @PostMapping("/registroProducto")
    public String registrarProducto(@RequestParam("nombre") String nombre,
                                    @RequestParam("fechaCaducidad") String fechaCaducidad,
                                    @RequestParam("stockMinimo") int stockMinimo,
                                    @RequestParam("stockMaximo") int stockMaximo,
                                    @RequestParam("precioUnitario") double precioUnitario,
                                    @RequestParam("categoria") String categoria,
                                    @RequestParam("marca") String marca,
                                    Model model) {

        // Convertir la fecha de caducidad a LocalDate
        LocalDate fecha = LocalDate.parse(fechaCaducidad);

        // Crear un nuevo producto con los datos recibidos
        Producto producto = new Producto(nombre, fecha, stockMinimo, stockMaximo, precioUnitario, categoria, marca);

        // Agregar el producto al modelo para pasarlo a la vista
        model.addAttribute("producto", producto);

        // Redirigir a la vista de resultados
        return "Resultado"; // Nombre del archivo HTML para mostrar los resultados
    }
}