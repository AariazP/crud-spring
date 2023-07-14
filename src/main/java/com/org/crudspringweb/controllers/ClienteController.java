package com.org.crudspringweb.controllers;

import com.org.crudspringweb.entities.Cliente;
import com.org.crudspringweb.services.ICiudadService;
import com.org.crudspringweb.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private ICiudadService ciudadService;

    @GetMapping("/")
    public String home(Model model) {
        List<Cliente> listadoClientes = clienteService.findAll();
        model.addAttribute("titulo", "Lista de Clientes");
        model.addAttribute("clientes", listadoClientes);
        return "/views/clientes/Listar";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", ciudadService.findAll());
        return "/views/clientes/viewCrear";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        System.out.println("cliente = " + cliente);
        System.out.println("Cliente guardado con éxito!");
        return "redirect:/views/clientes/";
    }
}
