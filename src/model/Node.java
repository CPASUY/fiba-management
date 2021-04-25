package model;

import java.util.ArrayList;

public class Node<K extends Comparable <K>,V>  {
	private ArrayList<K> key;
	private V value;
	private Node<K,V> father;
	private Node<K,V> left;
	private Node<K,V> right;
	private int height;
	private int h1;
	private int h2;
	
	public Node(K k, V v) {
		super();
		key = new ArrayList<K>();
		key.add(k);
		value=v;
		height = 1;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
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
	public ArrayList<K> getKey() {
		return key;
	}
	public void setKey(ArrayList<K> key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Node<K,V> getMin() {
		Node<K,V> min = this;
		while(min.getLeft()!=null) {
			min=min.getLeft();
		}
		return min;
	}
	public void updateNode() {	
		int lh =  left != null? left.height:0;
		int rh =  right != null? right.height:0;
		height = ((lh > rh)? lh : rh) + 1;

	}
	public int getBFactor() {
		return h2-h1;
	}
		
}
