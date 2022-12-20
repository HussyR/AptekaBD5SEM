package com.example.bdfinalproject.controller;

import com.example.bdfinalproject.dto.ClientDto;
import com.example.bdfinalproject.dto.OrderDto;
import com.example.bdfinalproject.model.*;
import com.example.bdfinalproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private final EmployeeService employeeService;
    private final ManufacturerService manufacturerService;
    private final MedicationService medicationService;
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public MainController(EmployeeService employeeService, ManufacturerService manufacturerService, MedicationService medicationService, UserService userService, OrderService orderService) {
        this.employeeService = employeeService;
        this.manufacturerService = manufacturerService;
        this.medicationService = medicationService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/adminMainPage")
    public String getAdminMainPage(Model model) {
        List<ClientDto> clients = new ArrayList<ClientDto>();

        List<Client> clientList = userService.getAllUsers();

        for (Client client: clientList) {
            List<Order> neededOrders = orderService.getAllByClient(client);
            List<OrderDto> neededOrdersDto = new ArrayList<>();
            for (int i = 0; i < neededOrders.size(); i++) {
                OrderDto orderDto = new OrderDto();
                orderDto.setId((neededOrders.get(i).getId()));
                orderDto.setDate(neededOrders.get(i).getDate());
                orderDto.setEmployee(neededOrders.get(i).getEmployee());
                orderDto.setSum(neededOrders.get(i).getMedications().stream().count());
                neededOrdersDto.add(orderDto);
            }

            ClientDto clientDto = new ClientDto();
            clientDto.setName(client.getFirstName() + " " + client.getLastName());
            clientDto.setOrders(neededOrdersDto);
            clients.add(clientDto);
        }

        model.addAttribute("clients", clients);
        return "adminMainPage";
    }

    // Создание заказа
    @GetMapping("/userMainPage")
    public String getUserMainPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Client client = userService.getUserByEmail(email);

        List<Order> orders = orderService.getAllByClient(client);
        List<OrderDto> list = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId((orders.get(i).getId()));
            orderDto.setDate(orders.get(i).getDate());
            orderDto.setEmployee(orders.get(i).getEmployee());
            orderDto.setSum(orders.get(i).getMedications().stream().count());
            list.add(orderDto);
        }

        model.addAttribute("orders", list);
        return "userMainPage";
    }

    @GetMapping("/createOrder")
    public String getCreateOrder(Model model) {
        model.addAttribute("medications", medicationService.getAllMedications());
        return "createOrder";
    }

    @ResponseBody
    @RequestMapping(value = "/orderCreated")
    public String getSearchResultViaAjax(@RequestParam(value="array[]") List<String> array)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Client client = userService.getUserByEmail(email);
        OrderDto orderDto = new OrderDto();
        orderDto.setClient(client);
        orderDto.setDate(new Date().toString());
        List <Employee> employees = employeeService.getAllEmployees();
        int random = (int)Math.random() % employees.size();
        orderDto.setEmployee(employees.get(random));

        List<Integer> list = new ArrayList<>();
        for (String i: array) {
            list.add(Integer.parseInt(i));
        }

        orderDto.setArray(list);
        orderService.save(orderDto);

        return "userAdminPage";
    }


}
