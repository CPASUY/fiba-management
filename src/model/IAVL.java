package model;

<<<<<<< HEAD
public interface IAVL<K extends Comparable<K>,V extends Comparable <V>> extends IBST<K, V> {
=======

public interface IAVL<K extends Comparable <K>,V extends Comparable <V>> extends IBST<K, V> {
>>>>>>> 1c9aaa4f4d9496e0ae59a2f7ccfbcf760c65b7ed

	public void insertE(K key, V value);
	public void rebalance();
	public void leftRotate(Node<K,V> node);
	public void rightRotate(Node<K,V> node);
}
