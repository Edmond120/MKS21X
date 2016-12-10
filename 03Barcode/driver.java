public class driver{
    public static void main(String[]args){
	Barcode a = new Barcode(args[0]);
	System.out.println("toString");
	System.out.println(a.toString(true));
	Barcode b = new Barcode("54321");
	System.out.println("compareTo (other zip is 54321)");
	System.out.println(a.compareTo(b));
	System.out.println("toCode(54321)");
	System.out.println(Barcode.toCode("54321"));
	System.out.println("toZip");
	System.out.println(Barcode.checkSum("54321") % 10);
	System.out.println(Barcode.toZip(Barcode.toCode("54321")));
    }
}
