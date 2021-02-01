/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.util.ArrayList;
import java.util.Random;


public class Scratch {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    int max_n = 5; //总金矿数
    int max_people = 999; //总人数
    int[] peopleNeed = { 77, 22, 29, 50, 99 };
    int[] gold = { 92, 22, 87, 46, 90 };
    //初始化x,分别代表第i座金矿是否挖,0代表不挖，1代表挖
    int[] x = new int[] { 0, 0, 0, 0, 0 };
    //当前金矿挖取信息
    int[] currentx = new int[5];
    //取x时的金子数
    int xEvaluation = 0;
    int currentEvaluation = 0;
    int bestEvaluation = -1;
    int[] bestX = new int[5];
    int T = 50; //降温次数
    int bestT = 0; //最好的温度
    int N = 100; //迭代步数
    private float a = 0.98f; // 降温系数
    private float t0 = 100f; // 初始温度
    Random random = new Random(System.currentTimeMillis());
    //评价函数

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Scratch d = new Scratch();
        d.solve();
    }

    public int evaluate(int[] x, int[] g) {
        return getMatrix(x, g);
    }
    //初始化xi

    public void initX() {
        for (int i = 0; i < max_n; i++) {
            int a = new Random().nextInt(2);
            x[i] = a;
        }
        if (getMatrix(x, peopleNeed) > max_people) {
            initX();
        }
    }

    //取x附近的点
    public void updateX(int[] x, int[] currentx) {
        copyArray(x, currentx);
        while (true) {
            int ran1 = random.nextInt(65535) % max_n;
            currentx[ran1] = ((currentx[ran1] == 1) ? 0 : 1);
            //满足条件则令tempx取x附近的值域
            if ((getMatrix(currentx, peopleNeed) <= max_people) && !isEqualX(x, currentx))
                break;
        }
    }

    //判断两个点是否重合
    public boolean isEqualX(int[] x, int[] currentx) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] != currentx[i])
                return false;
        }
        return true;
    }

    //复制数组
    public void copyArray(int[] x, int[] tempx) {
        for (int i = 0; i < max_n; i++) {
            tempx[i] = x[i];
        }
    }

    //实现数组相乘
    public int getMatrix(int[] x, int[] y) {
        int remax = 0;
        for (int i = 0; i < x.length; i++) {
            remax += x[i] * y[i];
        }
        return remax;
    }

    //执行
    public void solve() {
        initX();
        //默认当前最大
        copyArray(x, bestX);
        bestEvaluation = evaluate(x, gold);
        int k = 0; // 降温次数
        int n = 0; // 迭代步数
        float t = t0;
        while (k < T) { //温度控制
            n = 0;
            while (n < N) { //迭代步数
                //取x附近的点
                updateX(x, currentx);
                //求currentX时的评价函数
                currentEvaluation = evaluate(currentx, gold);
                //保存最大评价值
                if (currentEvaluation > bestEvaluation) {
                    bestEvaluation = currentEvaluation;
                    copyArray(currentx, bestX);
                    bestT = k;
                }
                //评价函数的变化值
                int delt = currentEvaluation - xEvaluation;
                //如果评价函数值更大则进行更新,否则以一定概率更新
                //由于我们这里求的是最大值,所以exp((delt)/t)
                if ((delt > 0) || (Math.exp((delt) / t) > random.nextFloat())) {
                    //将当前currentx保存至x中,x代表前一个状态,currentx代表当前状态,并更新当前评价函数值
                    copyArray(currentx, x);
                    xEvaluation = currentEvaluation;
                }
                n += 1;
            }
            t = a * t;
            k += 1;
        }
        //输出打印
        System.out.println("best lenth");
        System.out.println(bestEvaluation);
        System.out.println("best paths");
        for (int i = 0; i < max_n; i++) {
            System.out.print(bestX[i] + ",");
        }
    }
}
