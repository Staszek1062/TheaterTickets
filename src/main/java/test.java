
public class test {

    public static void main(String[] args) {
        int[] A =new int [100000];
        for(int i=0;i<A.length;i++){
            A[i]=1;
        }
        for(int i=1;i<=100000;i++){
            A[i-1]= (int) (Math.random()*100000);
        }


        System.out.println(main.solution(A));

    }
}

