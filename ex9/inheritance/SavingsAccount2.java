package inheritance;

public class SavingsAccount2 extends AbstractAccount{

	private int withdrawals;
	private double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		this.withdrawals = withdrawals;
		this.fee = fee;
	}
	
	@Override
	public void internalWithdraw(double amount) {
		if(balance - amount <= 0){
			throw new IllegalStateException();
		}
		if(withdrawals > 0){
			balance -= amount;
		}
		else{
			if(balance - (amount + fee)  < 0){
				throw new IllegalStateException();
			}
			balance -= (amount + fee);
		}
		withdrawals--;
	}
}
