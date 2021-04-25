package model;
public class AVL<K extends Comparable <K>,V> extends BST<K,V> implements IAVL<K,V> {
	public AVL() {
		super();
	}
	
	@Override
	public void insertE(K key, V value) {
		Node<K, V> element = new Node<K, V>(key, value);

		Node<K, V> current = getRoot();

		if (getRoot() == null) {
			setRoot(element);
		} else {

			boolean added = false;
			while (!added) {

				if (current.getIndice().compareTo(element.getIndice()) > 0) {
					if (current.getLeft() == null) {
						current.setLeft(element);
						element.setFather(current);
						added = true;
					} else {
						current = current.getLeft();
					}
				} else {
					if (current.getRight() == null) {
						current.setRight(element);
						element.setFather(current);
						added = true;
					} else {
						current = current.getRight();
					}
				}
			}
		}
		refreshHeights(element.getFather());
	}
	
	@Override
	public void rebalance() {
		rebalance(getRoot());
	}

	private void rebalance(Node<K,V> node) {
		if(node.getBFactor()==-2) {
			Node<K,V> left = node.getLeft();
			if(left.getBFactor()!=2 && left.getBFactor()!=-2) {
				rightRotate(node);
			}else {
				rebalance(left);
			}
		}else if (node.getBFactor()==2){
			Node<K,V> right = node.getRight();
			if(right.getBFactor()!=2 && right.getBFactor()!=-2) {
				leftRotate(node);
			}else {
				rebalance(right);
			}
		}
	}
	
	@Override
	public void leftRotate(Node<K, V> node) {
		Node<K,V> father = node.getFather();
		Node<K,V> right = node.getRight();
		
		//Case C
		if(right.getBFactor()==-1) { //Became in case A o B
			rightRotate(right);
			right = node.getRight();
		}
			
		//Case A o B
		
		//Set right's father element as unbalanced's father.
		
		if(node.equals(getRoot())) {
			right.setFather(null);
			setRoot(right);
		}else {
			right.setFather(father);
			if(father.getLeft()==node){
				father.setLeft(right);
			}else {
				father.setRight(right);
			}
		}
		
		//if the node of the middle exist change of side.
		Node<K,V> middle = right.getLeft();
		if(middle!=null) {
			node.setRight(middle);
			node.setH2(middle.getH()+1); //Refresh Balance factor
		}else {
			node.setRight(null);
			node.setH2(0);
		}
		
		// Turn down the unbalanced node
		right.setLeft(node);
		right.setH1(node.getH()+1);
		node.setFather(right);
		
		//Refresh Heights
		refreshHeights(node.getFather());
		if(node.getFather()!=null) {
			refreshHeights(node.getFather().getFather());
		}
	}

	@Override
	public void rightRotate(Node<K, V> node) {
		Node<K,V> father = node.getFather();
		Node<K,V> left = node.getLeft();
		
		//Case F
		if(left.getBFactor()==1) { //Became in case D o E
			leftRotate(left);
			left = node.getLeft();
		}
		
		//Case D o E
		
		//Set left's father element for unbalanced's father.
		if(node.equals(getRoot())) {
			left.setFather(null);
			setRoot(left);
		}else {
			left.setFather(node.getFather());
			if(father.getLeft()==node){
				father.setLeft(left);
			}else {
				father.setRight(left);
			}
		}
		
		//if the node of the middle exist change of side.
			Node<K,V> middle = left.getRight();
			if(middle!=null) {
				node.setLeft(middle);
				node.setH1(middle.getH()+1); //Refresh Balance factor
			}else {
				node.setLeft(null);
				node.setH1(0);
			}
			
			// Turn down the unbalanced node
			left.setRight(node);
			left.setH2(node.getH()+1);
			node.setFather(left);
			
			//Refresh Heights
			refreshHeights(node.getFather());
			if(node.getFather()!=null) {
				refreshHeights(node.getFather().getFather());
			}
	}

	private void refreshHeights(Node<K, V> node) {
		if (node != null) {
			int height = node.getH();

			Node<K, V> left = node.getLeft();
			Node<K, V> right = node.getRight();

			if (left != null) {
				node.setH1(left.getH() + 1);
			}
			if (right != null) {
				node.setH2(right.getH() + 1);
			}

			if (height != node.getH()) {
				refreshHeights(node.getFather());
			}
		}
	}

}
