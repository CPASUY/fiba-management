package model;

public class Node<K,V extends Comparable <V>> {
	K indice;
	V valor;
	Node<K,V> father;
	Node<K,V> left;
	Node<K,V> right;
	private int h1;
	private int h2;
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
	public int getH1() {
		return h1;
	}
	public void setH1(int h1) {
		this.h1 = h1;
	}
	public int getH2() {
		return h2;
	}
	public void setH2(int h2) {
		this.h2 = h2;
	}
	public int getH() {
		return h1>h2? h1:h2;
	}
	public Node<K,V> getMin() {
		Node<K,V> min = this;
		while(min.getLeft()!=null) {
				min=min.getLeft();
		}
		return min;
	}
	public int getBFactor() {
		return h2-h1;
	}
}
