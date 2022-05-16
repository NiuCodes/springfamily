package com.nkx.springcloudorder.datactructure;

public class MyArray {

  private int size;    //array lenght

  private int data[];

  private int index;  //current element count

  MyArray(int capaCity) {
    this.size = capaCity;
    data = new int[size];
    index = 0;
  }

  /**
   * @param loc index
   * @param n   element
   */
  public void insert(int loc, int n) {
    if (index++ < size) {
      for (int i = size - 1; i > loc; i--) {
        data[i] = data[i - 1];
      }
      data[loc] = n;
    }else{
      //扩容 会把size*2
      int[] newData = new int[this.size * 2];
      for (int i = 0; i < size; i++) {
        newData[i] = data[i];
      }
      this.data = newData;
      this.size = this.size * 2;
      insert(loc,n);
    }
  }

  public void delete(int loc) {
    for (int i = loc; i < size; i++) {
      if (i != size - 1) {
        data[i] = data[i + 1];
      } else {
        data[i] = 0;
      }
    }
    index --;
  }

  public void update(int loc,int n){
      data[loc] = n;
  }

  public int get(int loc){
    return data[loc];
  }


}