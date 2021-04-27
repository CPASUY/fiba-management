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
		avl.insert(9,6);
		avl.insert(10,7);
		avl.insert(5, 2);
		avl.insert(7, 4);
		avl.insert(8, 5);
		avl.insert(6, 3);
		avl.insert(1, 1);
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
		assertEquals(avl.getRoot().getRight().getKey(),10);
		assertEquals(avl.getRoot().getLeft().getRight().getKey(),8);
		assertEquals(avl.getRoot().getLeft().getLeft().getKey(),5);
	}
	

}
