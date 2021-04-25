package model;

public class NodeRBT<K extends Comparable <K>,V> extends Node<K,V> {

	private ColorNode c;
	
	public NodeRBT(K k, V v) {
		super(k, v);
		c=ColorNode.RED;
	}

	public ColorNode getC() {
		return c;
	}

	public void setC(ColorNode c) {
		this.c = c;
	}

}
