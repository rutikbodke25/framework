
public class Buble {
    public static void main(String[] args) {
        int[] arr = {20,12,40,50,60,50};
        buble(arr);
    }
    public static void buble(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }   
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
