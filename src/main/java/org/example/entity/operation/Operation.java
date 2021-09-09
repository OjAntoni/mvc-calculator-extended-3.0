package org.example.entity.operation;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.User;
import org.example.entity.number.AbstractNumber;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String num1;
    private String num2;
    private String operationSign;
    private String result;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private Date date;

    public Operation(long id, AbstractNumber num1, AbstractNumber num2, String operationSign, AbstractNumber result, User user) {
        this.id = id;
        this.num1 = num1.toString();
        this.num2 = num2.toString();
        this.operationSign = operationSign;
        this.result = result.toString();
        this.user = user;
    }
}
