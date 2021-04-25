package model;

<<<<<<< HEAD
public class BST<K extends Comparable<K>,V> implements IBST<K,V>{
	private int weight;
	private Node<K,V> root;
=======

public class BST<K extends Comparable<K>,V extends Comparable <V>> implements IBST<K,V>{
	
	Node<K,V> root;
>>>>>>> 1c9aaa4f4d9496e0ae59a2f7ccfbcf760c65b7ed
	
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
	public Node<K,V> searchE(K value) {
		if(root==null) {
			return null;
		}else {
			return searchE(root,value);
		}
	}
	@Override
	public Node<K,V> searchE(Node<K,V> root,K value){
		if(root.getValor().compareTo(value)==0) {
			return root;
		}else if(root.getValor().compareTo(value)>0) {
			return searchE(root.getLeft(),value);
		}else {
			return searchE(root.getRight(),value);
		}
	}

}
