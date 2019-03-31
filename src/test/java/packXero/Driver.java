package packXero;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException, InterruptedException {
		AutomationScripts as = new AutomationScripts();
		as.testID01_A();
		as.testID01_B();
		as.testID01_C();
		as.testID01_D();
		
		//as.testID02_A();
		as.testID02_B();
		as.testID02_C();
		as.testID02_E();
		
		as.testID03_A();
		as.testID04_A();
		//as.testID06_A();--------------
		//as.testID08_A();
		//as.testID08_B();
		//as.testID08_F();
		as.testID010_A();

	}

}
