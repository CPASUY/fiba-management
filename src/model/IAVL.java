package model;

public interface IAVL<K extends Comparable <K>,V extends Comparable <V>> extends IBST<K, V> {

	public void insertE(K key, V value);
	public void rebalance();
	public void leftRotate(Node<K,V> node);
	public void rightRotate(Node<K,V> node);
}
