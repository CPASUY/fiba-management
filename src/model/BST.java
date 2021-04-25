package model;

import java.util.ArrayList;

public class BST<K extends Comparable<K>,V> implements IBST<K,V>{
	private int weight;
	private Node<K,V> root;
	
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
				left.updateNode();	
			} else {		
				root.setLeft(newNode);		
				newNode.setFather(root);
				
			}	
		} else {	
			Node<K,V> right = root.getRight();
			if(right != null) {		
				insertE(right,newNode);
				right.updateNode();
			} else {	
				root.setRight(newNode);	
				newNode.setFather(root);
			}		
		}			
	}		
	@Override
	public Node<K,V> getMin(Node<K,V> node){
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;	
	}
	@Override
	public Node<K,V> getMax(Node<K,V> node){
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return node;	
	}
	@Override
	public ArrayList<V> searchEquals(K key) {
		ArrayList<V> indices=new ArrayList<V>();
		if(root != null) {	
			 indices = searchEquals(key,root);
			if(indices!= null) {
				return indices;	
			} else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	@Override
	public ArrayList<V> searchEquals( K key,Node<K, V> root) {
		if(root != null) {
			if(key.compareTo(root.getKey()) < 0) {	
				return searchEquals(key, root.getLeft());		
			} else if(key.compareTo(root.getKey()) >  0) {	
				return searchEquals(key,root.getRight());
			} else {
				return root.getValue();
			}
		} else {	

			return null;
		}		
	}
	@Override
	public ArrayList<V> searchMore(K key) {
		ArrayList<V> indices=new ArrayList<V>();
		if(root != null) {	
			 indices = searchMore(key,root);
			if(indices!= null) {
				return indices;	
			} else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	@Override
	public ArrayList<V> searchMore(K key, Node<K, V> n) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<V> searchLess(K key) {
		ArrayList<V> indices=new ArrayList<V>();
		if(root != null) {	
			 indices = searchLess(key,root);
			if(indices!= null) {
				return indices;	
			} else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	@Override
	public ArrayList<V> searchLess(K key, Node<K, V> n) {
		// TODO Auto-generated method stub
		return null;
	}
}
