package maintest;

import contract.util.InvariantError;

public class TestException {

	public static void main(String[] args) {
		try {

			throw new InvariantError("service","message");
		} catch (Throwable t) {
//			t.printStackTrace();
			System.out.println(t.getMessage());
		}

	}

}
