package com.inf_loop_dev.center.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="test2")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String title;
    public String contents;
}
