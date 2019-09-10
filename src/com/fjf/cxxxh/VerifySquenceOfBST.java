package com.fjf.cxxxh;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树
 * 的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        VerifySquenceOfBST verify = new VerifySquenceOfBST();
        int [] a = {4,8,6,12,16,14,10};
        int [] arr = {1,2,3,4,5};
        boolean b = verify.VerifySquenceOfBST(arr);
        System.out.println(b);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        //递归解决
        //return judge(sequence,0,sequence.length-1);
        //非递归
        int size = sequence.length-1;
        int i=0;
        while(size>1){
            while(sequence[i++]<sequence[size]){
                if(i>=size)
                    return true;
            }
            while(sequence[i++]>sequence[size]);
            if(i<size)
                return false;
            size--;
            i=0;
        }
        return true;
    }

    /**
     * BST的后序序列的合法序列是，对于一个序列S，
     * 最后一个元素是x （也就是根），
     * 如果去掉最后一个元素的序列为T，那么T满足
     * ：T可以分成两段，前一段（左子树）小于x，
     * 后一段（右子树）大于x，且这两段（子树）
     * 都是合法的后序序列。完美的递归定义 : ) 。
     * @param sequence
     * @param l
     * @param r
     * @return
     */
    private boolean judge(int[] sequence, int l, int r) {
        if(l>=r)
            return true;
        int i = r;
        while(i>l&&sequence[i-1]>sequence[r])--i;
        for(int j=i-1;j>=0;--j)
            if(sequence[j]>sequence[r])
                return false;
        return judge(sequence,l,i-1)&&judge(sequence,i,r-1);
    }
}
