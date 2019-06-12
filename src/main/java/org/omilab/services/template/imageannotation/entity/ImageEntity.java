package org.omilab.services.template.imageannotation.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Data
public class ImageEntity {

    @Id
    private int id;

    private String tag;

    private byte[] image;
}
