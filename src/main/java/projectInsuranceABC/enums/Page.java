package projectInsuranceABC.enums;

/**
 * Перечисление, содержащие страницы для навигации
 */
public enum Page {
    /**
     * Главная страница
     */
    INDEX_PAGE("index.jsp"),
    /**
     * Страница регистрации
     */
    REG_PAGE("/views/registration.jsp"),
    /**
     * Страница успешной регистрации
     */
    SUCCESS_REG_PAGE("/views/successRegClient.jsp"),

    BASKET_WITH_PRODUCTS("basketWithProducts.jsp"),
    /**
     * Страница аутентификации
     */
    AUTH_PAGE("/views/auth.jsp"),
    /**
     * Страница успешной аутентификации
     */
    SUCCESS_AUTH_PAGE("/views/successAuthClient.jsp"),
    /**
     * Страница с ошибкой
     */
    ERROR_PAGE("/views/error.jsp");

    /**
     * Поле страница
     */
    private String page;

    /**
     * Конструктор с полем названия страницы
     *
     * @param page название страницы
     */
    Page(String page) {
        this.page = page;
    }

    /**
     * Геттер названия страницы
     *
     * @return адрес страницы
     */
    public String getPage() {
        return page;
    }
}
