package inheritance;

public class CreditAccount extends AbstractAccount{

	private double creditLine;
	
	public CreditAccount(double creditLine) {
		setCreditLine(creditLine);
	}
	
	public double getCreditLine() {
		return creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		if(creditLine < 0){
			throw new IllegalArgumentException();
		}
		else if(balance < 0 && creditLine < Math.abs(balance) ){
			throw new IllegalStateException();
		}
		else
			this.creditLine = creditLine;
	}

	@Override
	public void internalWithdraw(double amount) {
		if(balance - amount < - creditLine){
			throw new IllegalStateException();
		}
		else 
			balance -= amount;
	}
	
}
