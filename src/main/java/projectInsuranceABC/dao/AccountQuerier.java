package projectInsuranceABC.dao;

public class AccountQuerier {
    /**
     * SQL-запрос для получения из БД информации о счете по идентификатору
     */
    protected static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM PAYINSURANCE.PAYINSURANCE.ACCOUNT WHERE ID = ?";
    /**
     * SQL-запрос для получения из БД информации о всех счетах
     */
    protected static final String SELECT_ALL_ACCOUNT_NUMBERS = "SELECT * FROM PAYINSURANCE.PAYINSURANCE.ACCOUNT";
    /**
     * SQL-запрос для получения из БД информации о счете по его номеру
     */
    protected static final String SELECT_ACCOUNT_BY_ACCOUNT_NUMBER = "SELECT * FROM PAYINSURANCE.PAYINSURANCE.ACCOUNT WHERE ACCOUNT_NUMBER = ?";
    /**
     * SQL-запрос для вставки в БД информации о счете
     */
    protected static final String INSERT_ACCOUNT_INFO = "INSERT INTO PAYINSURANCE.PAYINSURANCE.ACCOUNT (ACCOUNT_NUMBER) VALUES (?)";
    /**
     * SQL-запрос для обновления в БД информации о сумме на счете по идентификатору
     */
    protected static final String UPDATE_ACCOUNT_SUM = "UPDATE PAYINSURANCE.PAYINSURANCE.ACCOUNT SET SUM = ? WHERE ID = ?";

}
