package contract.util;

public class PreconditionError extends ContractError {

	private static final long	serialVersionUID	= -3400146200096149992L;

	public PreconditionError(String service, String method, String message) {
		super(service, method, message);
	}

}
