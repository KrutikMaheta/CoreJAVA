package lambda;

interface myfunc{
	int func(int n);
}

public class VarCapture {

	public static void main(String[] args) {
		final int num = 10;
		myfunc myLambda = (n) -> {
			int v = num + n;
			++n;
			return 0;
		};
		System.out.println("num is: "+ num );
		//num = 9;
		System.out.println("num is: "+ num );
	}

}
