package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RBTTest {

	RBT<Integer, Integer> rbt;
	ArrayList <Integer> indices;

	void setup1() {
		rbt = new RBT<>();
	}

	void setup2() {
		rbt = new RBT<>();
		rbt.insertNode(26,1);
		rbt.insertNode(17,2);
		rbt.insertNode(41,3);
		rbt.insertNode(14,4);
		rbt.insertNode(21,5);
		rbt.insertNode(30,6);
		rbt.insertNode(47,7);
		rbt.insertNode(10,8);
		
	}
	public void setup3() {
		setup1();
		rbt.insertNode(20, 1);
		rbt.insertNode(20, 2);
		rbt.insertNode(20, 3);
		rbt.insertNode(20, 4);
		rbt.insertNode(20, 5);
	}

	@Test
	void test1() {
		setup1();
		rbt.insertNode(26,1);
		assertEquals(rbt.getRoot().getKey(),26);
	}
	
	@Test
	void test2() {
		setup2();
		assertEquals(rbt.getRoot().getKey(),26);
		assertEquals(rbt.getRoot().getLeft().getLeft().getKey(),14);
		assertEquals(rbt.getRoot().getRight().getKey(),41);
		assertEquals(rbt.getRoot().getLeft().getRight().getLeft().getKey(),null);
		assertEquals(rbt.getRoot().getRight().getRight().getKey(),47);
	}
	@Test
	void test3(){
		setup1();
		assertEquals(rbt.getRoot(),null);
		rbt.insertNode(26,1);
		rbt.insertNode(23,1);
		indices = rbt.indices();
		assertEquals(indices.get(0),1);
		assertNotNull(rbt.getRoot(),"it is null");
	}
	@Test
	void test4() {
		setup3();
		assertNotNull(rbt.getRoot(),"It is null");
		assertEquals(1,rbt.getRoot().getValue().get(0),"It is null");
		assertEquals(2,rbt.getRoot().getValue().get(1),"It is null");
		assertNotNull(rbt.searchEquals(20),"it is null");
	}
}
