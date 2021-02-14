public class game {
	int size = 1000000;

	String[] strArr = new String[size];
	int[] intArr = new int[size];

	String[] strRe = new String[size];
	int[] intRe = new int[size];

	int[] sum = new int[size];
	String[] sumStr = new String[size];

	int[] sub = new int[size];
	String[] subStr = new String[size];

	int count = 0;
	int max = 0;
	int min = 1000000;

	public void run() {

		for (int i = 111111; i <= 999999; i++) {

			String temp = Integer.toString(i);

			if (!temp.contains("0") && i > Integer.parseInt(reverse(temp))) {
				strArr[i] = temp; //here is String
				intArr[i] = i; //here is int

				strRe[i] = reverse(temp); //the Reverse String
				intRe[i] = Integer.parseInt(strRe[i]); //the Reverse int

				sum[i] = intArr[i] + intRe[i]; //sum int
				sub[i] = intArr[i] - intRe[i]; //sub int

				sumStr[i] = String.valueOf(sum[i]); //sum String
				subStr[i] = String.valueOf(sub[i]); //sub String
			}

			if (intArr[i] != 0 && sumStr[i].length() == 6 && subStr[i].length() == 6 && uniq(sumStr[i])
					&& uniq(subStr[i])) {

				max = Math.max(intArr[i], max);
				min = Math.min(intArr[i], min);
				count++;

				System.out.println("The Number is : " + intArr[i] + " | The Inverse : " + intRe[i] + " | Sum : "
						+ sum[i] + " | Sub : " + sub[i]);
			}
		}
		System.err.println("The Counter   : " + count);
		System.err.println("The Max       : " + max);
		System.err.println("The Min       : " + min);
	}

	// Method for reverse the String "abc" -> "cba"
	public static String reverse(String input) {
		String output = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			output = output + input.charAt(i);
		}
		return output;
	}

	// Method for checking the duplicate Ali = true , Mohammed = false
	public static boolean uniq(String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (input.indexOf(c) != input.lastIndexOf(c)) {
				return false;
			}
		}
		return true;
	}
}