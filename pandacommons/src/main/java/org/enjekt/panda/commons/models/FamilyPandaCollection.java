package org.enjekt.panda.commons.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

//TODO These are passing Strings and not Integers and both the token and the
//Panda are Integers.
@XmlRootElement
public class FamilyPandaCollection {
	
	private FamilyId familyId;
	private Map<String,String> tokenToPanda = new HashMap<String,String>();
	

	public FamilyPandaCollection addTokenAndPanda(WhiteVaultDataModel wvdm)
	{
		tokenToPanda.put(wvdm.getToken().getToken(), wvdm.getPanda().getPanda());
		return this;
	}
	public FamilyPandaCollection addTokenAndPanda(Token token, Panda panda)
	{
		tokenToPanda.put(token.getToken(), panda.getPanda());
		return this;
	}
	public FamilyId getFamilyId() {
		return familyId;
	}
	public FamilyPandaCollection setFamilyId(FamilyId familyId) {
		this.familyId = familyId;
		return this;
	}
	public Map<String, String> getTokenToPanda() {
		return tokenToPanda;
	}
	public void setTokenToPanda(Map<String, String> tokenToPanda) {
		this.tokenToPanda = tokenToPanda;
	}
	
}
