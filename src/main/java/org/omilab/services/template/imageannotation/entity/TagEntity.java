package org.omilab.services.template.imageannotation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue
    private int id;
    
    private String tag;
}
