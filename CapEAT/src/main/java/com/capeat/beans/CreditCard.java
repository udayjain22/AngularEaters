package com.capeat.beans;

import org.springframework.stereotype.Component;

@Component
public class CreditCard {

	private int amount;
	private String nameOnCard;
	private String cardNum;
	private String exp;
	private int cvc;
	private String zipCode;
	private String decision;
	private int sid;
	private String Status;
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + amount;
		result = prime * result + ((cardNum == null) ? 0 : cardNum.hashCode());
		result = prime * result + cvc;
		result = prime * result + ((decision == null) ? 0 : decision.hashCode());
		result = prime * result + ((exp == null) ? 0 : exp.hashCode());
		result = prime * result + ((nameOnCard == null) ? 0 : nameOnCard.hashCode());
		result = prime * result + sid;
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		CreditCard other = (CreditCard) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (amount != other.amount)
			return false;
		if (cardNum == null) {
			if (other.cardNum != null)
				return false;
		} else if (!cardNum.equals(other.cardNum))
			return false;
		if (cvc != other.cvc)
			return false;
		if (decision == null) {
			if (other.decision != null)
				return false;
		} else if (!decision.equals(other.decision))
			return false;
		if (exp == null) {
			if (other.exp != null)
				return false;
		} else if (!exp.equals(other.exp))
			return false;
		if (nameOnCard == null) {
			if (other.nameOnCard != null)
				return false;
		} else if (!nameOnCard.equals(other.nameOnCard))
			return false;
		if (sid != other.sid)
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CreditCard [amount=" + amount + ", nameOnCard=" + nameOnCard + ", cardNum=" + cardNum + ", exp=" + exp
				+ ", cvc=" + cvc + ", zipCode=" + zipCode + ", decision=" + decision + ", sid=" + sid + ", Status="
				+ Status + "]";
	}
	
	
}