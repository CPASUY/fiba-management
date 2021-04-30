package model;

import java.util.ArrayList;

public interface HashTableInterface<K extends Comparable<K>, V> {

	public int hashFuntion(Integer key);
	public void put(String n,String l,String a,String t, String points,String rebounds,String assists,String robberies, String blocks);
	public V search(K key);
	public V remove(K key);
	public  ArrayList<V> playerList();
}