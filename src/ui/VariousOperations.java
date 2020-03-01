import java.util.Scanner;
public class VariousOperations {
	
	//VAR AND CONSTANTS ***********************************************************
	/*Main menu constants*/
	private final static char STRING = 'C';
	private final static char NUMBER = 'N';
	private final static char ARRAY = 'A';
	private final static char EXIT = 'S';
	
	/*String constants*/
	private final static char CHANGE_STRINGS= '1';
	private final static char LENGTH_STRINGS= '2';
	private final static char CONCATENATED_STRINGS= '3';
	private final static char CHARACTER_STRING= '4';
	private final static char CHARACTER_STRINGS= '5';
	private final static char EXIT_STRING= '6';
	
	/*Number constants*/
	private final static char CHANGE_NUMBERS= '1';
	private final static char DIVISION= '2';
	private final static char DIVISION_REMAINDER= '3';
	private final static char EXIT_NUMBER= '4';
	
	/*Array constansts*/
	private final static char SHOW = '1';
	private final static char AVERAGE = '2';
	private final static char LARGEST = '3';
	private final static char SUM = '4';
	private final static char SUBTRACTION = '5';
	private final static char MULTIPLICATION = '6';
	private final static char UNION_REPEATED = '7';
	private final static char UNION = '8';
	private final static char INTERSECTION = '9';
	private final static char ROTATION = 'A';
	private final static char ORDER = 'B';
	private final static char EXIT_ARRAY = 'C';
	
	/*General variables*/
	static Scanner reader;
	static char modeSelection;
	static char methodSelection;
	static String messageModeSelection;
	static char[] modeOptions;
	static boolean join;
	
	/*String variables*/
	static String messageStringSelection;
	static String[] strings;
	static char[] stringOptions;
	
	/*Number variables*/
	static double[] numbers;
	static String messageNumberSelection;
	static char[] numberOptions;
	
	/*Array variables*/
	static int[][] arrayFull;
	static String messageArraySelection;
	static char[] arrayOptions;
	static int[] additionArray;
	static int[] substractionArray;
	static int[] multiplicationArray;
	static int[] intersectionArray;
	static int[] unionRepeatedArray;
	static int[] rotationArray;
	static int[] orderArray;
	//END VAR AND CONSTANTS *******************************************************
	
	/*
	This method initializes the static variables of the class. 
	<b>pre: </b> <br>
	<b>post: </b> All variables required for program execution have been initialized  <br>
	*/
	public static void VariousOperations(){
		reader = new Scanner(System.in);
		modeSelection=' ';
		methodSelection=' ';
		join=true;
		messageModeSelection="---Bienvenido al programa---"+
			"\n Que desea hacer?: "+
			"\n (C) Trabajar con cadenas."+
			"\n (N) Trabajar con numeros."+
			"\n (A) Trabajar con arreglos."+
			"\n (S) Salir del programa.";
		modeOptions= new char[] {STRING,NUMBER,ARRAY,EXIT};
		
		//String
		messageStringSelection="\nQue desea hacer: "+
		"\n (1) Cambiar las cadenas."+
		"\n (2) Mostrar el tamano de las cadenas."+
		"\n (3) Mostrar las cadenas concatenadas."+
		"\n (4) Mostrar el caracter en una posicion de una cadena especifica."+
		"\n (5) Mostrar el caracter en una posicion de todas las cadenas."+
		"\n (6) Salir";
		stringOptions=new char[] {'1','2','3','4','5','6'};
		strings=new String[3];
		
		//Numbers
		numbers=new double[2];
		messageNumberSelection="\nQue desea hacer: "+
		"\n (1) Cambiar los numeros."+
		"\n (2) Dividir los numeros."+
		"\n (3) Dividir la parte entera de los numeros y mostrar el residuo."+
		"\n (4) Salir.";
		numberOptions=new char[] {'1','2','3','4'};
		
		//Array
		messageArraySelection="\nQue desea hacer: "+
		"\n (1) Mostrar los 3 arreglos."+
		"\n (2) Calcular el promedio de uno de los arreglo."+
		"\n (3) Mostrar el numero mas grander de uno de los arreglos."+
		"\n (4) Sumar 2 de los arreglos."+
		"\n (5) Restar 2 de los arreglos."+
		"\n (6) Multiplicar 2 de los arreglos"+
		"\n (7) Unir los 3 arreglos con elementos repetidos."+
		"\n (8) Unir los 3 arreglos sin elementos repetidos."+
		"\n (9) Interseccion entre los 3 arreglos con elementos repetidos"+
		"\n (A) Rotar los valores de uno de los arreglos"+
		"\n (B) Ordenar uno de los arreglos"+
		"\n (C) Salir";
		arrayOptions=new char[] {'1','2','3','4','5','6','7','8','9','A','B','C'};
		arrayFull = new int[3][];
	}
	/*
	Sets the user's choice
	<b>pre: </b> <br>
	<b>post: </b> The user's choice has been established <br>
	@param message message with the options != null, message != " "
	@param options options the user can choose != null, options!= ""
	@reader reader Scanner
	*/
	public static void setSelection(String message, char[] options, Scanner reader){
		boolean fine = false;
		while(!fine){
			System.out.println(message);
			modeSelection = Character.toUpperCase(reader.nextLine().charAt(0));
			for(int i=0;i<options.length&&!fine;i++){
				if(modeSelection==options[i]){
					modeSelection=options[i];
					fine=true;
				}
			}
			if (!fine){
				System.out.println("\nIngrese una opcion correcta!");
			}
		}
	}
	/*
	execute a particular method
	<b>pre: </b> <br>
	<b>post: </b> runs the method that the user chose <br>
	@param modeSelection the user's choice != null, modeSelection != " "
	*/
	public static void mode(char modeSelection){
		switch(modeSelection){
			case STRING:
			join=true;
			stringMode();
			break;
			case NUMBER:
			numberMode();
			break;
			case ARRAY:
			arrayMode();
			break;
		}
	}
	
	//STRING MODE -----------------------------------------------------------------
	/*
	execute the necessary methods for the string mode
	<b>pre: </b> <br>
	<b>post: </b> execute the necessary methods to make the string mode work <br>
	*/
	public static void stringMode(){
		System.out.println("\n---Modo Cadena---");
		if (join){
			getStrings(strings,reader);
		}
		//pide cadenas
		setSelection(messageStringSelection,stringOptions,reader);
		menuString(reader,strings);
	}
	/*
	execute a particular method
	<b>pre: </b> <br>
	<b>post: </b> runs the method that the user chose <br>
	
	@param modeSelection the user's choice != null, modeSelection != " "
	*/
	public static void menuString(Scanner reader,String[] strings){
		
		switch(modeSelection){
			case CHANGE_STRINGS:
				getStrings(strings, reader);
				stringMode();
			break;
			
			case LENGTH_STRINGS:
				join=false;
				showsLengthStrings(strings);
				stringMode();
			break;
				
			case CONCATENATED_STRINGS:
				join=false;
				showConcatenatedStrings(strings);
				stringMode();
			break;
			
			case CHARACTER_STRING:
				join=false;
				characterString(reader,strings);
				stringMode();
			break;
			
			case CHARACTER_STRINGS:
				join=false;
				characterStrings(reader,strings);
				stringMode();
			break;
			
			case EXIT_STRING:
				join=true;
				setSelection(messageModeSelection,modeOptions,reader);
				mode(modeSelection);
			break;
		}
	}
	/*
	requests and stores the strings
	<b>pre: </b> <br>
	<b>post: </b> the strings obtained by the user are saved <br>
	@param strings  array where strings are stored != null
	@param reader Scanner
	*/
	public static void getStrings(String[] strings,Scanner reader){
		for(int i=0; i<strings.length; i++){
			System.out.println("Ingrese la cadena de la posicion "+(i+1)+" :");
			strings[i]=reader.nextLine();
		}
	}
	/*
	shows the size of the strings
	<b>pre: </b> <br>
	<b>post: </b> shows the size of all the strings <br>
	@param strings array where strings are stored != null
	*/
	public static void showsLengthStrings(String strings[]){
		for(int i=0; i<strings.length; i++){
			System.out.println("La cadena " + (i+1) + " tiene " + strings[i].length()+ " caracteres.\n");
		}
	}
	/*
	concatenates all the strings and then shows it
	<b>pre: </b> <br>
	<b>post: </b> the string is shown with all the strings inside <br>
	@param strings  array where strings are stored != null
	*/
	public static void showConcatenatedStrings(String strings[]){
		String concatenatedString = "";
		for (int i=0; i<strings.length; i++) {
			
			concatenatedString+=strings[i] + " ";
			
		}
		System.out.println(concatenatedString);
	}
	/*
	shows a specific character of a specific string
	<b>pre: </b> <br> 
	<b>post: </b> the character of the chosen position and string is shown <br>
	@param reader Scanner
	@param strings  array where strings are stored != null
	*/
	public static void characterString(Scanner reader, String strings[]){
		boolean exit=false;
		
		while (!exit){
		
			System.out.println("\nEliga una cadena entre 1 y " + strings.length );
			int stringNumber = Integer.parseInt(reader.nextLine())-1;
			
			if(stringNumber<strings.length&&stringNumber>-1){ //comprobacion cadena
				String selectedString = strings[stringNumber];
				System.out.println("Elegiste la cadena: '" + selectedString+"'");
				
				while (!exit) {
					
					System.out.println("\nEliga ahora un caracter entre 1 y " + selectedString.length());
					int characterNumber = Integer.parseInt(reader.nextLine())-1;
					
					if (characterNumber<selectedString.length()&&characterNumber>-1) { //comprobacion caracter
						
						System.out.println("El caracter resultante es: " + selectedString.charAt(characterNumber));
						exit=true;
					
					}else{
						System.out.println("\nIngrese un caracter valido!");
					}
				}
				
			} else {
				System.out.println("\nIngrese una cadena valida!");
			}
			
		}
	}
	/*
	find the smallest string in a string arrangement 
	<b>pre: </b> <br>
	<b>post: </b> the size of the smallest string is calculated in min
	@param strings  array where strings are stored != null
	*/
	public static int smallestStringArray(String strings[]){	
		int min=0;
		for (int i=0; i<strings.length;i++) {
			if (i==0) 
				min=strings[i].length();
			else if(min>strings[i].length())
				min=strings[i].length();
		}
		return min;
	}
	/*
	Of all strings shows the character of the position the user entered 
	<b>pre: </b> <br>
	<b>post: </b> the character of each string is shown
	@param reader Scanner
	@param strings  array where strings are stored != null
	*/
	public static void characterStrings(Scanner reader, String strings[]){
		int smallestString = smallestStringArray(strings);
		boolean exit=false;
		
		while (!exit) {
			
			System.out.println("Eliga un numero entre 1 y "+smallestString);
			int characterSelected = Integer.parseInt(reader.nextLine())-1;
			
			if(characterSelected<smallestString&&characterSelected>-1){
				System.out.println("\nEl caracter #"+(characterSelected+1)+" de la cadena:");
				for(int i=0; i<strings.length; i++){
				System.out.println(" '" + strings[i]+"' es: "+strings[i].charAt(characterSelected));
				exit=true;
				}
			}else{
				System.out.println("\nIngrese un caracter valido!");
			}
		}
	}
	//END STRING MODE -----------------------------------------------------------------
	
	//NUMBERS MODE --------------------------------------------------------------------
	/*
	execute the necessary methods for the number mode
	<b>pre: </b> <br>
	<b>post: </b> execute the necessary methods to make the number mode work <br>
	*/
	public static void numberMode(){
		System.out.println("\n---Modo Numero---");
		if(join){
			getNumbers(numbers,reader);
		}
		setSelection(messageNumberSelection,numberOptions,reader);
		menuNumbers(reader,numbers);
	}
	/*
	execute a particular method
	<b>pre: </b> <br>
	<b>post: </b> runs the method that the user chose <br>
	@param modeSelection the user's choice != null, modeSelection != " "
	*/
	public static void menuNumbers(Scanner reader,double[] numbers){
		switch(modeSelection){
			case CHANGE_NUMBERS:
				getNumbers(numbers, reader);
				numberMode();
			break;
			
			case DIVISION:
				join=false;
				division(numbers);
				numberMode();
			break;
			
			case DIVISION_REMAINDER:
				join=false;
				divisionRemainder(numbers);
				numberMode();
			break;
			
			case EXIT_NUMBER:
				join=true;
				setSelection(messageModeSelection,modeOptions,reader);
				mode(modeSelection);
			break;
		}
	}
	/*
	requests and stores the numbers
	<b>pre: </b> <br>
	<b>post: </b> the numbers obtained by the user are saved <br>
	@param numbers  array where numbers are stored != null
	@param reader Scanner
	*/
	public static void getNumbers(double[] numbers,Scanner reader){
		for(int i=0;i<numbers.length;i++){
			System.out.println("Ingrese un numero: ");
			numbers[i]=Double.parseDouble(reader.nextLine());
		}
	}
	/*
	shows the result of dividing two numbers 
	<b>pre: </b> <br>
	<b>post: </b> shows the division between the two numbers
	@param numbers array where numbers are stored != null
	*/
	public static void division(double[] numbers){
		System.out.println("\nEl resultado de dividir los dos numeros es: "+numbers[0]/numbers[1]);
	}
	/*
	shows the result and the residue of dividing the part of two numbers
	<b>pre: </b> <br>
	<b>post: </b> shows the result and the residue of the division
	@param numbers array where numbers are stored != null
	*/
	public static void divisionRemainder(double[] numbers){
		int first = (int)numbers[0];
		int second = (int)numbers[1];
		System.out.println("La division entre las partes enteras es: "+ (first/second)+ 
		"\n y el residuo es: " + (first%second));
	}
	//END NUMBER MODE --------------------------------------------------------------------
	
	//ARRAY MODE -------------------------------------------------------------------------
	/*
	execute the necessary methods for the array mode
	<b>pre: </b> <br>
	<b>post: </b> execute the necessary methods to make the array mode work <br>
	*/
	public static void arrayMode(){
		System.out.println("\n---Modo Arreglo---");
		if(join){
			setArrays(arrayFull,reader);
		}
		setSelection(messageArraySelection,arrayOptions,reader);
		menuArrays(reader,arrayFull);
	}
	/*
	execute a particular method
	<b>pre: </b> <br>
	<b>post: </b> runs the method that the user chose <br>
	@param modeSelection the user's choice != null, modeSelection != " "
	*/
	public static void menuArrays(Scanner reader,int[][] arrayFull){
		switch(modeSelection){
			case SHOW:
				join=false;
				showArrays(arrayFull);
				arrayMode();
			break;
		
			case AVERAGE:
				join=false;
				averageArray(arrayFull,reader);
				arrayMode();
			break;
		
			case LARGEST:
				join=false;
				largestInArray(arrayFull,reader);
				arrayMode();
			break;
		
			case SUM:
				join=false;
				sumArrays(arrayFull,additionArray,reader);
				arrayMode();
			break;
		
			case SUBTRACTION:
				join=false;
				subtractionArrays(arrayFull,substractionArray,reader);
				arrayMode();
			break;
		
			case MULTIPLICATION:
				join=false;
				multiplicationArrays(arrayFull,multiplicationArray,reader);
				arrayMode();
			break;
		
			case UNION_REPEATED:
				join=false;
				showArraysRepeated();
				arrayMode();
			break;
		
			case UNION:
				join=false;
				unionNoRep(arrayFull,unionRepeatedArray,reader);
				arrayMode();
			break;
		
			case INTERSECTION:
				join=false;
				intersectionArrays(arrayFull,intersectionArray,reader);
				arrayMode();
			break;
		
			case ROTATION:
				join=false;
				rotationArray(arrayFull,rotationArray,reader);
				arrayMode();
			break;
		
			case ORDER:
				join=false;
				orderArray(arrayFull,orderArray,reader);
				arrayMode();
			break;
		
			case EXIT_ARRAY:
				join=true;
				setSelection(messageModeSelection,modeOptions,reader);
				mode(modeSelection);
			break;
		}
	}
	/*
	requests and stores the number array
	<b>pre: </b> <br>
	<b>post: </b> the arrangements are created with the size and numbers that the user enters <br>
	@param arrayFull arrangement where arrangements are stored != null
	@param reader Scanner
	*/
	public static void setArrays(int[][] arrayFull,Scanner reader){
		for(int i=0;i<3;i++){
			System.out.println("Eliga el tamaño del arreglo #"+(i+1)+": ");
			arrayFull[i] = new int[Integer.parseInt(reader.nextLine())];
				for(int i2=0;i2<arrayFull[i].length;i2++){
					System.out.println("Eliga el numero #"+(i2+1)+" del arreglo #"+(i+1)+": ");
					arrayFull[i][i2] = Integer.parseInt(reader.nextLine());
				}
		}
	}
	/*
	shows shows each of the arrangements created
	<b>pre: </b> <br>
	<b>post: </b> lo que hace
	@param arrayFull arrangement where arrangements are stored != null
	*/
	public static void showArrays(int[][] arrayFull){
		System.out.println();
		for(int i=0;i<3;i++){
			System.out.print("Arreglo "+(i+1)+":");
				for(int i2=0;i2<arrayFull[i].length;i2++){
					System.out.print("|"+arrayFull[i][i2]+"|");
				}
			System.out.println();
		}
	}
	/*
	the user selects one of the arrangements
	<b>pre: </b> <br>
	<b>post: </b> saves and returns the index of the arrangement the user chooses
	@param arrayFull arrangement where arrangements are stored != null
	@param reader Scanner
	@return selection the index of the chosen arrangement
	*/
	public static int arraySelection(int[][] arrayFull, Scanner reader){
		boolean exit = false;
		int selection =0;
		while(!exit){
			System.out.println("Escoga uno de los 3 arreglos: ");
			showArrays(arrayFull);
			selection = Integer.parseInt(reader.nextLine());
			if(selection<4&&selection>0){
				exit=true;
			}else{
				System.out.println("Ingrese un numero valido!");
			}
		}
		return selection-1;
	}
	/*
	selects an arrangement and averages its numbers
	<b>pre: </b> <br>
	<b>post: </b> shows the average of the numbers found in the selected array
	@param arrayFull arrangement where arrangements are stored != null
	@param reader Scanner
	*/
	public static void averageArray(int[][] arrayFull,Scanner reader){
		double addition=0;
		int arrayNumber = arraySelection(arrayFull,reader);
		int arrayLength = arrayFull[arrayNumber].length;
		for (int i=0; i<arrayLength; i++) {
			addition+=arrayFull[arrayNumber][i];
		}
		double average=addition/(double)arrayLength;
		System.out.println("El promedio del arreglo #"+(arrayNumber+1)+" es: "+average);
	}
	/*
	find the largest number of an arrangement
	<b>pre: </b> <br>
	<b>post: </b> shows the largest number of an array the user chooses
	@param arrayFull arrangement where arrangements are stored != null
	@param reader Scanner
	*/
	public static void largestInArray(int[][] arrayFull, Scanner reader){
		int arrayNumber = arraySelection(arrayFull,reader);
		int arrayLength = arrayFull[arrayNumber].length;
		int max=0;
		for(int i=0;i<arrayLength;i++){
			for(int i2=0;i2<arrayLength;i2++){
				if(i==0){
					max=arrayFull[arrayNumber][i];
				}else if(max<arrayFull[arrayNumber][i2]){
					max=arrayFull[arrayNumber][i2];
				}
			}
		}
		System.out.println("El numero mas grande del arreglo es: "+max);
	}
	/*
	generates an array with the sum of the elements of two arrays
	<b>pre: </b> <br>
	<b>post: </b> shows the array generated from the sum of two arrays
	@param arrayFull arrangement where arrangements are stored != null
	@param additionArray summation arrangement !=null
	@param reader Scanner
	*/
	public static void sumArrays(int[][] arrayFull,int[] additionArray,Scanner reader){
		System.out.println("Arreglo #1: ");
		int arrayNumber1 = arraySelection(arrayFull,reader);
		int arrayLength1 = arrayFull[arrayNumber1].length;
		System.out.println("Arreglo #1: ");
		int arrayNumber2 = arraySelection(arrayFull,reader);
		int arrayLength2 = arrayFull[arrayNumber2].length;
	
		if(arrayLength1>arrayLength2){
			additionArray=new int[arrayLength2];
		} else {
			additionArray=new int[arrayLength1];
		}
		
		for(int i=0; i<additionArray.length; i++){
			additionArray[i]=arrayFull[arrayNumber1][i]+arrayFull[arrayNumber2][i];
		}
		System.out.println("El arreglo con la suma tiene los elementos: ");
		for (int i=0;i<additionArray.length;i++){
			System.out.print(additionArray[i]+" ");
		}
	}
	/*
	generates an array with the subtraction of the elements of two arrays
	<b>pre: </b> <br>
	<b>post: </b> shows the array generated from the subtraction of two arrays
	@param arrayFull arrangement where arrangements are stored != null
	@param substractionArray subtraction arrangement !=null
	@param reader Scanner
	*/
	public static void subtractionArrays(int[][] arrayFull,int[] substractionArray,Scanner reader){
		System.out.println("Arreglo #1: ");
		int arrayNumber1 = arraySelection(arrayFull,reader);
		int arrayLength1 = arrayFull[arrayNumber1].length;
		System.out.println("Arreglo #1: ");
		int arrayNumber2 = arraySelection(arrayFull,reader);
		int arrayLength2 = arrayFull[arrayNumber2].length;
	
		if(arrayLength1>arrayLength2){
			substractionArray=new int[arrayLength2];
		} else {
			substractionArray=new int[arrayLength1];
		}
		
		for(int i=0; i<substractionArray.length; i++){
			substractionArray[i]=arrayFull[arrayNumber1][i]-arrayFull[arrayNumber2][i];
		}
		System.out.println("El arreglo con la resta tiene los elementos: ");
		for (int i=0;i<substractionArray.length;i++){
			System.out.print(substractionArray[i]+" ");
		}
	}
	/*
	generates an array with the multiplication of the elements of two arrays
	<b>pre: </b> <br>
	<b>post: </b> shows the array generated from the multiplication of two arrays
	@param arrayFull arrangement where arrangements are stored != null
	@param multiplicationArray multiplication arrangement !=null
	@param reader Scanner
	*/
	public static void multiplicationArrays(int[][] arrayFull,int[] multiplicationArray,Scanner reader){
		System.out.println("Arreglo #1: ");
		int arrayNumber1 = arraySelection(arrayFull,reader);
		int arrayLength1 = arrayFull[arrayNumber1].length;
		System.out.println("Arreglo #1: ");
		int arrayNumber2 = arraySelection(arrayFull,reader);
		int arrayLength2 = arrayFull[arrayNumber2].length;
	
		if(arrayLength1>arrayLength2){
			multiplicationArray=new int[arrayLength2];
		} else {
			multiplicationArray=new int[arrayLength1];
		}
		
		for(int i=0; i<multiplicationArray.length; i++){
			multiplicationArray[i]=arrayFull[arrayNumber1][i]*arrayFull[arrayNumber2][i];
		}
		System.out.println("El arreglo con la multiplicacion tiene los elementos: ");
		for (int i=0;i<multiplicationArray.length;i++){
			System.out.print(multiplicationArray[i]+" ");
		}
	}
	/*
	generates an array with the union of the elements of two arrays
	<b>pre: </b> <br>
	<b>post: </b> an arrangement is generated by the union of the elements of two arrangements
	@param arrayFull arrangement where arrangements are stored != null
	@param unionRepeatedArray arrangement where the union of the elements is stored != null
	@param reader Scanner
	*/
	public static int[] union(int[][] arrayFull,int[] unionRepeatedArray,Scanner reader){
		int arrayLength1 = arrayFull[0].length;
		int arrayLength2 = arrayFull[1].length;
		int arrayLength3 = arrayFull[2].length;
		unionRepeatedArray = new int[arrayLength1+arrayLength2+arrayLength3];
		for (int i=0;i<unionRepeatedArray.length;i++){
			if(i<arrayLength1){ //0,1
				unionRepeatedArray[i]=arrayFull[0][i];
			} else if(i>=arrayLength1&&i<arrayLength1+arrayLength2){ //2,3
				unionRepeatedArray[i]=arrayFull[1][i-arrayLength1];
			} else if(i>=arrayLength1+arrayLength2){ //4,5
				unionRepeatedArray[i]=arrayFull[2][i-(arrayLength1+arrayLength2)];
			}
		}
		return unionRepeatedArray;
	}
	/*
	shows the elements of the arrangement with the union of the elements
	<b>pre: </b> <br>
	<b>post: </b> shows the elements of the arrangement with the union of the elements
	*/
	public static void showArraysRepeated(){
		int[] array = union(arrayFull,unionRepeatedArray,reader);
		System.out.println("El arreglo con la union tiene los elementos: ");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	/*
	eliminates the repeated elements of the arrangement with the union of the elements
	<b>pre: </b> <br>
	<b>post: </b> shows the elements of the union without repeated elements
	@param arrayFull arrangement where arrangements are stored != null
	@param unionRepeatedArray arrangement with the union of the elements != null
	@param reader Scanner
	*/
	public static void unionNoRep(int[][] arrayFull,int[] unionRepeatedArray,Scanner reader){
		int[] array = union(arrayFull,unionRepeatedArray,reader);
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1;j++){
				if(i!=j){
					if(array[i]==array[j]){
						array[i]=Integer.MIN_VALUE;
					}
				}
			}
		}
		int n=array.length;
		System.out.println("El arreglo con la union tiene los elementos: ");
		for (int k=0;k<=n-1;k++){
			if(array[k]!=Integer.MIN_VALUE){
				System.out.print(array[k]+" ");
			}
		}
	}
	/*
	generates an array with the intersection between two arrays
	<b>pre: </b> <br>
	<b>post: </b> shows the elements that the intersection between two arrays has
	@param arrayFull arrangement where arrangements are stored != null
	@param intersectionArray arrangement with the intersection of the elements != null
	@param reader Scanner
	*/
	public static void intersectionArrays(int[][] arrayFull,int[] intersectionArray,Scanner reader){
		int arrayLength1 = arrayFull[0].length;
		int arrayLength2 = arrayFull[1].length;
		int arrayLength3 = arrayFull[2].length;
		
		int arrayIntersectionLength=0;
		for(int i=0;i<arrayLength1;i++){
			for(int i2=0;i2<arrayLength2;i2++){
				for(int i3=0;i3<arrayLength3;i3++){
					if(arrayFull[0][i]==arrayFull[1][i2]&&arrayFull[0][i]==arrayFull[2][i3]&&arrayFull[1][i2]==arrayFull[2][i3]){
						arrayIntersectionLength++;
					}
				}
			}
		}
		int elements = -1;
		intersectionArray = new int[arrayIntersectionLength];
		for(int i=0;i<arrayLength1;i++){//recorrido de arreglo pequeño
			
			for(int i2=0;i2<arrayLength2;i2++){//recorrido de otro arreglo
				
				for(int i3=0;i3<arrayLength3;i3++){//recorrido del ultmio arreglo
					
					if(arrayFull[0][i]==arrayFull[1][i2]&&arrayFull[0][i]==arrayFull[2][i3]&&arrayFull[1][i2]==arrayFull[2][i3]){
						elements++;
						intersectionArray[elements]=arrayFull[2][i3];
					}
				}
			}
		}
		for(int i=0;i<intersectionArray.length;i++){
			for(int j=0;j<intersectionArray.length-1;j++){
				if(i!=j){
					if(intersectionArray[i]==intersectionArray[j]){
						intersectionArray[i]=Integer.MIN_VALUE;
					}
				}
			}
		}
		int n=intersectionArray.length;
		System.out.println("La interseccion entre los 3 arreglos es: ");
		for (int k=0;k<=n-1;k++){
			if(intersectionArray[k]!=Integer.MIN_VALUE){
				System.out.print(intersectionArray[k]+" ");
			}
		}
	}
	/*
	generates an array by rotating the elements of an array
	<b>pre: </b> <br>
	<b>post: </b> shows the elements with the corresponding rotation
	@param arrayFull arrangement where arrangements are stored != null
	@param rotationArray arrangement with the rotated elements != null
	@param reader Scanner
	*/
	public static void rotationArray(int[][] arrayFull,int[] rotationArray,Scanner reader){
		int arrayIndex = arraySelection(arrayFull,reader);
		int arrayLength = arrayFull[arrayIndex].length;
		
		boolean exit=false;
		int giros=0;
		while(!exit){
			System.out.println("Ingrese un numero entre 1 y "+arrayLength+": ");
			giros = Integer.parseInt(reader.nextLine());
			if(giros>arrayLength||giros<1){
				System.out.println("Ingrese un numero correcto!");
			}else{
				exit=true;
			}
		}
		int[] array = new int[arrayLength];
		for (int i=0;i<arrayLength;i++){
			array[i]=arrayFull[arrayIndex][i];
		}
		for(int i=0;i<arrayLength;i++){
			if((i+giros)<arrayLength){
				arrayFull[arrayIndex][i]=array[i+giros];
			} else {
				arrayFull[arrayIndex][i]=array[(i+giros)-arrayLength];
			}
		}
		System.out.println("El arreglo quedo con el siguiente orden: ");
		for(int i=0;i<arrayLength;i++){
			System.out.print(arrayFull[arrayIndex][i]+" ");
		}
	}
	/*
	orders the elements of an arrangement from lowest to highest
	<b>pre: </b> <br>
	<b>post: </b> shows the arrangement with the ordered elements
	@param arrayFull arrangement where arrangements are stored != null
	@param orderArray arrangement where the elements are stored in an orderly manner != null
	@param reader Scanner
	*/
	public static void orderArray(int[][] arrayFull,int[] orderArray,Scanner reader){
		
		int arrayNumber = arraySelection(arrayFull,reader);
		int arrayLength = arrayFull[arrayNumber].length;

        for (int i = 0; i < arrayLength-1; i++){
            for (int j = 0; j < arrayLength-i-1; j++){
                if (arrayFull[arrayNumber][j] > arrayFull[arrayNumber][j+1]){ 
                    // swap arr[j+1] and arr[i] 
                    int temp = arrayFull[arrayNumber][j]; 
                    arrayFull[arrayNumber][j] = arrayFull[arrayNumber][j+1]; 
                    arrayFull[arrayNumber][j+1] = temp; 
				}
            }
		}
		System.out.println("El arreglo queda de la siguiente forma: ");
		for(int i=0;i<arrayLength;i++){
			System.out.print(arrayFull[arrayNumber][i]+" ");
		}
	}
	//END ARRAY MODE------------------------------
	
	
	public static void main(String[] args){
		VariousOperations();
		
		setSelection(messageModeSelection,modeOptions,reader);
		mode(modeSelection);
	}
	
	
}	