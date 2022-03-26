public class BrokenCalc {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while (target > startValue) {
            if ((target & 1)== 1) {
                count += 2;
                target = (target >> 1) + 1;
            }
            else{
                count += 1;
                target = target >> 1;
            }
        }
        return count + (startValue - target);
    }
}
