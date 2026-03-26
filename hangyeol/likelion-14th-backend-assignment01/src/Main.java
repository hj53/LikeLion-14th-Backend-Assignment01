import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
//        int age =25;
//        boolean isStudent = true;
//        char grade = 'A';
//        double GPA = 3.78;
//
//        System.out.println(age);
//        System.out.println(isStudent);
//        System.out.println(grade);
//        System.out.println(GPA);

//        String name ="김한결";
//        System.out.println("name = " + name);
//        int[] num = new int[5];
//        int[] fibonacci = new int[] {1,1,2,3,6};
//
//        if(fibonacci[4]==5){
//            System.out.println("이 수열은 올바릅니다.");
//        } else {
//            System.out.println("피보나치 수열의 5번째 값은 5입니다.");
//        }

//        String[] timetable = {"머신러닝","컴퓨터비전", "데이터기초수학", "심층신경망", "현대사회와법1", "알고리즘"};
//        for (int i = 0; i < timetable.length; i++) {
//            System.out.println(timetable[i]);
//        }
//        for (String str : timetable) {
//            System.out.println(str);
//        }

//        BankAccount account = new BankAccount("홍길동", 10000);

//        account.deposit(5000);
//        System.out.println("예금주: "+ account.owner+" / 잔액: "+account.balance); x
//        System.out.println("예금주: "+ account.getOwner()+" / 잔액: "+account.getBalance());
//        account.deposit(5000, "메모 예시");
//        System.out.println("예금주: "+ account.owner+" / 잔액: "+account.balance); x
//        System.out.println("예금주: "+ account.getOwner()+" / 잔액: "+account.getBalance());

//        account.showInfo();
//        account.setOwner("김한결");
//        account.showInfo();
//        account.deposit(5000);
//        account.deposit(5000,"Memo");
//        account.showInfo();

//        BankAccount[] accounts = {
//                new BankAccount("일반회원", 10000),
//                new VIPAcount("우수회원", 50000)
//        };
//
//        for (BankAccount account : accounts) {
//            account.applyFee();
//        }

//

        ArrayList<BankAccount> bankList = new ArrayList<>();
        bankList.add(new BankAccount("홍길동", 10000));
        bankList.add(new SavingsAccount("김철수", 50000, 0.05));
        for (BankAccount account : bankList) {
            account.showInfo();
        }

        System.out.println("==================================");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", "아기사자");
        userMap.put("role", "벡엔드 개발자");

        System.out.println("이름: "+userMap.get("name"));
    }
}
