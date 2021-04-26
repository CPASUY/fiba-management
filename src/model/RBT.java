package model;

public class RBT<K extends Comparable<K>,V> extends BST<K,V> implements IBST<K,V>,IRBT<K,V>{

	private NodeRBT<K,V> nillNode;
	
	public RBT() {
		super();
		nillNode = new NodeRBT<K,V>(null,null);
		nillNode.setC(0);
		
	}
	public NodeRBT<K,V> rotateRight(NodeRBT<K,V> node) {
		if(node.getLeft() == null) {
			return node;
		} else {
			NodeRBT<K,V> left = (NodeRBT<K,V>)node.getLeft();
			NodeRBT<K,V> parent = (NodeRBT<K,V>)node.getFather();
			if(node != root) {
				if(parent.getLeft() == node) {
					parent.setLeft(left);
				} else {
					parent.setRight(left);
				}	
			} else {
				root = left;
			}			
			node.setFather(left);
			node.setLeft(left.getRight());
			if(left.getRight() != null) {
				left.getRight().setFather(node);
			}
			left.setFather(parent);
			left.setRight(node);
			node.modifiedNode();
			left.modifiedNode();
			if(parent != null) {
				parent.modifiedNode();
			}
			return left;
		}	
	}
	public NodeRBT<K,V> rotateLeft(NodeRBT<K,V> node) {
		if(node.getRight() == null) {
			return node;
		} else {
			NodeRBT<K,V> right = (NodeRBT<K,V>)node.getRight();
			NodeRBT<K,V> parent = (NodeRBT<K,V>)node.getFather();
			if(node != root) {
				if(parent.getRight() == node) {
					parent.setRight(right);
				} else {
					parent.setLeft(right);
				}	
			} else {
				root = right;
			}			
			node.setFather(right);
			node.setRight(right.getLeft());
			if(right.getLeft() != null) {
				right.getLeft().setFather(node);
			}
			right.setFather(parent);
			right.setLeft(node);
			node.modifiedNode();
			right.modifiedNode();
			if(parent != null) {
				parent.modifiedNode();
			}
			return right;
		}	
	}
	public boolean insertNode(K k,V v) {
		boolean add=false;
		NodeRBT<K,V> newNode = new NodeRBT<K,V>(k,v);
		insertE(k,v);
		newNode.setLeft(nillNode);
		newNode.setRight(nillNode);
		if(newNode==root || newNode.getFather()==null) {	
			add=true;
		} else {
			insertF(newNode);					
			add=true;
		}
		return add;
	}
	public void insertF(NodeRBT<K,V> node){
		while(((NodeRBT<K,V>)node.getFather()).getC() == 1) {
			NodeRBT<K,V> uncle;
			if(node.getFather() == node.getFather().getFather().getLeft()) {
				uncle = (NodeRBT<K,V>)node.getFather().getFather().getRight();
				if(uncle.getC() ==1) {
					((NodeRBT<K,V>) node.getFather()).setC(0);
					uncle.setC(0);
					((NodeRBT<K,V>) node.getFather().getFather()).setC(1);
					node = (NodeRBT<K,V>) node.getFather().getFather();

				} else { 
					if(node== node.getFather().getRight()) {
						node= (NodeRBT<K, V>) node.getFather();
						rotateLeft(node);
					}
					((NodeRBT<K, V>) node.getFather()).setC(0);
					((NodeRBT<K,V>) node.getFather().getFather()).setC(1);
					rotateRight((NodeRBT<K, V>) node.getFather().getFather());
				}
			} else {
				uncle = (NodeRBT<K,V>)node.getFather().getFather().getLeft();
				if(uncle.getC() ==1) {
					((NodeRBT<K,V>) node.getFather()).setC(0);
					uncle.setC(0);
					((NodeRBT<K,V>) node.getFather().getFather()).setC(1);
					node= (NodeRBT<K,V>) node.getFather().getFather();
				} else { 
					if(node == node.getFather().getLeft()) {
						node= (NodeRBT<K, V>) node.getFather();
						rotateRight(node);
					}
					((NodeRBT<K, V>) node.getFather()).setC(0);
					((NodeRBT<K,V>) node.getFather().getFather()).setC(1);
					rotateLeft((NodeRBT<K, V>) node.getFather().getFather());
				}
			}
		}
		((NodeRBT<K,V>)root).setC(0);
	}
}
