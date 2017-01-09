package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WhiteVaultDataModel {

	private Token token;
	private Panda panda;
	private FamilyId familyId;
	

	public WhiteVaultDataModel(){}
	public WhiteVaultDataModel(Token token, Panda panda, FamilyId familyId) {
		super();
		this.token = token;
		this.panda = panda;
		this.familyId=familyId;
	}
	
	public Panda getPanda() {
		return panda;
	}
	public WhiteVaultDataModel setPanda(Panda panda) {
		this.panda = panda;
		return this;
	}
	public Token getToken() {
		return token;
	}
	public WhiteVaultDataModel setToken(Token token) {
		this.token = token;
		return this;
	}

	public FamilyId getFamilyId() {
		return familyId;
	}
	public WhiteVaultDataModel setFamilyId(FamilyId familyId) {
		this.familyId = familyId;
		return this;
	}
}
