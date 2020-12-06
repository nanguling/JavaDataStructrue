import java.util.*;

class A<T> {
    T value;

    public A(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class HomeWork {
    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }
        List<Integer> one = new ArrayList<>();//第一行
        one.add(1);
        ret.add(one);//第一行添加好了
        //从第二行开始放
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();//当前行
            curRow.add(1);//当前行第一列都是1
            List<Integer> preRow = ret.get(i-1);//得到前一行
            //从当前行第二列开始
            for (int j = 1; j < i; j++) {
                //当前行的当前列等于前一行的当前列加上前一列
                int tmp = preRow.get(j) + preRow.get(j-1);
                curRow.add(tmp);
            }
            //最后一列也都是1
            curRow.add(1);
            //说明添加完了
            ret.add(curRow);
        }
        return ret;
    }


    //将数组分为和相等的三个部分
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int s : A) {
            sum += s;
        }
        if (sum % 3 != 0) {//数组元素总和不是3的倍数说明不能分成3个部分，直接返回false
            return false;
        }
        int sum1 = sum / 3;//第一部分的和
        int i = 0;
        sum = 0;
        while(i < A.length) {
            sum += A[i];
            if (sum == sum1) {//说明找到了第一部分
                break;
            }
            i++;
        }
        if (i == A.length-1) {//判断退出是否break跳出
            return false;//不是因为break跳出，此时数组肯定不能分成3部分
        }
        int j = i + 1;//第二部分
        while (j + 1 < A.length) {//确保第二部分后还能有元素，如果有，那么剩下的元素肯定可以满足条件
            sum += A[j];
            if (sum == 2*sum1) {//如果是在循环退出之前即还剩下元素的时候找到了第二部分，那么就直接返回true
                return true;
            }
            j++;
        }
        return false;//因为循环条件退出说明不满足分成3部分
    }

    //小镇法官
    //所有人信任法官，除了法官自己，那么法官的信任度就是N-1;
    //除了法官不信任任何人，其他人都要信任别人，法官信任别人就是0
    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return N;//只有一个人，那么这个人就是法官
        }
        int[] arr = new int[N+1];
        for (int[] tmp : trust) {
            arr[tmp[0]]--;//信任别人
            arr[tmp[1]]++;//被别人信任
        }
        for (int i = 0; i <= N; i++) {
            if (arr[i] == N-1) {//满足信任度为N+1
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        A<String> a = new A<>("孙悟空");
        String s = a.getValue();
        System.out.println(s);
        A<Integer> a1 = new A<>(10);
        int i = a1.getValue();
        System.out.println(i);
    }
}

//员工的重要性
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int pos = 0;//用来记录和id相同的员工
        for(int i = 0;i < employees.size();i++) {
            if(employees.get(i).id == id) {
                pos = i;
                break;//得到此id的员工，跳出
            }
        }
        //得到此id员工的重要度
        int sum = employees.get(pos).importance;
        //开始遍历此id员工的下属员工
        for(int i = 0; i < employees.get(pos).subordinates.size(); i++) {
            //通过递归得到下属员工的重要度，返回之后加上
            sum += getImportance(employees, employees.get(pos).subordinates.get(i));
        }
        //递归结束条件，也是整个函数返回值
        return sum;
    }
}