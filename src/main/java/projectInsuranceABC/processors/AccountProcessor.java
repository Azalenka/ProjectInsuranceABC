package projectInsuranceABC.processors;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Account;
import projectInsuranceABC.exceptions.WithdrawalException;

@Slf4j
public class AccountProcessor {

    private static boolean validateWithdrawalSum(int accountSum, int withdrawalSum) throws WithdrawalException {
        log.info("Валидация суммы списания счета");
        if (withdrawalSum <= 0) {
            log.error("Ошибка при списании - сумма списания меньше 0");
            throw new WithdrawalException("Сумма списания счета меньше 0");
        } else if (accountSum < withdrawalSum) {
            log.error("Ошибка при списании - сумма списания больше суммы на счете");
            throw new WithdrawalException("Сумма списания больше суммы счете");
        }
        return true;
    }
    /**
     * Метод списания со счета
     * @param account
     * @param withdrawaslSum
     * @throws WithdrawalException
     */
    public static void withdrawalAccount(Account account, int withdrawaslSum) throws WithdrawalException {
        log.info(String.join(" ", "Списание счета", String.valueOf(account.getAccountNumber()), "на сумму", String.valueOf(withdrawaslSum)));
        validateWithdrawalSum(account.getSum(), withdrawaslSum);
        account.setSum(account.getSum() - withdrawaslSum);
        log.info(String.join(" ", "Списание счета", String.valueOf(account.getAccountNumber()), "прошло успешно. Текущая сумма на счете", String.valueOf(account.getSum())));
    }
}
