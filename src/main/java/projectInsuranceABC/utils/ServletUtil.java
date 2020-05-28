package projectInsuranceABC.utils;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.enums.Page;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Утилитный класс для сервлетов
 */
@Slf4j
public class ServletUtil {

    /**
     * Метод перенаправления из сервлета на страницу
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @param pageCommad страница
     */
    public static void redirectInsideServlet(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            String pageCommad) {
        try {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + pageCommad);
        } catch (IOException e) {
            try {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Page.ERROR_PAGE.getPage());
            } catch (IOException e1) {
                log.error("Ошибка при попытке перенаправить на страницу с ошибкой", e1);
            }
        }
    }
}
