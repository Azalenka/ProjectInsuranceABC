package projectInsuranceABC.utils;

import projectInsuranceABC.beans.Account;
import projectInsuranceABC.beans.Client;
import projectInsuranceABC.dao.AccountDAO;
import projectInsuranceABC.enums.ClientCredential;
import projectInsuranceABC.exceptions.UnregistredAccountException;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Утилитный класс для работы с сессией
 */
public class SessionUtil {

    /**
     * Метод для считывания аутентификационных данных
     * @param httpServletRequest запрос
     * @return мапа с аутентификационными данными
     */
    public static Map<String, String> readClientCredentials(HttpServletRequest httpServletRequest) {
        Map<String, String> result = new HashMap<>();
        String clientFirstName = httpServletRequest.getParameter(ClientCredential.FIRST_NAME.getClientCredential());
        String clientSecondName = httpServletRequest.getParameter(ClientCredential.SECOND_NAME.getClientCredential());
        String clientSurname = httpServletRequest.getParameter(ClientCredential.SURNAME.getClientCredential());
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        result.put(ClientCredential.FIRST_NAME.getClientCredential(), clientFirstName);
        result.put(ClientCredential.SECOND_NAME.getClientCredential(), clientSecondName);
        result.put(ClientCredential.SURNAME.getClientCredential(), clientSurname);
        result.put(ClientCredential.LOGIN.getClientCredential(), clientLogin);
        result.put(ClientCredential.PSSWD.getClientCredential(), clientPsswd);
        return result;
    }

    /**
     * Метод заполнения сессии данными
     * @param httpSession сессия
     * @param client клиент
     */
    public static void fillSession(HttpSession httpSession, Client client) {
        httpSession.setAttribute(ClientCredential.ID.getClientCredential(), client.getId());
        httpSession.setAttribute(ClientCredential.FIRST_NAME.getClientCredential(), client.getFirstname());
        httpSession.setAttribute(ClientCredential.SECOND_NAME.getClientCredential(), client.getSecondname());
        httpSession.setAttribute(ClientCredential.SURNAME.getClientCredential(), client.getSurname());
        httpSession.setAttribute(ClientCredential.LOGIN.getClientCredential(), client.getLogin());
        httpSession.setAttribute(ClientCredential.PSSWD.getClientCredential(), client.getPsswd());
        httpSession.setAttribute(ClientCredential.ACCOUNT_ID.getClientCredential(), client.getAccount().getId());
        httpSession.setMaxInactiveInterval(300);
    }
     public static Client getClientFromSession(HttpSession httpSession) throws UnregistredAccountException {
         AccountDAO accountDAO= new AccountDAO();
         Account account= accountDAO.getById((int) httpSession.getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
        return new Client(
                (int) httpSession.getAttribute(ClientCredential.ID.getClientCredential()),
         (String) httpSession.getAttribute(ClientCredential.FIRST_NAME.getClientCredential()),
                (String) httpSession.getAttribute(ClientCredential.SECOND_NAME.getClientCredential()),
                (String) httpSession.getAttribute(ClientCredential.SURNAME.getClientCredential()),
                account);
     }
}
