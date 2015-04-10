package inheritance;


public class BSU extends SavingsAccount{

	private double maxAnnualDeposit;
	private double depositThisYear;
	
	
	public BSU(double rate, double maxAnnualDeposit) {
		super(rate);
		this.maxAnnualDeposit = maxAnnualDeposit;
		depositThisYear = 0;
	}
	
	public double getTaxDeduction(){
		return depositThisYear * 0.2;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		depositThisYear = 0;
	}
	
	@Override
	public void deposit(double amount) {
		if(depositThisYear + amount > maxAnnualDeposit){
			throw new IllegalStateException("hei");
		}
		else {
			super.deposit(amount);
			depositThisYear += amount;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		if(depositThisYear - amount > 0){
			super.withdraw(amount);
			depositThisYear -= amount;
		}
		else
			throw new IllegalStateException();
	}
	

}
