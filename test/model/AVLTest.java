package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AVLTest {

	AVL<Integer, Integer> avl;
	ArrayList <Integer> indices;
	
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
	public void setup3() {
		avl = new AVL<>();
		avl.insert(20, 2);
		avl.insert(15, 3);
		avl.insert(22, 1);
	}
	@Test
	void test() {
		setup1();
		assertEquals(avl.getRoot()==null,"it's null");
	}
	
	@Test
	void test2() {
		setup1();
		int key = 10;
		int value = 1;
		avl.insertE(key, value);
		assertNotNull(avl.getRoot(),"It is null");
	}
	
	@Test
	void test3() {
		setup2();
		assertNotNull(avl.getRoot().getLeft(),"It is null");
		assertNotNull(avl.getRoot().getRight().getLeft().getValue(),"It is null");
		assertEquals(avl.getRoot().getRight().getKey(),10);
		assertEquals(avl.getRoot().getLeft().getRight().getKey(),8);
		assertEquals(avl.getRoot().getLeft().getLeft().getKey(),5);
	}
	@Test
	void test4() {
		setup3();
		indices=avl.indices();
		assertEquals(3,indices.get(0),"It is null");
		assertEquals(2,indices.get(1),"It is null");
		assertEquals(1,indices.get(2),"It is null");
	}

	void test5() {
		setup3();
		assertNotNull(avl.searchEquals(15),"it is null");
		assertNotNull(avl.searchEquals(22),"it is null");
		assertEquals(avl.searchEquals(20),avl.getRoot().getRight().getKey());
	}
}
