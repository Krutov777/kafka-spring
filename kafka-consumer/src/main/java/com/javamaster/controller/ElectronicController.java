package com.javamaster.controller;

import com.javamaster.entity.Electronic;
import com.javamaster.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @GetMapping("/")
    public String homeGet(Model model) {
        model.addAttribute("electronics", electronicService.getElectronics().getBody());
        return "TableView";
    }

    @GetMapping("/add")
    public String addGet() {
        return "Add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String nameModel, @RequestParam String nameCompany, @RequestParam Double cost) {
        if (nameModel == null || nameCompany == null || cost == null) {
            return "error";
        }
        electronicService.addElectronic(new Electronic(nameModel, nameCompany, cost));
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteGet(@PathVariable(value = "id") Long id, Model model) {
        Electronic electronic = electronicService.getElectronic(id).getBody();
        System.out.println(electronic);
        model.addAttribute("electronic", electronic);
        model.addAttribute("id", id);
        return "Delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteGet(@PathVariable(value = "id") Long id) {
        electronicService.deleteElectronic(id);
        return "redirect:/";
    }
}
