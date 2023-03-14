package com.abdi.spring_mvc_hibernate.controller;


import com.abdi.spring_mvc_hibernate.dao.EmployeeDAO;
import com.abdi.spring_mvc_hibernate.dao.EmployeeDAOImpl;
import com.abdi.spring_mvc_hibernate.entity.Employee;
import com.abdi.spring_mvc_hibernate.service.EmployeeService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String showAllEmps(Model model){
        List<Employee> allEmployees =  employeeService.getAllEmployee();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "add-employee";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);


        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
