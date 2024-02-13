package q1;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fibonnaci of 3:" + fibo(3));
		System.out.println("Fibonnaci of 5:" + fibo(5));
		System.out.println("Fibonnaci of 7:" + fibo(7));
	}
	
	public static long fibo(int n) {
        if (n <= 0) {
            return 0;
        }

        long[] x = new long[n + 1];
        x[0] = 0;
        x[1] = 1;

        for (int i = 2; i <= n; i++) {
            x[i] = x[i - 1] + x[i - 2];
        }

        return x[n];
    }


}
