package projectInsuranceABC.servlets;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Client;
import projectInsuranceABC.dao.ClientDAO;
import projectInsuranceABC.enums.ClientCredential;
import projectInsuranceABC.enums.Page;
import projectInsuranceABC.exceptions.UnregistredAccountException;
import projectInsuranceABC.exceptions.UnregistredClientException;
import projectInsuranceABC.utils.ServletUtil;
import projectInsuranceABC.utils.SessionUtil;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Сервлет для аутентификации пользователя
 */
@Slf4j
@WebServlet(name="auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @throws IOException ошибка перенаправления на другую страницу
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        ClientDAO clientDAO = new ClientDAO();
        Client client = null;
        try {
            client = clientDAO.get(clientLogin, clientPsswd);
            if (client == null) {
                //TODO Вывести на GUI предупреждение "Проблемы с БД, обратитесь к администратору"
            }
        } catch (UnregistredClientException | UnregistredAccountException e) {
            //TODO Вывести на GUI предупреждение с незарегистрирвоным клиентом
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_AUTH_PAGE.getPage());
    }
}
