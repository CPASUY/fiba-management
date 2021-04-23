package model;

public interface IBST<K extends Comparable <K>,V extends Comparable <V>>{

	public void insertE(K key, V value);
	public void insertE(Node<K,V>n1,Node<K,V>n2);
	public Node<K,V> getRoot();
	public Node<K,V> searchE(V value);
	public Node<K,V> searchE(Node <K,V> n,V value);
}
