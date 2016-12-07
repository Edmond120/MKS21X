class runtimeException extends Exceptions{
    public runtimeException(String x){
	System.out.println(x);
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
    private int checkSum(){
	int result = 0;
	for(int i = 0; i < _zip.length(); i++){
	    result += Interger.parseInt(_zip.charAt(i));
	}
    public Barcode(String zip){
	_zip = zip;
	if(!precondition()){
	    throw new runtimeException("zip is not the correct length or zip contrains a non digit, but I won't tell you which");
	}
	_checkDigit = checkSum(_zip) % 10;
    }
    public String toString(){
	String result = _zip + "\n|";
	for(int i = 0; i < _zip.length();i++){
	    result = result + key[_zip.charAt(i)];
	}
	result = result + key[_checkDigit] + "|";
	return result;
    }
