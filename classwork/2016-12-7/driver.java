public class driver{
    public static void main(String[]args){
	Barcode a = new Barcode(args[0]);
	System.out.println(a.toString(true));
    }
}
