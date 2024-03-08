public class WaterContainer {
    public static void main(String[] args){

        int[] height = {1,2,4,3};

        int maxVolume = 0;

        int leftIndex = 0;
        int rightIndex = height.length-1;

        while (leftIndex<rightIndex){
            int currentVolume = (rightIndex-leftIndex)*Math.min(height[leftIndex],height[rightIndex]);
            if (currentVolume>maxVolume) {
                maxVolume = currentVolume;
            }
            if (height[leftIndex]>=height[rightIndex]){
                rightIndex--;
            }
            else {leftIndex++;}
        }


        System.out.println(maxVolume);

    }
}
