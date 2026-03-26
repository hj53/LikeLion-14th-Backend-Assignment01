public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String owner, int balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        System.out.println("이자가 추가되었습니다.");
    }

    @Override
    public void showInfo(){
        System.out.println("예금주: "+getOwner()+", 잔액: "+getBalance()+", 이자율: "+interestRate);
    }
}
