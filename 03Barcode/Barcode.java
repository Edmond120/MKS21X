import java.lang.*;
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
	if(!precondition(_zip)){
	    throw new IllegalArgumentException();
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
	return (_zip + _checkDigit).compareTo(other._zip + other._checkDigit);
    }
    private static int tanslate(String code){
	    for(int i = 0; i < 10; i++){
		if(code.equals(key[i])){
		    return i;
		}
	    }
	    throw new IllegalArgumentException();
    }
    public static String toZip(String code){
	String zip = "";
	if(code.length() != 32 || code.charAt(0) != '|' || 
	   code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	String x = code.substring(1,31);
	for (int i = 0; i < x.length(); i += 5){
	    zip = zip + tanslate(x.substring(i, i + 5));
	}
	if(checkSum(zip.substring(0,5)) % 10 != Integer.parseInt(zip.charAt(5) + "")){
	    throw new IllegalArgumentException();
	}
	return zip;
       
    }
}
