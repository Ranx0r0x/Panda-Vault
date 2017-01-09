package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FamilyId {
	/** The family id associated with the PAN which is composed of the
	 * BIN and the last 4 digits of the PAN. */
	private String id;

	public FamilyId() {}


	public FamilyId(String familyId) {
		super();
		this.id = familyId;
	}
	
	public Boolean equals(FamilyId familyId){
		return familyId!=null&&familyId.getId()!=null&&familyId.getId().equals(this.id);
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "FamilyId [familyId=" + id + "]";
	}
	




}
