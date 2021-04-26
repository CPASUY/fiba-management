package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTest {

	BST<Integer, Integer> bst;
	
	public void setup1() {
		bst = new BST<>();
	}
	public void setup2() {
		setup1();
	}
	@Test
	void test() {
		setup1();
		int key = 20;
		int value = 1;
		bst.insertE(key, value);
		
		assertNotNull(bst.getRoot(),"It it null");
	}

}
