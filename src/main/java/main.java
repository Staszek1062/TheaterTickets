
public class main {

        public static int solution(int[] A) {
            int N = A.length;
            if (N < 3)
                return 0;
            int[] implikant1 = new int[N];
            int[] implikant2 = new int[N];
            int[] lastIndexOf = new int[N+1];
            int[] sequence1 = new int[N+1];
            for (int i = 0; i < N; i++) {
                if (sequence1[A[i]] == 0) {
                    implikant1[i]++;
                    sequence1[A[i]] = 1;
                }
                if(i>0)
                    implikant1[i]+=implikant1[i-1];
            }

            for(int i=1;i<N;i++){
                int temp=implikant1[i-1];
                if(lastIndexOf[A[i]]>0)
                    temp=implikant1[i-1]-implikant1[lastIndexOf[A[i]]-1];
                implikant2[i]=implikant2[i-1]+temp;
                implikant2[i]=implikant2[i]%1000000007;

                lastIndexOf[A[i]]=i;

            }

            int sum = 0;
            for (int i = 1; i < N+1 ; i++) {
                int n=lastIndexOf[i];
                if(n>0){
                    sum = sum + implikant2[n-1];
                    sum=sum%1000000007;
                }


            }
            return sum;
        }
    }