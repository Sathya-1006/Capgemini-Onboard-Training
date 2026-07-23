package org.examples;

import jakarta.persistence.*;


@Entity
@Table(name = "studentrecords")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roll;
	private String name;
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "card_id")
	private IdCard IdCard; //one student will have only one id card -> so one to one relationship

	public Student() {
		
	}
	
	public Student(String name, org.examples.IdCard idCard) {
		super();
		
		this.name = name;
		IdCard = idCard;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IdCard getIdCard() {
		return IdCard;
	}

	public void setIdCard(IdCard idCard) {
		IdCard = idCard;
	}
	
	

}

@Entity
@Table(name = "card_id")
class IdCard{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	private String cardNumber;
	
	
	public IdCard() {
	
	}



	public IdCard(String cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}

	

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	
	
	
}