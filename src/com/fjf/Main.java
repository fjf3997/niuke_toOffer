package com.fjf;

import com.fjf.IterationAndRecursion.RectCover;
import com.fjf.bit_operation.NumberOf1;
import com.fjf.integrality.Power;
import com.fjf.integrality.ReOrderArray;
import com.fjf.sort.Sort;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //jumpFloorStart
//        System.out.println(JumpFloor.JumpFloor(3));
//        System.out.println(JumpFloor.JumpFloorIteration(4));
        //JumpFloorEnd

        //startJumpFloorII
//        System.out.println(JumpFloorII.JumpFloorII(4));
//        System.out.println(JumpFloorII.JumpFloorIIRecursion(4));
//        System.out.println(JumpFloorII.JumpFloorIteration(4));
        //endJumpFloorII

        //startRectCover
//        System.out.println(RectCover.RectCover(4));
//        System.out.println(RectCover.RectCoverIteration(4));
        //endRectCover

        //startNumberOf1
//        System.out.println(NumberOf1.NumberOf1(-5));
//        System.out.println(NumberOf1.NumberOf1(5));
//        System.out.println(NumberOf1.NumberOf1(3));
//        System.out.println(NumberOf1.NumberOf1(10));
        //endNumberOf1

        //startTestBitOperation
//        System.out.println(2<<3);
//        System.out.println(16>>3);
//        System.out.println(8>>3);
//        System.out.println(4>>3);
//        System.out.println(5>>3);
//        System.out.println(16>>>3);
//        System.out.println(-16>>>3);
        //endTestBitOperation
        //startIntegrality
//        System.out.println(Power.Power(3.3,4));
       /* int [] array = {1,2,3,4,5,6,7,8};
        ReOrderArray.reOrderArray(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }*/
        //endIntegrality
        //start quick_sort
        int [] array = {6,1,2,7,9,3,4,5,10,8};
        Sort.quick_sort(array,0,array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
        //end quick_sort
    }
}
