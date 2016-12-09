import java.lang.*;
class runtimeException extends Throwable{
    public String message;
    public runtimeException(String x){
	super();
	message = x;
    }
}
public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;
    private static String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    public static boolean precondition(String zip){
	if(zip.length() != 5){
	    return false;
	}
	for(int i = 0; i < 5;i++){
	    if(!Character.isDigit(zip.charAt(i))){
		return false;
	    }
	}
	return true;
    }
    public static int checkSum(String zip){
	int result = 0;
	for(int i = 0; i < zip.length(); i++){
	    result += Integer.parseInt(zip.charAt(i) +"");
	}
	return result;
    }
    public Barcode(String zip){
	_zip = zip;
	try{
	    if(!precondition(_zip)){
		throw new runtimeException("zip is not the correct length or zip contrains a non digit, but I won't tell you which");
	    }
	}
	catch (runtimeException e){
	    System.out.println(e.message);
	}
	_checkDigit = checkSum(_zip) % 10;
    }
    public static String toCode(String zip){
	if(precondition(zip)){
	    String result ="|";
	    for(int i = 0; i < zip.length();i++){
		result = result + key[Character.getNumericValue(zip.charAt(i))];
	    }
	    result = result + key[checkSum(zip) % 10] + "|";
	    return result;
	}
	else{
	    throw new IllegalArgumentException();
	}
    }
    public String toString(boolean x){
	String y = "  ";
	if(x){
	    y = _zip + y;
	}
	return y + toCode(_zip);
    }
    public String toString(){
	return toString(true);
    }
    public int compareTo(Barcode other){
	return (other._zip + other._checkDigit).compareTo(_zip + _checkDigit);
    }
    private static String tanslate(String code){
	String zip = "";
	for(int i = 1; i < 31; i + 5){
	    String x = code.subString(i, i + 5);
	    for(int i = 0; i < 10; i++){
		if(x.equals(key[i])){
		    zip = zip + i;
		    break;
		}
	    }
	}
    }
    public static String toZip(String code){
	String zip = "";
	if(code.length() != 32 || code.charAt(0) != '|' || 
	   code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	
       
    }
}
