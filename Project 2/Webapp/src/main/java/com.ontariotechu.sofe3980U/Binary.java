package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
	
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	//Function to make both binary numbers same length
	public static String[] lengthOfNumbers(Binary num1,Binary num2) {

		//Get the length of the Binary numbers
		int lenNum1=num1.number.length();
		int lenNum2=num2.number.length();

		//Intialize variables
		String num1String= num1.number;
		String num2String= num2.number;
		int j=0;

		//Add leading zeros to the number that is smaller 
		if (lenNum1> lenNum2){ //First binary number is greater
			int zeros= (lenNum1-lenNum2);
			while (j<zeros){
				
				num2String="0" +num2String;
				j++;
			}
		}
		else if (lenNum1 < lenNum2){ //Second binary number is greater
			int zeros= (lenNum2 - lenNum1);
			while (j<zeros){
				
				num1String="0" + num1String;
				j++;
			}
		}
		return new String[] {num1String, num2String};
		
	}

	public static Binary bitwiseOR(Binary num1,Binary num2){

		//Intialize variables
		String[] binaryLength= lengthOfNumbers(num1, num2); 
		String num1String = binaryLength[0];
		String num2String = binaryLength[1];
		String or="";

		int i=0;

		//Loop to check the number at each position
		while (i< num1String.length()){
			char firstNum= num1String.charAt(i); 
			char secondNum= num2String.charAt(i);


			//If both the digits at position i are 0 then result at position will be 0
			if ((firstNum == '0' && secondNum == '0')){
			or=or+"0";
			}
			//If one or more of the digits at position i are 1 then result at position will be 1
			else {
				or=or+"1";
			}
			i++;

		}
		Binary result=new Binary(or);  // create a binary object with the calculated value.
		return result;
	}

		

	public static Binary bitwiseAND(Binary num1,Binary num2){


	//Intialize variables
		String[] binaryLength= lengthOfNumbers(num1, num2); 
		String num1String = binaryLength[0];
		String num2String = binaryLength[1];
		String and="";

		int i=0;

		//Loop to check the number at each position
		while (i< num1String.length()){
			char firstNum= num1String.charAt(i);
			char secondNum= num2String.charAt(i);

			//If both numbers at position i are 0 then result of AND will be 0 at position i
			if ((firstNum == '0' && secondNum == '0')){
			and=and+"0";
			}

			//If one number at position i are 0 then result of AND will be 0 at position i
			else if (firstNum == '0' && secondNum == '1'){
				and=and+"0";
			}
			else if (firstNum == '1' && secondNum == '0'){
				and=and+"0";
			}
			//If both numbers at position i are 1 then result of AND will be 1 at position i
			else if (firstNum == '1' && secondNum == '1'){
				and=and+"1";
			}
			i++;

		}
		Binary result=new Binary(and);  // create a binary object with the calculated value.
		return result;
		

		
	}

	public static Binary bitwiseMULTIPLY(Binary num1,Binary num2)
	{
		//Intialize variables

		String[] binaryLength= lengthOfNumbers(num1, num2); 
		String num1String = binaryLength[0];
		String num2String = binaryLength[1];


		//Convert the numbers to integers
		int num1Int=Integer.parseInt(num1String, 2);
		int num2Int=Integer.parseInt(num2String, 2);

		//Get the product of the int value
		int product= num1Int*num2Int;

		//Convert the int value into a String and store it as new Binary Object
		Binary result=new Binary(Integer.toBinaryString(product));  
		return result;
		
	}

	
}	