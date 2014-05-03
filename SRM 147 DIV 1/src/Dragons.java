public class Dragons {
	
	public String snaug(int[] initialFood, int rounds) {

        int[][] adj = {   {0,0,1,1,1,1},
                {0,0,1,1,1,1},
                {1,1,0,0,1,1},
                {1,1,0,0,1,1},
                {1,1,1,1,0,0},
                {1,1,1,1,0,0}};

        long[] num = new long[6];
        long de = 2;
        for(int i = 0; i<6; i++){
            num[i] = 2 * initialFood[i];
        }

        for(int i = 0; i<rounds; i++){
            de*=2;
            long num2[] = new long[6];
            for(int j = 0; j<6; j++){
                for(int k = 0; k<6; k++){
                    if(adj[j][k]==1)num2[j]+=num[k];
                }
                num2[j] /= 2;
            }
            num = num2;
        }

        long rnum = num[2] / findGcd(de,num[2]);
        long rde = de / findGcd(de,num[2]);
        if(rde==1)return ""+rnum;
        return rnum+"/"+rde;
	}

    private long findGcd(long den, long num) {
        while (num != 0) {
            long temp = num;
            num = den % num;
            den = temp;
        }

        return den;
    }
}
