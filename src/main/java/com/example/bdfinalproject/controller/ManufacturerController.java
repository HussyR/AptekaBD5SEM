package com.example.bdfinalproject.controller;

import com.example.bdfinalproject.dto.EmployeeDto;
import com.example.bdfinalproject.dto.ManufacturerDto;
import com.example.bdfinalproject.dto.MedicationDto;
import com.example.bdfinalproject.model.Employee;
import com.example.bdfinalproject.model.Manufacturer;
import com.example.bdfinalproject.model.Medication;
import com.example.bdfinalproject.service.EmployeeService;
import com.example.bdfinalproject.service.ManufacturerService;
import com.example.bdfinalproject.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManufacturerController {

    private final EmployeeService employeeService;
    private final ManufacturerService manufacturerService;
    private final MedicationService medicationService;

    @Autowired
    public ManufacturerController(EmployeeService employeeService, ManufacturerService manufacturerService, MedicationService medicationService) {
        this.employeeService = employeeService;
        this.manufacturerService = manufacturerService;
        this.medicationService = medicationService;
    }

    @GetMapping("/manufacturersAndMedications")
    public String getManufacturersAndMedications(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        model.addAttribute("medications", medicationService.getAllMedications());
        return "manufacturersAndMedications";
    }

    @GetMapping("/addManufacturer")
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new ManufacturerDto());
        return "newManufacturer";
    }

    @GetMapping("/addMedication")
    public String addMedication(Model model) {
        model.addAttribute("medication", new MedicationDto());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "newMedication";
    }

    @PostMapping("/addManufacturer")
    public String saveManufacturer(@ModelAttribute("manufacturer") ManufacturerDto manufacturerDto) {
        manufacturerService.save(manufacturerDto);
        return "redirect:/manufacturersAndMedications";
    }
    @PostMapping("/addMedication")
    public String saveMedication(@ModelAttribute("medication") MedicationDto medicationDto) {
        int index = (int)medicationDto.getManufacturerId().intValue() - 1;
        List<Manufacturer> manufacturerList = manufacturerService.getAllManufacturers();
        Manufacturer neededManufacturer = manufacturerList.get(index);
        medicationDto.setManufacturer(neededManufacturer);
        medicationService.save(medicationDto);
        return "redirect:/manufacturersAndMedications";
    }

    @GetMapping("/deleteManufacturer/{id}")
    public String deleteManufacturer(@PathVariable(value = "id") long id) {
        manufacturerService.delete(id);
        return "redirect:/manufacturersAndMedications";
    }

    @GetMapping("/deleteMedication/{id}")
    public String deleteMedication(@PathVariable(value = "id") long id) {
        medicationService.delete(id);
        return "redirect:/manufacturersAndMedications";
    }

    @GetMapping("/updateManufacturer/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        ManufacturerDto manufacturerDto = new ManufacturerDto(id, manufacturer.getName(), manufacturer.getAddress());
        model.addAttribute("manufacturer", manufacturerDto);
        return "updateManufacturer";
    }

    @PostMapping("/updatedManufacturer")
    public String updateTable(@ModelAttribute("table") ManufacturerDto manufacturerDto) {
        manufacturerService.update(manufacturerDto);
        return "redirect:/manufacturersAndMedications";
    }

}
