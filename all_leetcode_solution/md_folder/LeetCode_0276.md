#### 276. 存在重复元素




public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
    
public int minSteps(int n) {
        if(n == 1)return 0;
        int ans = n;
        for(int i = 2; i <= Math.sqrt(n);++i ){
            if(n%i == 0){
                ans = Math.min(ans,minSteps(n/i)+i);
            }
        }
        return ans;
    }
