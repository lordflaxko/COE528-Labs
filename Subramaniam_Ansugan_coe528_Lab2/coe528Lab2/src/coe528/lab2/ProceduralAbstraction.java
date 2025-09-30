/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

/**
 *
 * @author Ansugan
 */
public class ProceduralAbstraction {
     
    public static int reverseFactorial(int x) {
          if (x <= 0) {
                    return 1;
            }
     int a = 1, integer = 1;
       
            while (integer < x) {
                    
                    a++;
                    integer = integer * a;
            }
            return a;
    }
    
 public static boolean isMatrixNice(int[][] arr) {
      if (arr == null || arr.length == 0) {
                        return false;
                }
                int sum = 0;
                int len = arr[0].length;

        for(int j = 0; j < arr[0].length; j++)
        sum += arr[0][j];
        
    for(int i = 1; i < arr.length; i++) {
        if(arr[i].length != len)
            return false;
            
        int row = 0;
        
        for(int j = 0; j < arr[i].length; j++)
            row += arr[i][j];
            
        if(row != sum)
            return false;
    }
    
    for(int j = 0; j < arr.length; j++) {
        int column = 0;
        
          for (int[] arr1 : arr) {
              column += arr1[j];
          }
            
        if(column != sum)
            return false;
    }
    
    int diagonal = 0;
    
    for(int i = 0; i < arr.length; i++)
        diagonal += arr[i][i];
        
    if(diagonal != sum)
        return false;
        
    diagonal = 0;
    
    for(int i = 0; i < arr.length; i++)
        diagonal += arr[arr.length - i - 1][i];
        
    return diagonal == sum;
}



        public static void main(String[] args) {
                System.out.println("reverseFactorial(24): " + reverseFactorial(24));
                System.out.println("reverseFactorial(119): " + reverseFactorial(119));

                int matrix1[][] = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
                if (isMatrixNice(matrix1)) {
                        System.out.println("Nice matrix");
                } else {
                        System.out.println("Not nice matrix");
                }
                int matrix2[][] = { { -3, 1, 0 }, { 4, -3, 4 }, { 7, -9, 0 } };
                if (isMatrixNice(matrix2)) {
                        System.out.println("Nice matrix");
                } else {
                        System.out.println("Not nice matrix");
                }
        }
}