package com.imooc.suanfa.动态数组;

/**
 * 线性结构 （数组 链表 栈 队列 哈希表）
 * 树形结构（二叉树 AVL 红黑树 b树 堆 Trie 哈夫曼树）
 * 图形结构
 *
 * 数组是一种顺序的线性表 所有元素的内存地址是连续的
 */
public class ArrayList {
    private int size;
    private int [] elements;
    private static final int DEFAULT_CAPACITY=10;
    private static final int ELEMENT_NOT_FOUND=-1;
    public ArrayList(int capacity)
    {
        capacity= Math.max(capacity, DEFAULT_CAPACITY);
        elements=new int[capacity];
    }
    public ArrayList()
    {
        this(DEFAULT_CAPACITY);
    }
    public int size()
    {
        //用size来控制可以访问的东西
        return size;
    }
    public void clear()
    {
        size=0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int get(int index)
    {
        if(index<0||index>=size)
        {
            throw new IndexOutOfBoundsException("Index:"+index+", Size:"+size);
        }
        return elements[index];
    }
    public int set(int index,int element)
    {
        if(index<0||index>=size)
        {
            throw new IndexOutOfBoundsException("Index:"+index+", Size:"+size);
        }
        int oldElement = elements[index];
        elements[index]=element;
        return oldElement;
    }
    public int indexOf(int element)
    {
        for (int i = 0; i < size; i++) {
            if(elements[i]==element) return i;
        }
        return ELEMENT_NOT_FOUND;
    }
    public boolean contains(int element)
    {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }
}
