package org.omilab.services.template.imageannotation.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tag")
public class TagEntity {
    @Id
    private int id;
}
