package intentory.kalerantes;

class SerialNumberLengthNotEqual9 extends RuntimeException{
	
	
	@Override
	public String getMessage() {
		return "Serial Number of the item must be 9 letters length";
		
	}
	
}
