package org.omilab.services.template.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Instance {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String psmip;

	public Instance() {
	}

	public Instance(final String psmip) {
		this.psmip = psmip;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getPsmip() {
		return psmip;
	}

	public void setPsmip(final String psmip) {
		this.psmip = psmip;
	}

}
