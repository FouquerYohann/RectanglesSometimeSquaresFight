package contract.util;

public class InvariantError extends ContractError {

	private static final long	serialVersionUID	= -7368441109344944476L;

	public InvariantError(String service,String message) {
		super(service, "checkInvariant", message);
	}

}
