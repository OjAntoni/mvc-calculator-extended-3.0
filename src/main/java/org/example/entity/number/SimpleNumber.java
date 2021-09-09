package org.example.entity.number;

import lombok.NoArgsConstructor;

import javax.persistence.*;

public class SimpleNumber extends AbstractNumber {
    public double value;

    public SimpleNumber(double value) {
        this.value = value;
    }

    @Override
    public AbstractNumber sum(AbstractNumber number) {
        classCheck(number);
        SimpleNumber simpleNumber = (SimpleNumber) number;
        return new SimpleNumber(value+simpleNumber.value);
    }

    @Override
    public AbstractNumber sub(AbstractNumber number) {
        classCheck(number);
        SimpleNumber simpleNumber = (SimpleNumber) number;
        return new SimpleNumber(value-simpleNumber.value);
    }

    @Override
    public AbstractNumber div(AbstractNumber number) {
        classCheck(number);
        SimpleNumber simpleNumber = (SimpleNumber) number;
        return new SimpleNumber(value/simpleNumber.value);
    }

    @Override
    public AbstractNumber mult(AbstractNumber number) {
        classCheck(number);
        SimpleNumber simpleNumber = (SimpleNumber) number;
        return new SimpleNumber(value*simpleNumber.value);
    }

    private void classCheck(AbstractNumber number){
        if(!(number instanceof SimpleNumber)){
            throw new ArithmeticException(number.getClass()+" and "+this.getClass()+" aren't compatible");
        }
    }

    @Override
    public String toString() {
        return this.value+"";
    }

}
