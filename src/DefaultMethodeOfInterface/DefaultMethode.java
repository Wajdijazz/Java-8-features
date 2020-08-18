package DefaultMethodeOfInterface;

public class DefaultMethode {

	interface Formula {
		double calculate(int a);

		default double sqrt(int a) {
			return Math.sqrt(positive(a));
		}

		static int positive(int a) {
			return a > 0 ? a : 0;
		}
	}

	public static void main(String[] args) {
		Formula formula1 = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		System.out.println("***test****");

		formula1.calculate(2000); // 100.0
		formula1.sqrt(-23); // 0.0
		Formula.positive(-4); // 0.0

	}

}
