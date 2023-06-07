package com.company;

import java.lang.reflect.Array;

public class SparseArray {
    public static void main ( String[] args ) {
        //先创建一个11x11的数组
        int[][] array = new int[ 11 ][ 11 ];
        //进行赋值操作
        array[ 0 ][ 2 ] = 1;
        array[ 1 ][ 3 ] = 2;

        //数组进行遍历
        for ( int i = 0 ; i < array.length ; i++ ) {
            for ( int j = 0 ; j < array.length ; j++ ) {
                System.out.print ( "\t" + array[ i ][ j ] );
            }
            System.out.println ();
        }

        //二维数组怎么转稀疏数组
        System.out.println ( "---------------稀疏数组-----------------" );
        //1.首先算出二维数组里面有多少数据
        int sum = 0;
        for ( int i = 0 ; i < array.length ; i++ ) {
            for ( int j = 0 ; j < array.length ; j++ ) {
                if ( array[ i ][ j ] != 0 ) {
                    sum++;
                    //把数据放进稀疏数组
                }
            }
        }

        //2.其次总共分为三列 --->(记录行,记录列,元素)
        //3.总共有sum+1行
        //4.创建一个稀疏数组
        int[][] sparseArray = new int[ sum + 1 ][ 3 ];
        sparseArray[ 0 ][ 0 ] = 11;
        sparseArray[ 0 ][ 1 ] = 11;
        sparseArray[ 0 ][ 2 ] = sum;

        //5.进行对稀疏数组赋值操作
        int count = 0;
        for ( int i = 0 ; i < array.length ; i++ ) {
            for ( int j = 0 ; j < array.length ; j++ ) {
                if ( array[ i ][ j ] != 0 ) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] =array[i][j];
                }
            }

        }

        //6.对稀疏数组进行遍历输出
        for ( int i = 0 ; i <sum+1  ; i++ ) {
            for ( int j = 0 ; j < 3 ; j++ ) {
                System.out.print ( "\t" + sparseArray[ i ][ j ] );
            }
            System.out.println ();
        }

        //根据稀疏数组---->转成二维数组
        //1.先读取稀疏数组第一行.在根据读取的数据,创建二维数组
        //2.在根据而后面的几行返回数据就可以
        int col;
        int row;
        col = sparseArray[0][0];
        row = sparseArray[0][1];
        //根据读取的数据创建多大的二维数组
        int[][] oArray = new int[ col ][ row ];

        int a  ;
        int b ;
        int c ;
        for ( int i = 0 ; i <sum+1  ; i++ ) {
            for ( int j = 0 ; j < 3 ; j++ ) {
                if(i>0){
                     a = sparseArray[i][0];
                     b = sparseArray[i][1];
                     c = sparseArray[i][2];
                    oArray[a][b] = c;
                }
            }
        }
        //二维数组还原
        System.out.println ("-------------------二维数组还原---------------------");
        for ( int i = 0 ; i < oArray.length ; i++ ) {
            for ( int j = 0 ; j < oArray.length ; j++ ) {
                System.out.print ( "\t" + oArray[ i ][ j ] );
            }
            System.out.println ();
        }

    }
}
