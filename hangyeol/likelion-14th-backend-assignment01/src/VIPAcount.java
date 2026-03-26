public class VIPAcount extends BankAccount{

    public VIPAcount(String owner, int balance) {
        super(owner, balance);
    }

    @Override
    public void applyFee(){
        System.out.println(getOwner()+" VIP 계좌는 이체 수수료 면제");
    }
}
