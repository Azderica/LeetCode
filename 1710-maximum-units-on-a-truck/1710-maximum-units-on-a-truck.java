class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        for(int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            
            if(truckSize == 0) break;
        }
        
        return unitCount;
    }
}