package com.dastamn.antlrcompiler.entities;

public class QuadRiles {
	private String operator;
	private String leftOperand;
	private String rightOperand;
	private String affect;
	
	public QuadRiles(String operator, String leftOperand, String rightOperand, String affect) {
		this.operator 		= operator;
		this.leftOperand 	= leftOperand;
		this.rightOperand 	= rightOperand;
		this.affect 		= affect;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(String leftOperand) {
		this.leftOperand = leftOperand;
	}

	public String getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(String rightOperand) {
		this.rightOperand = rightOperand;
	}

	public String getAffect() {
		return affect;
	}

	public void setAffect(String affect) {
		this.affect = affect;
	}
	public String toString() {
		return "( " + this.operator + ", " + this.leftOperand + ", " + this.rightOperand + ", " + this.affect + ")";
	}
	
}
