package com.learn.ds.table;

public class Entry<K,V>{
	private K key;
	private V val;
	private Entry<K, V> next;
	private Entry<K, V> pre;

	public Entry(K key, V val, Entry<K, V> pre, Entry<K, V> next){
		this.key = key;
		this.val = val;
		this.pre = pre;
		this.next = next;
	}

	public K getKey(){
		return key;
	}

	public V getVal(){
		return val;
	}

	public V setVal(V val){
		V old = this.val;
		this.val = val;
		return old;
	}

	public Entry<K, V> next(){
		return next;
	}

	public Entry<K, V> pre(){
		return pre;
	}

	public void next(Entry<K,V> node){
		next = node;
	}

	public void pre(Entry<K, V> node){
		pre = node;
	}

}
