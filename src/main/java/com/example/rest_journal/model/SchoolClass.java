package com.example.rest_journal.model;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class SchoolClass {
    @Id
    @Column(name = "class_id")
    @SequenceGenerator(name = "classesIdSeq", sequenceName = "classes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classesIdSeq")
    private Integer id;
    @Column(name = "class_name")
    private String className;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
