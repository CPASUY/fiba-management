package model;

public interface IRBT<K extends Comparable<K>,V>extends IBST<K, V>{

	public NodeRBT<K,V> rotateRight(NodeRBT<K,V> node);
	public NodeRBT<K,V> rotateLeft(NodeRBT<K,V> node);
	public boolean insertNode(K k,V v);
	public void insertF(NodeRBT<K,V> node);
}
