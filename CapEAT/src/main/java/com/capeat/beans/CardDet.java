package com.capeat.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class CardDet {

	private int cardid;
	private String nameoncard;
	private String cardnumber;
	private String cardtype;
	private String cardexpiredt;
	private String cardcvv;
	private String zipcode;
	private String Status;
	private int sid;
	
	public CardDet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardDet(int cardid, String nameoncard, String cardnumber, String cardtype, String cardexpiredt,
			String cardcvv, String zipcode, String status, int sid) {
		super();
		this.cardid = cardid;
		this.nameoncard = nameoncard;
		this.cardnumber = cardnumber;
		this.cardtype = cardtype;
		this.cardexpiredt = cardexpiredt;
		this.cardcvv = cardcvv;
		this.zipcode = zipcode;
		Status = status;
		this.sid = sid;
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardexpiredt() {
		return cardexpiredt;
	}

	public void setCardexpiredt(String cardexpiredt) {
		this.cardexpiredt = cardexpiredt;
	}

	public String getCardcvv() {
		return cardcvv;
	}

	public void setCardcvv(String cardcvv) {
		this.cardcvv = cardcvv;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((cardcvv == null) ? 0 : cardcvv.hashCode());
		result = prime * result + ((cardexpiredt == null) ? 0 : cardexpiredt.hashCode());
		result = prime * result + cardid;
		result = prime * result + ((cardnumber == null) ? 0 : cardnumber.hashCode());
		result = prime * result + ((cardtype == null) ? 0 : cardtype.hashCode());
		result = prime * result + ((nameoncard == null) ? 0 : nameoncard.hashCode());
		result = prime * result + sid;
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardDet other = (CardDet) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (cardcvv == null) {
			if (other.cardcvv != null)
				return false;
		} else if (!cardcvv.equals(other.cardcvv))
			return false;
		if (cardexpiredt == null) {
			if (other.cardexpiredt != null)
				return false;
		} else if (!cardexpiredt.equals(other.cardexpiredt))
			return false;
		if (cardid != other.cardid)
			return false;
		if (cardnumber == null) {
			if (other.cardnumber != null)
				return false;
		} else if (!cardnumber.equals(other.cardnumber))
			return false;
		if (cardtype == null) {
			if (other.cardtype != null)
				return false;
		} else if (!cardtype.equals(other.cardtype))
			return false;
		if (nameoncard == null) {
			if (other.nameoncard != null)
				return false;
		} else if (!nameoncard.equals(other.nameoncard))
			return false;
		if (sid != other.sid)
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardDet [cardid=" + cardid + ", nameoncard=" + nameoncard + ", cardnumber=" + cardnumber + ", cardtype="
				+ cardtype + ", cardexpiredt=" + cardexpiredt + ", cardcvv=" + cardcvv + ", zipcode=" + zipcode
				+ ", Status=" + Status + ", sid=" + sid + "]";
	}
	
	
}