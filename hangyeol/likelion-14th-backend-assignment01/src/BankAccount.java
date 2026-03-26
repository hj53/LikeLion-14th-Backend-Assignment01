public class BankAccount implements Chargeable{
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount){
        balance+=amount;
        System.out.println(amount+"원이 입금 완료");
    }

    public void deposit(int amount, String message){
        balance+=amount;
        System.out.println(message+" 메모와 함께 "+amount+"원 입금 완료");
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void showInfo(){
        System.out.println("예금주: "+owner+", 잔액: "+balance);
    }

    @Override
    public void applyFee(){
        System.out.println("일반 계좌 이체 수수료 500원 차감");
    }
}
