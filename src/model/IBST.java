package model;

import java.util.ArrayList;

public interface IBST<K extends Comparable<K>,V> {
	public void insertE(K key, V value);
	public void insertE(Node<K,V> n);
	public void insertE(Node<K,V>n1,Node<K,V>n2);
	public Node<K,V> getRoot();
	public ArrayList<V>  searchEquals(K key);
	public ArrayList<V>  searchEquals(K key,Node <K,V> n);
	public ArrayList<V>  searchMore(K key);
	public ArrayList<V>  searchMore(K key,Node <K,V> n);
	public ArrayList<V>  searchLess(K key);
	public ArrayList<V>  searchLess(K key,Node <K,V> n);
	public Node<K,V> getMin(Node<K,V> node);
	public Node<K,V> getMax(Node<K,V> node);
}
