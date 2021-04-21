package model;

public class BST<K,V extends Comparable <V>> implements IBST<K,V>{
	
	Node<K,V> root;
	
	@Override
	public void insertE(K key, V value) {
		Node<K,V> node= new Node<K,V>(key,value);
		if(root== null) {
			root = node;
		}else {
			insertE(root,node);
		}
	}
	@Override
	public void insertE(Node<K,V> root,Node<K,V> newNode) {
		if(newNode.getValor().compareTo(root.getValor())<=0	&&	root.getLeft()==null) {
			root.setLeft(newNode);
			newNode.setFather(root);
		}else if(newNode.getValor().compareTo(root.getValor())>0 && root.getRight()==null) {
			root.setRight(newNode);
			newNode.setFather(root);
		}else {
			if(newNode.getValor().compareTo(root.getValor())<=0 && root.getLeft()!= null) {
				insertE(root.getLeft(),newNode);
			}else {
				insertE(root.getRight(),newNode);
			}
		}
	}

	@Override
	public Node<K, V> getRoot() {
		return root;
	}

	@Override
	public Node<K,V> searchE(V value) {
		if(root==null) {
			return null;
		}else {
			return searchE(root,value);
		}
	}
	@Override
	public Node<K,V> searchE(Node<K,V> root,V value){
		if(root.getValor().compareTo(value)==0) {
			return root;
		}else if(root.getValor().compareTo(value)>0) {
			return searchE(root.getLeft(),value);
		}else {
			return searchE(root.getRight(),value);
		}
	}

}
