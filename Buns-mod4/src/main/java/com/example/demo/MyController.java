package java.org.example.demo;

import java.org.example.entity.Employee;
import java.org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = service.getAll();
        model.addAttribute("all", allEmployees);
        return "all_employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_info";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add_info";
        }
        service.save(employee);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = service.getEmployee(id);
        model.addAttribute("employee", employee);
        return "add_info";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam("empId") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
