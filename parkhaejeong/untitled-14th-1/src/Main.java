import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
interface Chargeable {
    void applyFee();
}

class BankAccounts implements Chargeable{
    // ... 기존 필드와 메서드 생략
    private String owner; // 예금주
    private int balance; // 잔액

    //생성자
    BankAccounts(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }
    //getter (은닉된 데이터에 접근할 수 있는 통로)
    public String getOwner(){
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    //setter (이름 개명 시 사용)
    public void setOwner(String owner){
        this.owner = owner;
    }

    // 메서드
    //기존 입금 메서드
    public void deposit(int amount) {
        balance += amount;
    }

    //오버로딩 : 금액과 함께 입금 메시지(메모)를 남기는 기능
    public void deposit(int amount, String message) {
        balance += amount;
        System.out.println(message + " 메모와 함께 " + amount + "원 입금 완료");
    }

    public void showInfo() {
        System.out.println("예금주: " + owner + ", 잔액: " + balance);
    }

    @Override
    public void applyFee(){
        System.out.println("일반 계좌 이체 수수료 500원 차감");
    }
}

class VIPAccount extends BankAccounts {
    public VIPAccount(String owner, int balance) {
        super(owner, balance);
    }

    @Override
    public void applyFee() {
        System.out.println("VIP 계좌는 이체 수수료 면제");
    }
}



class BankAccount {
    private String owner; // 예금주
    private int balance; // 잔액

    //생성자
    BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }
    //getter (은닉된 데이터에 접근할 수 있는 통로)
    public String getOwner(){
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    //setter (이름 개명 시 사용)
    public void setOwner(String owner){
        this.owner = owner;
    }

    // 메서드
    //기존 입금 메서드
    public void deposit(int amount) {
        balance += amount;
    }

    //오버로딩 : 금액과 함께 입금 메시지(메모)를 남기는 기능
    public void deposit(int amount, String message) {
        balance += amount;
        System.out.println(message + " 메모와 함께 " + amount + "원 입금 완료");
    }

    public void showInfo() {
        System.out.println("예금주: " + owner + ", 잔액: " + balance);
    }
}

// 자식 클래스
class SavingsAccount extends BankAccount {
    private double interestRate; // 이자율 (적금 계좌만의 고유 필드)

    public SavingsAccount(String owner, int balance, double interestRate) {
        super(owner,balance); // 부모의 생성자 호출
        this.interestRate = interestRate;
    }

    public void addInterest() {
        System.out.println("이자가 추가되었습니다.");
    }

    // 메서드 오버라이딩
    @Override
    public void showInfo() {
        // 부모의 private 필드에 접근하기 위해 getter 사용
        System.out.println("예금주: " + getOwner() + ", 잔액: " + getBalance() +", 이자율: " + interestRate);
    }
}



public class Main {
    public static void main(String[] args) {
        // List (배열처럼 순서대로 데이터 저장)
        ArrayList<BankAccount> bankList = new ArrayList<>();
        bankList.add(new BankAccount("홍길동", 10000));
        bankList.add(new SavingsAccount("김철수", 50000,0.05));

        for (BankAccount acc : bankList) {
            acc.showInfo();
        }

        System.out.println("=============");

        Map<String, String> userMap = new HashMap<>();

        userMap.put("name", "아기사자");
        userMap.put("role", "백엔드 개발자");

        System.out.println("이름: " + userMap.get("name"));











        // 예외처리
        BankAccount myAccount = new BankAccount("홍길동", 10000);

        try{
            int withdrawAmount = 50000;

            // getter를 사용하여 안전하게 잔액 확인
            if(withdrawAmount > myAccount.getBalance()) {
                // 잔액 부족 시 강제로 에러 발생시킴
                throw new Exception("잔액이 부족합니다.");
            }
            System.out.println("출금 성공");

        } catch (Exception e) {
            System.out.println("출금 실패 사유: " + e.getMessage());
        }



        //인터페이스
        BankAccounts[] accountss = {
                new BankAccounts("일반회원", 10000),
                new VIPAccount("우수회원", 5000)
        };

        for (BankAccounts account : accountss) {
            account.applyFee();
        }

        //업캐스팅 활용 :  여러 종류의 계좌를 부모 타입 배열 하나로 묶어서 관리
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("일반인", 10000); // 객체로 선언해야 굴러감.
        accounts[1] = new SavingsAccount("홍길동", 10000, 0.05); // 업캐스팅 발생

        // 다형성 동작 : 반복문 한 번으로 모든 계좌 정보 출력
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("---[" + i +"]번 계좌 처리 ---");
            BankAccount currentAccount = accounts[i];
            currentAccount.showInfo();

            // 다운캐스팅 필요성
            //currentAccount.addInterst(); -> 에러 발생 (부모 클래스엔 이 기능 없어서)
            if (currentAccount instanceof SavingsAccount) {
                //원래 자식 타입으로 강제 변환_다운캐스팅
                SavingsAccount realAccount = (SavingsAccount) currentAccount;

                //자식 클래스의 고유 기능 사용 가능
                realAccount.addInterest();
                System.out.println("다운캐스팅 성공: 이자 추가 완료");
            } else {
                System.out.println("일반 계좌이므로 이자 추가 기능 없음");
            }

            //부모 클래스로 선언했지만
            // 자식이 오버라이딩한 최신 기능이 알아서 실행됨
//            accounts[i].showInfo();
        }

        /*
        BankAccount account = new BankAccount("홍길동", 10000);
        account.showInfo();

        account.setOwner("박해정");
        account.showInfo();

        account.deposit(5000);
        account.deposit(5000,"Memo");
        account.showInfo();
        */

        /*
        // private 설정 전
        account.deposit(5000); // 메서드 테스트
        System.out.println("예금주: " + account.owner + " / 잔액: " + account.balance);

        account.deposit(5000, "메모 예시"); // 메서드 테스트
        System.out.println("예금주: " + account.owner + " / 잔액: " + account.balance);
         */



        /*
        // 실습1
        int age = 25;
        boolean isStudent = true;
        char grade = 'A';
        double GPA = 3.78;

        System.out.println(age);
        System.out.println(isStudent);
        System.out.println(grade);
        System.out.println(GPA);
        */

        /*
        // 배열
        String name = "박해정";
        System.out.println(name);

        // 타입[] 변수 = new 타입[길이]
        int[] num = new int[5];

        // 변수 = new 타입[] {값0, 값1, 값2, 값3, 값4 ..}
        int[] fibonacci = new int[] {1,1,2,3,6};
         */

        /*
        //if-else
        // 타입[] 변수 = new 타입[길이]
        int[] num = new int[5];

        // 변수 = new 타입[] {값0, 값1, 값2, 값3, 값4 ..}
        int[] fibonacci = new int[] {1,1,2,3,6};


        if (fibonacci[4] == 5) {
            System.out.println("이 수열은 올바릅니다.");
        }
        else {
            System.out.println("피보나치 수열의 5번째 값은 5입니다.");
        }
         */

        /*
        //for
        String[] timetable = {"머신러닝", "컴퓨터버전", "데이터기초수학", "심층신경망"};

        for (int idx = 0; idx < timetable.length; idx++){
            System.out.println(timetable[idx]);
        }

        for (String str: timetable) {
            System.out.println(str);
        }
         */
    }
}

