public class Sorts{
    public static String name(){
	return "09.Wong.Edmond";
    }
    public static void selectionSort(int[]data){
	int temp;
	int minIndex;
	for(int i = 0; i < data.length - 1; i++){
	    temp = data[i];
	    minIndex = i;
	    for(int i2 = i + 1; i2 < data.length; i2++){
		if(data[i2] < data[minIndex]){
		    minIndex = i2;
		}
	    }
	    data[i] = data[minIndex];
	    data[minIndex] = temp;
	}
    }
    public static void insertionSort(int[]data){
	int temp;
	for(int i = 0; i < data.length - 1; i++){
	    if(! data[i] <= data[i + 1]){
		temp = data[i + 1];
		for(int i2 = 0; i2 <= i; i2++){
		    if(temp <= data[i2]){
			for(int i3 = i; i3 > i2; i3 = i3 - 1){
			    data[i3] = data[i3 - 1];
			}
		    }
		}
	    }
	}
    }
		
    public static String toString(int[]x){
	String result = "[";
	for(int i = 0;i < x.length;i++){
	    result +=x[i] + ", ";
	}
	return result.substring(0,result.length() - 2) + "]";
    }
    //   public static int[] toArray(String x){
    //	int length = 0;
    //	int[] result;
    //	for(int i = 1; i < x.length() - 1; i++){
	    
}