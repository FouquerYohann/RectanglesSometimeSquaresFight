package contract.util;

public abstract class ContractError extends Error {
	private String				service;
	private String				method;
	private static final long	serialVersionUID	= -7850794117530849145L;

	public ContractError(String service, String method, String message) {
		super(message);
		this.service=service;
		this.method=method;
	}
	
	@Override
	public String getMessage() {
		String ret=this.getClass().getName()+" In "+method+" of "+service+": ";
		return ret+super.getMessage();
	}
}
