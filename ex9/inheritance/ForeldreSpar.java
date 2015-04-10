package inheritance;

public class ForeldreSpar extends SavingsAccount {

	private int withdrawslimit;
	private int withdrawsCounter;
	
	public ForeldreSpar(double rate, int withdrawslimit) {
		super(rate);
		this.withdrawslimit = withdrawslimit;
		withdrawsCounter = 0;
	}
	
	public int getRemainingWithdrawals(){
		return withdrawslimit - withdrawsCounter;
	}
	
	@Override
	public void withdraw(double amount) {
		if(withdrawslimit <= withdrawsCounter){
			
			throw new IllegalStateException("Test");
		}
		else{
			super.withdraw(amount);
			withdrawsCounter++;
		}
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		withdrawsCounter = 0;
	}

}
