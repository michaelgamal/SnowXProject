package com.servicenow.entities;

import java.awt.Point;



public class TargetItem {
	
	
	
	private double accuracy;
	
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;
	private String itemtype;
	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public TargetItem(double accuracy ) {
		this.accuracy = accuracy;
	}

	public void setTopPoints( Point topLeft, Point topRight ) {
		this.topLeft = topLeft;
		this.topRight = topRight;
	}
	
	public void setBottomPoints( Point bottomLeft, Point bottomRight ) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
	
	
	
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public Point[] getTopPoints() {
		return new Point[] { topLeft, topRight };
	}

	
	public Point[] getBottomPoints() {
		return new Point[] { bottomLeft, bottomRight };
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int simplePercent = (int)(getAccuracy() * 100);
	
		
		sb.append("I am "+simplePercent +"% "+ "sure that there is a ");
		sb.append(itemtype);	
		sb.append(" in the area between points [ " );	
		sb.append( getPointDisplay(topLeft) + ", ");
		sb.append( getPointDisplay(topRight) + ", " );
		sb.append( getPointDisplay(bottomLeft) + ", ");
		sb.append( getPointDisplay(bottomRight) + " ]");
		
		return sb.toString();
	}
	
	private String getPointDisplay( Point point ) {
		int x = (int)point.getX();
		int y  = (int)point.getY();
		return "(" + x + "," + y + ")";
	}
	
	
	
}
