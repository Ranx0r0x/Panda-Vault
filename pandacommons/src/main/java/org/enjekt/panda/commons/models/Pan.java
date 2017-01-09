package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pan {

	private String pan;
	public Pan(){}
	public Pan(String pan) {
		this.pan=pan;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	public Boolean equals(Pan pan){
		return pan!=null&&pan.getPan()!=null&&pan.getPan().equals(this.pan);
	}
	@Override
	public String toString() {
		return "Pan [pan=" + pan + "]";
	}
}
