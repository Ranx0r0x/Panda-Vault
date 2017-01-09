package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pad {


	private String pad;
	
	public Pad(){}
	public Pad(String pad) {
		this.pad=pad;
	}
	
	public String getPad() {
		return pad;
	}
	public void setPad(String pad) {
		this.pad = pad;
	}

	public Boolean equals(Pad pad){
		return pad!=null&&pad.getPad()!=null&&pad.getPad().equals(this.pad);
	}
	@Override
	public String toString() {
		return "Pad [pad=" + pad + "]";
	}

}
