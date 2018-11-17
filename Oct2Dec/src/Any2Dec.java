import java.util.Scanner;
import java.util.StringTokenizer;

public class Any2Dec {
	public static void main(String[] args) {
		Any2Dec a = new Any2Dec();
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, "//");
		String n = st.nextToken();
		String base = st.nextToken();
		System.out.println(n + " " + base);
		System.out.println(a.convertAnyToDec(n, base));
	}

	public double convertAnyToDec(String n, String base) {
		double dec = 0;
		int bas = Integer.parseInt(base);
		StringTokenizer st = new StringTokenizer(n, ".");
		int leng = st.countTokens();
		String phanNguyen = st.nextToken().trim();
		char[] n1 = phanNguyen.toCharArray();
		for (int i = 1; i <= n1.length; i++) {
			switch (bas) {
			case 2:
				if (n1[i - 1] == 1) {
					dec += Math.pow(2, n1.length - i);
				}
				break;
			case 16:
			case 8:
				if (n1[i - 1] <= '9' && n1[i - 1] >= '0') {
					dec += (n1[i - 1] - '0') * Math.pow(bas, n1.length - i);
				} else {
					if ((n1[i - 1] >= 'a' && n1[i - 1] <= 'f')) {
						dec += (n1[i - 1] - 'a' + 10) * Math.pow(16, n1.length - i);
					} else {
						if ((n1[i - 1] <= 'F' && n1[i - 1] >= 'A')) {
							dec += (n1[i - 1] - 'A' + 10) * Math.pow(16, n1.length - i);
						} else {
							break;
						}
					}
				}
				break;

			default:
				System.out.println("Khong the chuyen doi dc");
				break;
			}
		}
		if (leng == 2) {
			String phanDu = st.nextToken().trim();
			char[] n2 = phanDu.toCharArray();
			for (int i = 1; i <= n2.length; i++) {
				int coso = (int) (n2[i - 1] - '0');
				dec += coso * ((double) 1 / (Math.pow(bas, i)));
			}
		}
		return dec;
	}
}
