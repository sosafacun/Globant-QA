import entity.BankAccount;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        BankAccountService baService = new BankAccountService();
        BankAccount bankAccount1 = baService.createBankAccount();
        baService.balanceOperation(bankAccount1);
    }
}