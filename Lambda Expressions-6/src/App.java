interface IntExecutable {
	int check(int a);
}

interface StringExecutable {
	String check(String a);
}

interface ManyParamsExecutable {
	int check(int a, int b);
}


//---------------------------------------------------------------------

class Runner {
	
	public void run(IntExecutable e){
		System.out.println("Executing code block ...");
		int value = e.check(12);
		System.out.println("Value: " + value*100);
	}
	
	public void run(StringExecutable e){
		System.out.println("Executing code block ...");
		String value = e.check("Warszawa");
		System.out.println("Value: " + value);
	}
	
	public void run(ManyParamsExecutable e){
		System.out.println("Executing code block ...");
		int value = e.check(12, 13);
		System.out.println("Value: " + value*100);
	}
}

//---------------------------------------------------------------------

public class App {

	public static void main(String[] args) {

		Runner runner = new Runner();
		
		System.out.println("=================depricated (java 1.6 - 1.7)=======================");
		
		runner.run(
			/*implementing object interface Executable*/ new ManyParamsExecutable() {
			 
			@Override
			public int check(int a, int b) {
				System.out.println("check: Hello there.");
				return 1+a+b;   //1+12+13
			}
 
			}
					 );
		
		System.out.println("==================Lambda (java 1.8)======================");
	 
		runner.run(/*implementing object interface Executable*/ 
					(int a) -> {
							System.out.println("Lambda expression2");
							System.out.println("Lambda expression3");
							return a+2;  //12+2
						  } 
				  );
		 
		runner.run(/*implementing object interface Executable*/ 
				(int a) -> a+3   //12+3
			  );
		
		runner.run(/*implementing object interface Executable*/ 
				(int a) -> {
							return a+4;  //12+4
							} 
			  );
  
		runner.run(/*implementing object interface Executable*/ 
				(int a) -> a+5   //12+5
			  );
		
		runner.run(/*implementing object interface Executable*/ 
				(int a, int b) -> a+b+6   //12+13+6
			  );
		
		runner.run(/*implementing object interface Executable*/ 
				(a,b) -> a+b+7   //12+13+7
			  );
		
		
		StringExecutable strExec = (a) -> {
					return a+" "+"Kraków";
			};
		
			runner.run(strExec);
	}

}
