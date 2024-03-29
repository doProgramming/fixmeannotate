package org.omilab.services.template.imageannotation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Image {

    private int id;
    private String imageByte;
    private Tag tag;
}
