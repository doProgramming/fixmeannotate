package org.omilab.services.template.imageannotation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ImageTO {

    private int id;
    private String image;
    private String tag;
}
