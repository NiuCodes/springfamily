package com.nkx.springcloudorder.datactructure.bitmap;

/**
 *高效查找算法，判断某个值是否存在
 *计算机计量单位从小到大  bit -> byte(字节) -> kb -> m(兆) -> G
 * 1byte = 8bit
 * 1 int = 4 byte = 32bit
 * problems: 如何在3亿个整数（0~2亿）中判断某一个数是否存在？内存限制500M，一台机器
 */
public class BitMap {

    byte[] bits;		//如果是byte那就一个只能存8个数
    int max;			//表示最大的那个数

    public BitMap(int max) {
        this.max = max;
        bits = new byte[(max >> 3) + 1];		//max/8 + 1
    }
    public void add(int n) {		//往bitmap里面添加数字

        int bitsIndex = n >> 3;		// 除以8 就可以知道在那个byte
        int loc = n % 8;		///这里其实还可以用&运算  n & 7
        //接下来就是要把bit数组里面的 bisIndex这个下标的byte里面的 第loc 个bit位置为1
        bits[bitsIndex] |= 1 << loc;  //   |=  as +=

    }
    public boolean find(int n) {
        int bitsIndex = n >> 3;		// 除以8 就可以知道在那个byte
        int loc = n % 8;		///这里其实还可以用&运算 n & (8-1)

        int flag = bits[bitsIndex] & (1 << loc);	//如果原来的那个位置是0 那肯定就是0 只有那个位置是1 才行
        if(flag == 0) return false;
        return true;
    }


    public void delete(int n){

        int bitsIndex = n >> 3;
        int loc = n & (8-1);
        bits[bitsIndex] ^=  1 << loc;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(200000001);	//10亿
        bitMap.add(2);
        bitMap.add(3);
        bitMap.add(65);
        bitMap.add(66);
        bitMap.delete(3);

        System.out.println(bitMap.find(3));
        System.out.println(bitMap.find(64));

    }

}
