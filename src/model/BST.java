package model;

import java.util.ArrayList;

public class BST<K extends Comparable<K>,V> implements IBST<K,V>{
	private int weight;
	ArrayList <Node<K,V>> nodos;
	protected Node<K,V> root;
	
	public BST() {
		weight=0;
		root=null;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setRoot(Node<K,V> root) {
		this.root = root;
	}
	@Override
	public Node<K, V> getRoot() {
		return root;
	}
	@Override
	public void insertE(K key, V value) {
		Node<K,V> newNode = new Node<K,V>(key,value);
		insertE(newNode);
	}
	@Override
	public void insertE(Node<K,V> newNode) {
		if(root != null) {	
			insertE(root,newNode);
		} else {	
			root = newNode;	
		}	
		weight++;
	}	
	@Override
	public void insertE(Node<K,V> root, Node<K,V> newNode){
		if(root.getKey() != null) {
			if(newNode.getKey().compareTo(root.getKey())== 0) {
				root.getValue().add(newNode.getValue().get(0));
			}
		} else if(newNode.getKey().compareTo(root.getKey()) < 0) {
			Node<K,V> left =root.getLeft();
			if(left != null) {	
				insertE(left,newNode);
				left.modifiedNode();	
			} else {		
				root.setLeft(newNode);		
				newNode.setFather(root);
				
			}	
		} else {	
			Node<K,V> right = root.getRight();
			if(right != null) {		
				insertE(right,newNode);
				right.modifiedNode();
			} else {	
				root.setRight(newNode);	
				newNode.setFather(root);
			}		
		}			
	}		
	@Override
	public ArrayList<V> searchEquals(K key) {
		if(root != null) {	
			Node<K,V> node= searchEquals(key,root);
			if(node.getValue()!= null) {
				return node.getValue();	
			} else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	@Override
	public Node<K, V> searchEquals(K key, Node<K, V> n) {
		if(n!= null) {
			if(key.compareTo(n.getKey()) < 0) {	
				return searchEquals(key,n.getLeft());		
			} else if(key.compareTo(n.getKey()) >  0) {	
				return searchEquals(key,n.getRight());
			} else {
				return n;
			}
		} else {	
			return null;
		}		
	}
	@Override
	public void inOrderLess(Node<K,V> node,K key) {
		if (node != null) {
			inOrderLess(node.getRight(),key);
			if(node.getKey().compareTo(key)<=0) {
				nodos.add(node);
			}
			inOrderLess(node.getLeft(),key);
		}
	}
	@Override
	public void inOrderMore(Node<K,V> node,K key) {
		if (node != null) {
			inOrderLess(node.getRight(),key);
			if(node.getKey().compareTo(key)>=0) {
				nodos.add(node);
			}
			inOrderLess(node.getLeft(),key);
		}
	}
	@Override
	public ArrayList<V> indices(){
		ArrayList<V> i=new ArrayList<V>();
		for(int s=0;s<nodos.size();s++) {
			for(int m=0;m<nodos.get(s).getValue().size();m++) {
				i.add(nodos.get(s).getValue().get(m));
			}
		}
		return i;
	}
}
