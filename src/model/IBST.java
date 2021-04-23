package model;

<<<<<<< HEAD
public interface IBST<K extends Comparable<K>,V extends Comparable <V>> {
=======
public interface IBST<K extends Comparable <K>,V extends Comparable <V>>{
>>>>>>> d90118be5ddbce5f1954e57ee9687429d6e99a9f

	public void insertE(K key, V value);
	public void insertE(Node<K,V>n1,Node<K,V>n2);
	public Node<K,V> getRoot();
	public Node<K,V> searchE(K value);
	public Node<K,V> searchE(Node <K,V> n,K value);
}
