package org.omilab.services.template.imageannotation.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Data
public class ImageEntity {

    @Id
    @GeneratedValue
    private int id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tagId")
    private TagEntity tag;

    private byte[] image;
}
