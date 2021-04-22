package model;

public class AVL<K extends Comparable<K>, V> extends BST<K, V> implements IAVL<K, V> {

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
	public boolean removeE(V value) {
		Node<K,V> node = searchE(value);
		return removeE(node);
	}

	private boolean removeE(Node<K,V> node) {
		
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
		// TODO Auto-generated method stub

	}

	@Override
	public void rightRotate(Node<K, V> node) {
		// TODO Auto-generated method stub

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
