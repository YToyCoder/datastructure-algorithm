package com.learn.ds.table;

import java.util.Set;
import java.util.Objects;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {
	public static int default_size = 32;

	private int entry_size;
	private Entry<K,V>[] entries;
	private Set<K> keys;

	public HashTable(int entrySize){
		entry_size = entrySize;
		entries = new Entry[entrySize];
		keys = new HashSet<>();
	}

	public HashTable(){
		this(default_size);
	}

	private int hash(K key){
		return Objects.hash(key) % entry_size;
	}

	public V set(K key, V val){
		V out = null;
		Entry<K, V> entry = getEntry(key);
		if(Objects.isNull(entry)){
			entry = new Entry<>(key,val,null,null);
			setEntry(key, entry);
			keys.add(key);
		}else{
			Entry<K, V> entryWithSameKeyOrLastNode = findEntryWithSameKeyOrLastNode(entry, key);
			if(entryWithSameKeyOrLastNode.getKey().equals(key)){
				out = entryWithSameKeyOrLastNode.setVal(val);
			}else {
				keys.add(key);
				Entry<K, V> kvEntry = new Entry<K, V>(key, val, entryWithSameKeyOrLastNode,null);
				entry.next(kvEntry);
			}
		}
		return out;
	}

	public V delete(K key){
		Entry<K, V> entry = getEntry(key);
		Entry<K, V> entryWithSameKeyOrLastNode = findEntryWithSameKeyOrLastNode(entry, key);
		V out = null;
		if(Objects.nonNull(entryWithSameKeyOrLastNode)
						&& entryWithSameKeyOrLastNode.getKey().equals(key)){
			out = entryWithSameKeyOrLastNode.getVal();
			Entry<K,V> pre = entryWithSameKeyOrLastNode.pre();
			Entry<K, V> next = entryWithSameKeyOrLastNode.next();
			if(Objects.nonNull(pre)){
				pre.next(next);
			}else {
				entries[hash(key)] = next;
			}
			if(Objects.nonNull(next))
				next.pre(pre);
			keys.remove(key);
		}
		return out;
	}

	public V get(K key){
		Entry<K, V> entry = getEntry(key);
		Entry<K, V> entryWithSameKeyOrLastNode = findEntryWithSameKeyOrLastNode(entry, key);
		return Objects.nonNull(entryWithSameKeyOrLastNode)
						&& entryWithSameKeyOrLastNode.getKey().equals(key) ?
						entryWithSameKeyOrLastNode.getVal() :
						null;
	}

	public Set<K> keys(){
		return keys;
	}

	public List<V> values(){
		List<V> vals = new ArrayList<>();
		for(Entry<K,V> entry : entries){
			while(Objects.nonNull(entry)){
				vals.add(entry.getVal());
				entry = entry.next();
			}
		}
		return vals;
	}

	private Entry<K,V> getEntry(K key){
		int hash = hash(key);
		return entries[hash];
	}

	private Entry<K,V> setEntry(K key, Entry<K,V> entry){
		Entry<K, V> old = getEntry(key);
		int hash = hash(key);
		entries[hash] = entry;
		return old;
	}

	private Entry<K, V> findEntryWithSameKeyOrLastNode(Entry<K, V> root, K key){
		while(Objects.nonNull(root) && Objects.nonNull(root.next())){
			if(root.getKey().equals(key))
				return root;
			root = root.next();
		}
		return root;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("{");
		for(Entry<K,V> entry : entries){
			if(Objects.nonNull(entry)){
				sb.append("[")
					.append("(")
					.append(entry.getKey())
					.append(",")
					.append(entry.getVal())
					.append(")");
				entry = entry.next();
				while(Objects.nonNull(entry)){
					sb.append(",")
									.append("(")
									.append(entry.getKey())
									.append(",")
									.append(entry.getVal())
									.append(")");
					entry = entry.next();
				}
				sb.append("]");
			}
		}
		sb.append("}");
		return sb.toString();
	}

}
