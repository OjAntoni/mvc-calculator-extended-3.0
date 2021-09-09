package org.example.controller;

import org.example.entity.operation.ComplexOperationDto;
import org.example.entity.operation.Operation;
import org.example.entity.User;
import org.example.entity.number.ComplexNumber;
import org.example.entity.number.AbstractNumber;
import org.example.entity.number.SimpleNumber;
import org.example.entity.operation.SimpleOperationDto;
import org.example.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    private final OperationService operationService;

    public CalculatorController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public String getCalculateSimpleNumber(){
        return "calcSimple";
    }

    @PostMapping
    public String postCalculateSimpleNumber(@Valid SimpleOperationDto sod, Model model, HttpSession session){
        System.out.println(sod.num1);
        System.out.println(sod.num2);
        SimpleNumber simpleNumber1 = new SimpleNumber(sod.num1);
        SimpleNumber simpleNumber2 = new SimpleNumber(sod.num2);
        AbstractNumber result = operationService.calculateResult(simpleNumber1, simpleNumber2, sod.operationSign);
        Operation operation = operationService.createInstance(simpleNumber1, simpleNumber2, sod.operationSign, ((User) session.getAttribute("user")));
        operationService.save(operation);
        model.addAttribute("result", result);
        return "calcSimple";
    }

    @GetMapping("/complex")
    public String getCalculateComplexNumber(){
        return "calcComplex";
    }

    @PostMapping("/complex")
    public String postCalculateComplexNumber(@Valid ComplexOperationDto cod, Model model, HttpSession session){
        AbstractNumber z1 = new ComplexNumber(cod.x1, cod.y1);
        AbstractNumber z2 = new ComplexNumber(cod.x2, cod.y2);
        AbstractNumber result = operationService.calculateResult(z1, z2, cod.operationSign);
        model.addAttribute("result", result);
        Operation operation = operationService.createInstance(z1, z2, cod.operationSign, ((User) session.getAttribute("user")));
        operationService.save(operation);
        return "calcComplex";
    }

    @GetMapping("/history")
    public String getHistory(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Operation> all = operationService.getAll(user);
        model.addAttribute("operations", all);
        return "history";
    }

    @PostMapping("/history")
    public String postHistory(long id, Model model, HttpSession session){
        operationService.delete(id);
        model.addAttribute("operations", operationService.getAll(((User) session.getAttribute("user"))));
        return "history";
    }
}
