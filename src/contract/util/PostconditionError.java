package contract.util;

public class PostconditionError extends ContractError {

	private static final long	serialVersionUID	= -2168606788014026088L;

	public PostconditionError(String service, String method, String message) {
		super(service, method, message);
	}

}
