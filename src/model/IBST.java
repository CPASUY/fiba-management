package model;

import java.util.ArrayList;

public interface IBST<K extends Comparable<K>,V> {
	public void insertE(K key, V value);
	public void insertE(Node<K,V> n);
	public void insertE(Node<K,V>n1,Node<K,V>n2);
	public Node<K,V> getRoot();
	public ArrayList<V>  searchEquals(K key);
	public Node<K,V>  searchEquals(K key,Node <K,V> n);
	public void inOrderLess(Node <K,V> node,K key);
	public void inOrderMore(Node <K,V> node,K key);
}
