package com.nkx.springcloudorder.datactructure.linked;

public class MyArrayList<E> implements MyList<E> {

  private static final int DEFAULT_SIZE = 10;

  private Object data[];

  private int index;

  private int size;

  public MyArrayList() {
    this.data = new Object[DEFAULT_SIZE];
    this.size = DEFAULT_SIZE;
  }

  @Override
  public void add(E e) {
    data[index++] = e;
    if (index == size) {
      this.size = size * 2;
      Object[] resize = new Object[size];
      for (int i = 0; i < data.length; i++) {
        resize[i] = data[i];
      }
      this.data = resize;
    }
  }

  @Override
  public void remove(int i) {
    if (i >= 0 && i < index) {
      for (int j = i; j < this.index; j++) {
        data[j] = data[j + 1];
      }
    }
    this.index--;
  }

  @Override
  public void remove(Object e) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == e) {
        remove(i);
      }
    }
  }

  @Override
  public E get(int i) {
    if (i >= 0 && i < index) {
      return (E) this.data[i];
    }
    return null;
  }

  @Override
  public int size() {
    return index;
  }

  @Override
  public boolean isEmpty() {
    if(index <= 0) return true;
    return false;
  }

  public static void main(String[] args) {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(5);
    list.add(4);
    System.out.println(list.size());
    System.out.println(list.isEmpty());
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    Integer integer = new Integer(5);
    list.remove(1);
    System.out.println(list.get(1));
  }

}
