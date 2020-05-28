package projectInsuranceABC.servlets;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Account;
import projectInsuranceABC.beans.Client;
import projectInsuranceABC.dao.AccountDAO;
import projectInsuranceABC.dao.ClientDAO;
import projectInsuranceABC.enums.ClientCredential;
import projectInsuranceABC.enums.Page;
import projectInsuranceABC.exceptions.UnregistredAccountException;
import projectInsuranceABC.exceptions.UnregistredClientException;
import projectInsuranceABC.utils.ServletUtil;
import projectInsuranceABC.utils.SessionUtil;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Сервлет для страницы регистрации
 */
@Slf4j
@WebServlet(name = "regClient", urlPatterns = "/regClient")
public class RegClientServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //TODO добавить выходи из профиля
        //TODO доработать пробоброс на страницу ошибок
        Map<String, String> clientCredentials = SessionUtil.readClientCredentials(httpServletRequest);
        AccountDAO accountDAO = new AccountDAO();
        List<Account> allAccountNumbers = accountDAO.getAll();
        int accountNumber;
        Account currentAccount;
        do {
            accountNumber = ThreadLocalRandom.current().nextInt(10000, 99999);
            currentAccount = new Account(accountNumber);
        } while (allAccountNumbers.contains(currentAccount));
        accountDAO.insert(currentAccount);
        try {
            currentAccount = accountDAO.get(String.valueOf(accountNumber));
        } catch (Exception e) {
            log.error("Ошибка при попытке получить объект счета по номеру " + accountNumber);
            //TODO обработать исключение
        }
        //TODO Добавить валидацию введенных данных пользователем
        Client client = new Client(
                clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                clientCredentials.get(ClientCredential.PSSWD.getClientCredential()),
                clientCredentials.get(ClientCredential.FIRST_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SECOND_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SURNAME.getClientCredential()),
                currentAccount);
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(client);
        HttpSession httpSession = httpServletRequest.getSession();

        try {
            client = clientDAO.get(clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                    clientCredentials.get(ClientCredential.PSSWD.getClientCredential()));
        } catch (UnregistredClientException | UnregistredAccountException e) {
            //TODO Обработать исключение
        }
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
    }
}
