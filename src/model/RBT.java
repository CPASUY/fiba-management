package model;

public class RBT<K extends Comparable<K>,V> extends BST<K,V> implements IBST<K,V> {

	private NodeRBT<K,V> nillNode;
	
	public RBT() {
		super();
		nillNode = new NodeRBT<K,V>(null,null);
		nillNode.setC(ColorNode.BLACK);
		
	}
	private NodeRBT<K,V> rotateRight(NodeRBT<K,V> node) {
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
			node.updateNode();
			left.updateNode();
			if(parent != null) {
				parent.updateNode();
			}
			return left;
		}	
	}
	private NodeRBT<K,V> rotateLeft(NodeRBT<K,V> node) {
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
			node.updateNode();
			right.updateNode();
			if(parent != null) {
				parent.updateNode();
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
			addFixUp(newNode);					
			add=true;
		}
		return add;
	}
	public void addFixUp(NodeRBT<K,V> z){
		while(((NodeRBT<K,V>)z.getFather()).getC() == ColorNode.RED) {
			NodeRBT<K,V> uncle;
			if(z.getFather() == z.getFather().getFather().getLeft()) {
				uncle = (NodeRBT<K,V>)z.getFather().getFather().getRight();
				if(uncle.getC() == ColorNode.RED) {
					((NodeRBT<K,V>) z.getFather()).setC(ColorNode.BLACK);
					uncle.setC(ColorNode.BLACK);
					((NodeRBT<K,V>) z.getFather().getFather()).setC(ColorNode.RED);
					z = (NodeRBT<K,V>) z.getFather().getFather();

				} else { 
					if(z == z.getFather().getRight()) {
						z = (NodeRBT<K, V>) z.getFather();
						rotateLeft(z);
					}
					((NodeRBT<K, V>) z.getFather()).setC(ColorNode.BLACK);
					((NodeRBT<K,V>) z.getFather().getFather()).setC(ColorNode.RED);
					rotateRight((NodeRBT<K, V>) z.getFather().getFather());
				}
			} else {
				uncle = (NodeRBT<K,V>)z.getFather().getFather().getLeft();
				if(uncle.getC() == ColorNode.RED) {
					((NodeRBT<K,V>) z.getFather()).setC(ColorNode.BLACK);
					uncle.setC(ColorNode.BLACK);
					((NodeRBT<K,V>) z.getFather().getFather()).setC(ColorNode.RED);
					z = (NodeRBT<K,V>) z.getFather().getFather();
				} else { 
					if(z == z.getFather().getLeft()) {
						z = (NodeRBT<K, V>) z.getFather();
						rotateRight(z);
					}
					((NodeRBT<K, V>) z.getFather()).setC(ColorNode.BLACK);
					((NodeRBT<K,V>) z.getFather().getFather()).setC(ColorNode.RED);
					rotateLeft((NodeRBT<K, V>) z.getFather().getFather());
				}
			}
		}
		((NodeRBT<K,V>)root).setC(ColorNode.BLACK);
	}
}
