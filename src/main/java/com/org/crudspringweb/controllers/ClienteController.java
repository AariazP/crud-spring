package com.org.crudspringweb.controllers;

import com.org.crudspringweb.entities.Cliente;
import com.org.crudspringweb.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/")
    public String home(Model model) {
        List<Cliente> listadoClientes = clienteService.findAll();
        model.addAttribute("titulo", "Lista de Clientes");
        listadoClientes.forEach(System.out::println);
        model.addAttribute("clientes", listadoClientes);
        return "/views/clientes/Listar";
    }

}
