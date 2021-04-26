package model;

public class NodeRBT<K extends Comparable <K>,V> extends Node<K,V> {

	public final static int RED=1;
	public final static int BLACK=0;
	
	public int c;
	
	public NodeRBT(K k, V v) {
		super(k, v);
		c=1;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}


}
