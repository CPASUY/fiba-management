package model;

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
			if(newNode.getKey().get(0).compareTo(root.getKey().get(0))== 0) {
				root.getKey().add(newNode.getKey().get(0));
			}
		} else if(newNode.getKey().get(0).compareTo(root.getKey().get(0)) < 0) {
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
