package com.org.crudspringweb.controllers;

import com.org.crudspringweb.entities.Cliente;
import com.org.crudspringweb.services.ICiudadService;
import com.org.crudspringweb.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String save(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes attribute) {

        if (result.hasErrors() || cliente.isValid()) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", ciudadService.findAll());
            attribute.addFlashAttribute("error", "ATENCION: Error con los datos del cliente!");
            return "/views/clientes/viewCrear";
        }

        clienteService.save(cliente);
        attribute.addFlashAttribute("success", "ATENCION: Cliente guardado con exito!");
        return "redirect:/views/clientes/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id, RedirectAttributes attribute) {

        Cliente cliente;

        if (id > 0) {
            cliente = clienteService.findOne(id);

            if (cliente == null) {
                attribute.addFlashAttribute("error", "ATENCION: El ID del cliente no existe!");
                return "redirect:/views/clientes/";
            }
        }else {
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del cliente");
            return "redirect:/views/clientes/";
        }

        cliente = clienteService.findOne(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", ciudadService.findAll());
        return "/views/clientes/viewCrear";
    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable("id") Integer id, RedirectAttributes attribute) {
        Cliente cliente;

        if (id > 0) {
            cliente = clienteService.findOne(id);

            if (cliente == null) {
                attribute.addFlashAttribute("error", "ATENCION: El ID del cliente no existe!");
                return "redirect:/views/clientes/";
            }
        }else {
            attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Cliente!");
            return "redirect:/views/clientes/";
        }
        clienteService.delete(id);
        attribute.addFlashAttribute("warning", "ATENCION: Cliente eliminado con exito!");
        return "redirect:/views/clientes/";
    }

}
