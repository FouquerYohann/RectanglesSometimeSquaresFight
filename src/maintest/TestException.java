package maintest;

import contract.util.ContractError;
import contract.util.InvariantError;
import contract.util.PostconditionError;
import contract.util.PreconditionError;

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
