package com.hansixue.tracker.luggage;

import java.util.Date;

public class Luggage {

    private int id;
    private int tagNumber;
    private int amount;
    private Date keptTime;
    private int keptStuffId;
    private Date pickupTime;
    private Date pickedUpTime;
    private int passedByStuffId;
    
    
	public Luggage(int id, int tagNumber, int amount, Date keptTime, int keptStuffId) {
		super();
		this.id = id;
		this.tagNumber = tagNumber;
		this.amount = amount;
		this.keptTime = keptTime;
		this.keptStuffId = keptStuffId;
	}


	public Luggage(int tagNumber, int amount, Date keptTime, int keptStuffId) {
		super();
		this.tagNumber = tagNumber;
		this.amount = amount;
		this.keptTime = keptTime;
		this.keptStuffId = keptStuffId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTagNumber() {
		return tagNumber;
	}


	public void setTagNumber(int tagNumber) {
		this.tagNumber = tagNumber;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getKeptTime() {
		return keptTime;
	}


	public void setKeptTime(Date keptTime) {
		this.keptTime = keptTime;
	}


	public int getKeptStuffId() {
		return keptStuffId;
	}


	public void setKeptStuffId(int keptStuffId) {
		this.keptStuffId = keptStuffId;
	}


	public Date getPickupTime() {
		return pickupTime;
	}


	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}


	public Date getPickedUpTime() {
		return pickedUpTime;
	}


	public void setPickedUpTime(Date pickedUpTime) {
		this.pickedUpTime = pickedUpTime;
	}


	public int getPassedByStuffId() {
		return passedByStuffId;
	}


	public void setPassedByStuffId(int passedByStuffId) {
		this.passedByStuffId = passedByStuffId;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
