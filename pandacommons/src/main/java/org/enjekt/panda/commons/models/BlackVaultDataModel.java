package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BlackVaultDataModel {

	private Token token;
	private Pad pad;
	private FamilyId familyId;
	

	public BlackVaultDataModel(){}
	public BlackVaultDataModel(Token token, Pad pad, FamilyId familyId) {
		super();
		this.token = token;
		this.pad = pad;
		this.familyId=familyId;
	}
	
	public Token getToken() {
		return token;
	}
	public BlackVaultDataModel setToken(Token token) {
		this.token = token;
		return this;
	}
	public Pad getPad() {
		return pad;
	}
	public BlackVaultDataModel setPad(Pad pad) {
		this.pad = pad;
		return this;
	}
	public FamilyId getFamilyId() {
		return familyId;
	}
	public BlackVaultDataModel setFamilyId(FamilyId familyId) {
		this.familyId = familyId;
		return this;
	}
}
