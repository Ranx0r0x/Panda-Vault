package org.enjekt.panda.commons.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class FamilyPadCollection {
	
	private FamilyId familyId;
	private Map<String,String> tokenToPadMap = new HashMap<String,String>();
	
	public void addTokenAndPad(Token token, Pad pad)
	{
		tokenToPadMap.put(token.getToken(), pad.getPad());
	}
	public FamilyId getFamilyId() {
		return familyId;
	}
	public FamilyPadCollection setFamilyId(FamilyId familyId) {
		this.familyId = familyId;
		return this;
	}
	public Map<String, String> getTokenToPadMap() {
		return tokenToPadMap;
	}
	public void setTokenToPadMap(Map<String, String> tokenToPadMap) {
		this.tokenToPadMap = tokenToPadMap;
	}

}
