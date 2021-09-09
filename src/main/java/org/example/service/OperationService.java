package org.example.service;

import org.example.entity.operation.Operation;
import org.example.entity.User;
import org.example.entity.number.AbstractNumber;
import org.example.storage.OperationDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
public class OperationService {
    private final OperationDao operationDao;

    public OperationService(@Qualifier("hibernateOperationDao") OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public Operation createInstance(AbstractNumber num1, AbstractNumber num2, String operationSign, User user){
        AbstractNumber result = calculateResult(num1, num2, operationSign);
        Operation operation = new Operation(0, num1, num2, operationSign, result, user);
        operation.setDate(new Date());
        return operation;
    }

    public AbstractNumber calculateResult(AbstractNumber num1, AbstractNumber num2, String operationSign){
        return switch(operationSign){
            case "sum" -> num1.sum(num2);
            case "sub" -> num1.sub(num2);
            case "mult" -> num1.mult(num2);
            case "div" -> num1.div(num2);
            default -> throw new IllegalStateException("Unexpected value: " + operationSign);
        };
    }

    public void save(Operation operation){
        operationDao.add(operation);
    }

    public List<Operation> getAll(User user){
        if (user==null){
            return List.of();
        }
        return operationDao.getAll(user);
    }

    public void delete(long id){
        operationDao.delete(id);
    }

}
