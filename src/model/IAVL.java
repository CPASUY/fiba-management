package model;

<<<<<<< HEAD
public interface IAVL<K extends Comparable<K>,V extends Comparable <V>> extends IBST<K, V> {
=======
public interface IAVL<K extends Comparable <K>,V extends Comparable <V>> extends IBST<K, V> {
>>>>>>> d90118be5ddbce5f1954e57ee9687429d6e99a9f

	public void insertE(K key, V value);
	public void rebalance();
	public void leftRotate(Node<K,V> node);
	public void rightRotate(Node<K,V> node);
}
