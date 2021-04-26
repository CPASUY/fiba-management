package model;

public class AVL<K extends Comparable<K>,V> extends BST<K,V> implements IBST<K,V>,IAVL<K,V> {

	public AVL() {
		super();
	}
	@Override
	public NodeAVL<K,V> rotateL(NodeAVL<K,V> node) {
		if(node.getRight()==null) {
			return node;
		} else {
			NodeAVL<K,V> right = (NodeAVL<K, V>) node.getRight();
			NodeAVL<K,V> father= (NodeAVL<K, V>) node.getFather();
			if(node != root) {
				if(father.getRight() == node) {
					father.setRight(right);
				} else {
					father.setLeft(right);
				}	
			} else {
				root = right;
			}		
			node.setFather(right);
			node.setRight(right.getLeft());
			if(right.getLeft() != null) {
				right.getLeft().setFather(node);
			}		
			right.setFather(father);
			right.setLeft(node);
			node.modifiedNodeAVL();
			right.modifiedNodeAVL();
			if(father != null) {
				father.modifiedNodeAVL();
			}
			return right;
		}	

	}
	@Override
	public NodeAVL<K,V> rotateR(NodeAVL<K,V> node) {
		if(node.getLeft() == null) {
			return node;
		} else {
			NodeAVL<K,V> left = (NodeAVL<K,V>)node.getLeft();
			NodeAVL<K,V> father = (NodeAVL<K,V>)node.getFather();
			if(node != root) {
				if(father.getLeft() == node) {
					father.setLeft(left);
				} else {
					father.setRight(left);
				}	
			} else {
				root = left;
			}			
			node.setFather(left);
			node.setLeft(left.getRight());
			if(left.getRight() != null) {
				left.getRight().setFather(node);
			}
			left.setFather(father);
			left.setRight(node);
			node.modifiedNodeAVL();
			left.modifiedNodeAVL();
			if(father != null) {
				father.modifiedNodeAVL();	
			}
			return left;
		}	
	}
	@Override
	public NodeAVL<K,V> balance(NodeAVL<K,V>node){
		int nodeBalanceF = node.getBalanceF();
		if(Math.abs(nodeBalanceF) > 1 ) {
			if(nodeBalanceF > 1 && node.getRight() != null) {
				NodeAVL<K,V> right =  (NodeAVL<K,V>) node.getRight();
				if(right.getBalanceF() < 0) {
					rotateR(right);
				}
				return rotateL(node);
			} else if(nodeBalanceF < -1 && node.getLeft() != null){
				NodeAVL<K,V> left =  (NodeAVL<K,V>) node.getLeft();
				if(left.getBalanceF() >= 0) {
					rotateL(left);
				}
				return rotateR(node);
			} else {
				return node;
			}
		} else {
			return node;
		}
	}
	@Override
	public boolean insert(K key, V value) {
		NodeAVL<K,V> addedNode = new NodeAVL<>(key,value);
		insertE(addedNode);					
		if(addedNode == root || addedNode.getFather() == null) {
			return true;			
		} else {
			NodeAVL<K,V> currentNode = (NodeAVL<K,V>)addedNode.getFather();
			while(currentNode != null) {
				currentNode.modifiedNodeAVL();
				balance(currentNode);	
				currentNode = (NodeAVL<K, V>) currentNode.getFather();
			}					
			return true;			
		}		
	}
}
