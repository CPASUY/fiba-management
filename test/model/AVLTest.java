package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLTest {

	AVL<Integer, Integer> avl;

	public void setup1() {
		avl = new AVL<>();
	}
	
	public void setup2() {
		avl = new AVL<>();
		avl.insert(20,2);
		avl.insert(19, 3);
		avl.insert(18, 4);
		avl.insert(17, 1);
		avl.insert(16, 1);
		avl.insert(15, 1);
	}
	
	@Test
	void test() {
		setup1();
		assertEquals(avl.getRoot()==null,"it's null");
	}
	
	@Test
	void test1() {
		setup1();
		int key = 10;
		int value = 1;
		avl.insertE(key, value);
		assertNotNull(avl.getRoot(),"It is null");
	}
	
	@Test
	void test2() {
		setup2();
		assertNotNull(avl.getRoot().getLeft(),"It is null");
		assertNotNull(avl.getRoot().getRight().getLeft().getValue(),"It is null");
	}
	

}
