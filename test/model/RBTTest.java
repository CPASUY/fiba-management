package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RBTTest {

	RBT<Integer, Integer> rbt;
	NodeRBT<Integer, Integer> node;

	void setup1() {
		rbt = new RBT<>();
	}

	void setup2() {
		rbt = new RBT<>();
		NodeRBT<Integer, Integer> node1 = new NodeRBT<>(26,1);
		NodeRBT<Integer, Integer> node2 = new NodeRBT<>(17,2);
		NodeRBT<Integer, Integer> node3 = new NodeRBT<>(41,3);
		NodeRBT<Integer, Integer> node4 = new NodeRBT<>(14,4);
		NodeRBT<Integer, Integer> node5 = new NodeRBT<>(21,5);
		NodeRBT<Integer, Integer> node6 = new NodeRBT<>(30,6);
		NodeRBT<Integer, Integer> node7 = new NodeRBT<>(47,7);
		NodeRBT<Integer, Integer> node8 = new NodeRBT<>(10,8);
				
		rbt.insertE(node1);
		rbt.insertE(node2);
		rbt.insertE(node3);
		rbt.insertE(node4);
		rbt.insertE(node5);
		rbt.insertE(node6);
		rbt.insertE(node7);
		rbt.insertE(node8);
	}

	@Test
	void test1() {
		setup1();
		NodeRBT<Integer, Integer> node1 = new NodeRBT<>(26,1);
		rbt.insertE(node1);
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

}
