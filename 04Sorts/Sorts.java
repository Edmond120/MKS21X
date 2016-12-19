public class Sorts{
    public static String name(){
	return "09.Wong.Edmond";
    }
    private double time;
    Sorts(){
    }
    public void time(boolean startOrEnd){
	if(startOrEnd){
	    time = System.currentTimeMillis();
	}
	else{
	    System.out.println((System.currentTimeMillis() - time) / 1000.0);
	}
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
	    if(!(data[i] <= data[i + 1])){
		temp = data[i + 1];
		for(int i2 = 0; i2 <= i; i2++){
		    if(temp <= data[i2]){
			for(int i3 = i + 1; i3 > i2; i3 = i3 - 1){
			    data[i3] = data[i3 - 1];
			}
			data[i2] = temp;
			break;
		    }
		}
	    }
	}
    }
    public static void bubbleSort(int[]data){
	int temp = 0;
	for(int i = data.length - 1;i > 0; i -= 1){
	    for(int i2 = 0; i2 < i; i2++){
		if(!(data[i2] <= data[i2 + 1])){
		    temp = data[i2 + 1];
		    data[i2 + 1] = data[i2];
		    data[i2] = temp;
		}
	    }
	    if(temp == 0){
		break;
	    }
	}
    }
	
    public static int[] copy(int[]data){
	int[] result = new int[data.length];
	for(int i = 0; i < data.length; i++){
	    result[i] = data[i];
	}
	return result;
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
