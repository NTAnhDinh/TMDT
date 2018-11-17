import java.util.Scanner;
import java.util.StringTokenizer;

public class Oct2Dec {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data: ");
		String num = sc.nextLine();
		Oct2Dec o = new Oct2Dec();
		o.convert(num);
	}

	public void convert(String n) {
		StringTokenizer st = new StringTokenizer(n, ".");
		double dec = 0;
		int sopt= st.countTokens();
		String phanNguyen = st.nextToken().trim();

		char[] n1 = phanNguyen.toCharArray();
//		System.out.println((n1[0] -'0' )==2 );
		for (int i = 1; i <= n1.length; i++) {
			int coso = (int)( n1[i-1]- '0') ;
			dec += coso * Math.pow(8, n1.length - i);
		}
		if (sopt> 1) {
			String phanDu = st.nextToken().trim();
			char[] n2 = phanDu.toCharArray();
			for (int i = 1; i <= n2.length; i++) {
				int coso = (int)(n2[i-1] - '0');
				dec += coso * ((double) 1 / (Math.pow(8, i)));
			}
		}
		System.out.println(dec);
	}
}
