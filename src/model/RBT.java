package model;

public class RBT<K extends Comparable<K>,V> extends BST<K,V> implements IBST<K,V> {

	private NodeRBT<K,V> nillNode;
	
	public RBT() {
		super();
		nillNode = new NodeRBT<K,V>(null,null);
		nillNode.setC(ColorNode.BLACK);
		
	}
	public boolean insertNode(K k,V v) {
		boolean add=false;
		NodeRBT<K,V> newNode = new NodeRBT<K,V>(k,v);
		insertE(k,v);
		newNode.setLeft(nillNode);
		newNode.setRight(nillNode);
		if(newNode==root || newNode.getFather()==null) {	
			add=true;
		} else {
			addFixUp(newNode);					
			add=true;
		}
		return add;
	}
}
