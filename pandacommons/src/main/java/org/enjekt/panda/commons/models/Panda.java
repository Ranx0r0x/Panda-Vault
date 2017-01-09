package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Panda {


	private String panda;
	
	public Panda(){}
	public Panda(String panda) {
		this.panda=panda;
	}
	
	public String getPanda() {
		return panda;
	}
	public void setPanda(String panda) {
		this.panda = panda;
	}

	public Boolean equals(Panda panda){
		return panda!=null&&panda.getPanda()!=null&&panda.getPanda().equals(this.panda);
	}
	@Override
	public String toString() {
		return "Panda [panda=" + panda + "]";
	}

}
