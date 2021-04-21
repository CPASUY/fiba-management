package model;

public class Node<K,V extends Comparable <V>> {
	K indice;
	V valor;
	Node<K,V> father;
	Node<K,V> left;
	Node<K,V> right;
	public Node<K, V> getFather() {
		return father;
	}
	public void setFather(Node<K, V> father) {
		this.father = father;
	}
	public Node<K, V> getLeft() {
		return left;
	}
	public void setLeft(Node<K, V> left) {
		this.left = left;
	}
	public Node<K, V> getRight() {
		return right;
	}
	public void setRight(Node<K, V> right) {
		this.right = right;
	}
	public Node(K indice, V valor) {
		this.indice = indice;
		this.valor = valor;
	}
	public K getIndice() {
		return indice;
	}
	public void setIndice(K indice) {
		this.indice = indice;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	
}
