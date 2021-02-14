public class see {
	public void run() {
		int counter = 0;
		int max = 0;
		int min = 1000000;
		for (int i = 111111; i <= 999999; i++) {
			String temp = Integer.toString(i);
			if (!temp.contains("0")) {
				int[] a = intToIntArray(i);
				int[] b = reversArray(a);
				String s0 = "";
				String s1 = "";
				for (int j = 0; j < a.length; j++) {
					s0 = s0 + Integer.toString(a[j]);
				}
				for (int j = 0; j < b.length; j++) {
					s1 = s1 + Integer.toString(b[j]);
				}
				int i0 = Integer.parseInt(s0);
				int i1 = Integer.parseInt(s1);
				if (i0 > i1) {
					if (Integer.toString(i0 + i1).length() == 6 && Integer.toString(i0 - i1).length() == 6
							&& uniq(Integer.toString(i0 + i1)) == true && uniq(Integer.toString(i0 - i1)) == true) {

						max = Math.max(i0, max);
						min = Math.min(i0, min);
						counter++;
						System.out.println("The Number is : " + i0 + " | The Inverse : " + i1 + " | Sum : "
								+ Integer.toString(i0 + i1) + " | Sub : " + Integer.toString(i0 - i1));
					}
				}
			}
		}

		System.err.println("The Counter   : " + counter);
		System.err.println("The Max       : " + max);
		System.err.println("The Min       : " + min);
	}

	int[] intToIntArray(int wert) {
		String temp = Integer.toString(wert);
		int[] newArray = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			newArray[i] = temp.charAt(i) - '0';
		}
		return newArray;
	}

	static int[] reversArray(int[] arr) {
		int b[] = new int[arr.length];
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			b[i] = arr[arr.length - i - 1];
			b[arr.length - i - 1] = temp;
		}
		return b;
	}

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