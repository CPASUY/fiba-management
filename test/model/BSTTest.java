package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTest {

	BST<Integer, Integer> bst;
	
	public void setup1() {
		bst = new BST<>();
	}
	public void setup2() {
		bst = new BST<>();
		bst.insertE(20, 2);
		bst.insertE(15, 3);
		bst.insertE(22, 1);
		bst.insertE(21, 1);
		bst.insertE(14, 1);
	}
	@Test
	void test() {
		setup1();
		int key = 20;
		int value = 1;
		bst.insertE(key, value);
		
		assertNotNull(bst.getRoot(),"It is null");
	}
	
	@Test
	void test2() {
		setup2();
		assertNotNull(bst.getRoot().getLeft(),"It is null");
		
		assertNotNull(bst.getRoot().getRight().getLeft().getValue(),"It is null");
	}

}
