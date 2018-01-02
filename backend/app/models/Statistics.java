package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table
public class Statistics  extends BaseModel{

    @ManyToOne(optional = false)
    public User user;

    @Column(columnDefinition = "integer default 0")
    public int correct;

    @Column(columnDefinition = "integer default 0")
    public int wrong;

    @Column(columnDefinition = "integer default 0")
    public int category;

    public static Finder<Long, Statistics> find = new Finder<>(Statistics.class);
}
