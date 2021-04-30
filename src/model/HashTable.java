package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HashTable <K extends Comparable<K>,V>{
	private ArrayList <V> list;
	private Node<K, V>[] nodes;
	private int size;
	@SuppressWarnings("unchecked")
	public HashTable() {
		size = 100;
		this.nodes = (Node<K,V>[]) new Node[size];
		list = new ArrayList<V>();
	}
	public int hashFuntion(Integer k) {
		Integer key=0;
		key=k%size;
		return key;
	}
	public void put(Node<K, V> node) {
		int num = Integer.parseInt( (String) node.getKey());
		int k=hashFuntion(num);
		if(nodes[k]==null) {
			nodes[k]=node;
		}else {
			Node<K, V> current=nodes[k];
			while (current.getNextBook()!=null) {
				current=current.getNextBook();
			}
			current.setNextBook(newN);
			newN.setPrevBook(current);
		}
		}
	}
}
