package org.example.entity.number;

import lombok.NoArgsConstructor;

import javax.persistence.*;

public class ComplexNumber extends AbstractNumber {

    public double x;
    public double y;

    public ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public AbstractNumber sum(AbstractNumber number) {
        classCheck(number);
        ComplexNumber complexNumber = (ComplexNumber) number;
        double xNew = this.x+complexNumber.x;
        double yNew = this.y+complexNumber.y;
        return new ComplexNumber(xNew, yNew);
    }

    @Override
    public AbstractNumber sub(AbstractNumber number) {
        classCheck(number);
        ComplexNumber complexNumber = (ComplexNumber) number;
        double xNew = this.x-complexNumber.x;
        double yNew = this.y-complexNumber.y;
        return new ComplexNumber(xNew, yNew);
    }

    @Override
    public AbstractNumber div(AbstractNumber number) {
        classCheck(number);
        ComplexNumber complexNumber = (ComplexNumber) number;
        double denominator = Math.pow(complexNumber.x,2) + Math.pow(complexNumber.y,2);
        if(denominator==0.0) throw new ArithmeticException();
        double xNew = (this.x*complexNumber.x+this.y*complexNumber.y)/denominator;
        double yNew = (complexNumber.x*this.y - this.x*complexNumber.y)/denominator;
        return new ComplexNumber(xNew, yNew);
    }

    @Override
    public AbstractNumber mult(AbstractNumber number) {
        classCheck(number);
        ComplexNumber complexNumber = (ComplexNumber) number;
        double xNew = this.x*complexNumber.x - this.y*complexNumber.y;
        double yNew = this.x*complexNumber.y + complexNumber.x*this.y;
        return new ComplexNumber(xNew, yNew);
    }

    private void classCheck(AbstractNumber number){
        if(!(number instanceof ComplexNumber)){
            throw new ArithmeticException(number.getClass()+" and "+this.getClass()+" aren't compatible");
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", this.x, this.y);
    }

}
