package projectInsuranceABC.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Класс для описания ядра платежной системы
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaySystemCore {
    private List<Account> paySystemAccounts;
    private List<Person> paySystemClients;
    private Map<Client, List<Account>> paySystemClientAccounts;
   
    /**
     * Метод инициализации клиентов и их счетов
     */
    private void initClientAccounts() {
        //TODO реализовать метод инициализации полной информации клиент-счета платежной системы
    }

    /**
     * Метод вывода всех счетов ядра платежной системы
     */
    public void showAllAccounts() {
        //TODO Вывести счета в возрастающем порядке по номеру
        System.out.println("Список всех счетов:");
        for (Account account : paySystemAccounts) {
            System.out.println(account.toString());
        }
        System.out.println();
    }



    }




