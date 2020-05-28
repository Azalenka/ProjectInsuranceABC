package projectInsuranceABC.dao;

public class ClientQuerier {
    /**
     * SQL-запрос для вставки в БД информации о клиенте
     */
    protected static final String INSERT_INTO_CLIENT_VALUES = "INSERT INTO PAYINSURANCE.PAYINSURANCE.CLIENT (LOGIN, PSWD, FIRSTNAME, SECONDNAME, SURNAME, ACCOUNT_ID) VALUES (?,?,?,?,?,?)";
    /**
     * SQL-запрос для получения из БД информации о клиенте по логину и паролю
     */
    protected static final String SELECT_CLIENT_BY_LGN_AND_PSSWD = "SELECT * FROM PAYINSURANCE.PAYINSURANCE.CLIENT WHERE LOGIN = ? AND PSWD = ?";
    /**
     * SQL-запрос для получения из БД информацию со списком всех клиентов
     */
    protected static final String SELECT_ALL_CLIENTS = "SELECT * FROM PAYINSURANCE.PAYINSURANCE.CLIENT";

    protected static final String SELECT_CLIENT_BY_ID = "SELECT * FROM PAYINSURANCE.PAYINSURANCE.CLIENT WHERE ID = ?";
}
