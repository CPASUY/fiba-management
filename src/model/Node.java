package model;

import java.util.ArrayList;

public class Node<K extends Comparable <K>,V>  {
	private K key;
	private ArrayList<V> value;
	protected Node<K,V> father;
	protected Node<K,V> left;
	protected Node<K,V> right;
	protected int height;
	private int h1;
	private int h2;
	
	public Node(K k, V v) {
		super();
		key = k;
		value=new ArrayList<V>();
		value.add(v);
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
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public ArrayList<V> getValue() {
		return value;
	}
	public void setValue(ArrayList<V> value) {
		this.value = value;
	}
	public Node<K,V> getMin() {
		Node<K,V> min = this;
		while(min.getLeft()!=null) {
			min=min.getLeft();
		}
		return min;
	}
	public void modifiedNode() {	
		int leftH=0;
		int rightH=0;
		if(left!=null) {
			leftH=left.height;
		}
		if(right!=null) {
			rightH=right.height;
		}
		if(leftH>rightH) {
			height=leftH+1;
		}
		else {
			height=rightH+1;
		}

	}
	public int getBFactor() {
		return h2-h1;
	}
		
}
