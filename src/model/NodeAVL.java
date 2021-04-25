package model;

public class NodeAVL<K extends Comparable<K>, V> extends Node<K, V>  {

	private int balanceF;	
	public NodeAVL(K k, V v) {
		super(k, v);
		balanceF = 0;	
	}
	public void modifiedNodeAVL() {	
		int leftH=0;
		int rightH=0;
		if(left!=null) {
			leftH=left.height;
		}
		if(right!=null) {
			rightH=right.height;
		}
		if(leftH>rightH) {
			height=leftH+1;
		}
		else {
			height=rightH+1;
		}
		balanceF = rightH-leftH;	
	}
	public int getBalanceF() {
		return balanceF;
	}
	public void setBalanceF(int balanceF) {
		this.balanceF = balanceF;
	}

}
