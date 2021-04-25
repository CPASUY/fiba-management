package model;

public interface IAVL<K extends Comparable<K>,V> extends IBST<K, V> {

	public NodeAVL<K,V> rotateL(NodeAVL<K,V> node);
	public NodeAVL<K,V> rotateR(NodeAVL<K,V> node);
	public NodeAVL<K,V> balance (NodeAVL<K,V>node);
	public boolean insert(K key, V value);
}
