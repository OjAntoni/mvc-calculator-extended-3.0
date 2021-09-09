package org.example.entity.number;

import javax.persistence.*;

public abstract class AbstractNumber {

    public abstract AbstractNumber sum(AbstractNumber number);
    public abstract AbstractNumber sub(AbstractNumber number);
    public abstract AbstractNumber div(AbstractNumber number);
    public abstract AbstractNumber mult(AbstractNumber number);

}
