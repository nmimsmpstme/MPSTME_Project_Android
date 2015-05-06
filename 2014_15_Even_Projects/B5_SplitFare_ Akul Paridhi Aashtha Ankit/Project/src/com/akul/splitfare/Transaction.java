package com.akul.splitfare;

public class Transaction
{
	public boolean left;
	public String comment;
	public String name;
	public String amt;
	public String id;
	public Transaction(boolean left,String id, String comment , String name , String amt) 
	{
		super();
		this.id =id;
		this.left = left;
		this.comment = comment;
		this.name = name;
		this.amt =amt;
	}
}