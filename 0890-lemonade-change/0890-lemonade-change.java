class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;
        for(int i : bills) {
            if(i == 5) {
                cnt5++;
            } else if(i == 10) {
                if(cnt5 <= 0) return false;
                cnt5 --;
                cnt10 ++;
            } else if(i == 20) {
                if(cnt10 > 0 && cnt5 > 0) {
                    cnt10 --;
                    cnt5 --;
                } else if(cnt5 >= 3) {
                    cnt5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
