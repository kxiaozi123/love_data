package com.imooc.suanfa.动态数组;

import java.util.Arrays;

/**
 * 线性结构 （数组 链表 栈 队列 哈希表）
 * 树形结构（二叉树 AVL 红黑树 b树 堆 Trie 哈夫曼树）
 * 图形结构
 *
 * 数组是一种顺序的线性表 所有元素的内存地址是连续的
 *
 * 改成泛型之后多了个内存管理问题
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> {
    private int size;
    private E [] elements;
    private static final int DEFAULT_CAPACITY=10;
    private static final int ELEMENT_NOT_FOUND=-1;
    public ArrayList(int capacity)
    {
        capacity= Math.max(capacity, DEFAULT_CAPACITY);
        elements= (E[]) new Object[capacity];
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
        //能循环利用的留下 不能循环利用的滚蛋
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
        size=0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public E get(int index)
    {
        rangeCheck(index);
        return elements[index];
    }
    public E set(int index,E element)
    {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index]=element;
        return oldElement;
    }
    public int indexOf(E element)
    {
       if(element==null)
       {
           for (int i = 0; i < size; i++) {
               if(elements[i]==null) return i;
           }
       }else {
           for (int i = 0; i < size; i++) {
               if(element.equals(elements[i])) return i;
           }
       }
        return ELEMENT_NOT_FOUND;
    }
    public boolean contains(E element)
    {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }
    public void add(E element)
    {
        add(size,element);
        //elements[size++]=element;

    }
    public E remove(int index)
    {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index+1; i <= size-1; i++) {
            elements[i-1]=elements[i];
        }
//        size--;
//        elements[size]=null;
        elements[--size]=null;
        return old;

    }

    private void rangeCheck(int index) {
        if(index<0||index>=size)
        {
            outOfBounds(index);
        }
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    public void add(int index,E element)
    {
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for (int i = size-1; i >= index; i--) {
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity>=capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        elements=newElements;
        //System.out.println(oldCapacity+"扩容为"+newCapacity);

    }

    private void rangeCheckForAdd(int index) {
        if(index<0||index>size)
        {
            outOfBounds(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if(i!=0)
            {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
