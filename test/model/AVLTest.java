package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AVLTest {

	AVL<String, Integer> avl;
	ArrayList <Integer> indices;
	
	public void setup1() {
		avl = new AVL<>();
	}
	
	public void setup2() {
		avl = new AVL<>();
		avl.insert("9",6);
		avl.insert("10",7);
		avl.insert("5", 2);
		avl.insert("7", 4);
		avl.insert("8", 5);
		avl.insert("6", 3);
		avl.insert("1", 1);
	}
	public void setup3() {
		avl = new AVL<>();
		avl.insert("20", 2);
		avl.insert("15", 3);
		avl.insert("22", 1);
	}
	@Test
	void test() {
		setup1();
		assertNotNull(avl.getRoot()==null,"it's null");
	}
	
	@Test
	void test2() {
		setup1();
		String key = "10";
		int value = 1;
		avl.insertE(key, value);
		assertNotNull(avl.getRoot(),"It is null");
	}
	
	@Test
	void test3() {
		setup2();
		assertNotNull(avl.getRoot().getLeft(),"It is null");
		assertEquals(avl.getRoot().getRight().getKey(),"8");
		assertEquals(avl.getRoot().getLeft().getRight().getKey(),"6");
		assertEquals(avl.getRoot().getLeft().getLeft().getKey(),"10");
	}

	void test4() {
		setup3();
		assertNotNull(avl.searchEquals("15"),"it is null");
		assertNotNull(avl.searchEquals("22"),"it is null");
		assertEquals(avl.searchEquals("20"),avl.getRoot().getRight().getKey());
	}
}
