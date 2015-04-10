package inheritance;

public class SavingsAccount implements Account {

	private double rate;
	private double balance;
	
	public SavingsAccount(double rate) {
		this.rate = rate;
		balance = 0;
	}
	
	@Override
	public void deposit(double amount) {

		if(amount < 0){
			throw new IllegalArgumentException("Please enter a positive amount");
		}
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {

		if(amount < 0){
			throw new IllegalArgumentException("Please enter a positive amount");
		}
		if(balance - amount < 0){
			throw new IllegalStateException("HAHA, shame on you");
		}
		balance -= amount;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public void endYearUpdate(){
		balance *= 1 + rate;
	}
}
