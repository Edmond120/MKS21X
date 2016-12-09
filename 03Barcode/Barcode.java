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
    public boolean precondition(){
	if(_zip.length() != 5){
	    return false;
	}
	for(int i = 0; i < 5;i++){
	    if(!Character.isDigit(_zip.charAt(i))){
		return false;
	    }
	}
	return true;
    }
    public int checkSum(String zip){
	int result = 0;
	for(int i = 0; i < zip.length(); i++){
	    result += Integer.parseInt(zip.charAt(i) +"");
	}
	return result;
    }
    public Barcode(String zip){
	_zip = zip;
	try{
	    if(!precondition()){
		throw new runtimeException("zip is not the correct length or zip contrains a non digit, but I won't tell you which");
	    }
	}
	catch (runtimeException e){
	    System.out.println(e.message);
	}
	_checkDigit = checkSum(_zip) % 10;
    }
    public String toCode(String zip){
	String result ="|";
	for(int i = 0; i < zip.length();i++){
	    result = result + key[Character.getNumericValue(zip.charAt(i))];
	}
	result = result + key[checkSum(zip) % 10] + "|";
	return result;
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
	int a = Integer.parseInt(_zip + _checkDigit);
	int b = Integer.parseInt(other._zip + other._checkDigit);
	if(a == b){
	    return 0;
	}
	else if (a > b){
	    return 1;
	}
	else{
	    return -1;
	}
    }
}
