package projectInsuranceABC.dao;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Account;
import projectInsuranceABC.beans.Client;
import projectInsuranceABC.enums.ClientCredential;
import projectInsuranceABC.exceptions.DataSourceServiceException;
import projectInsuranceABC.exceptions.UnregistredAccountException;
import projectInsuranceABC.exceptions.UnregistredClientException;
import projectInsuranceABC.services.DataSourceService;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс доступа к данным БД для клиента
 */
@Slf4j
public class ClientDAO implements DAO<Client> {

    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    /**
     * Метод для вставки в БД информации о клиенте
     * @param client объект клиент
     */
    @Override
    public void insert(Client client) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ClientQuerier.INSERT_INTO_CLIENT_VALUES)){
            preparedStatement.setString(1, client.getLogin());
            preparedStatement.setString(2, client.getPsswd());
            preparedStatement.setString(3, client.getFirstname());
            preparedStatement.setString(4, client.getSecondname());
            preparedStatement.setString(5, client.getSurname());
            preparedStatement.setInt(6, client.getAccount().getId());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными клиента", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными клиента " + ClientQuerier.INSERT_INTO_CLIENT_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    /**
     * Метод получения объекта клиента из БД по логину и паролю
     * @param lgn логин
     * @param psswd пароль
     * @return объект клиента
     * @throws UnregistredClientException исключение "Незарегистрированный клиент"
     */
    @Override
    public Client get(String lgn, String psswd) throws  UnregistredClientException,UnregistredAccountException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ClientQuerier.SELECT_CLIENT_BY_LGN_AND_PSSWD)) {
            preparedStatement.setString(1, lgn);
            preparedStatement.setString(2, psswd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ClientCredential.ID.getClientCredential());
                String firstName = resultSet.getString(ClientCredential.FIRST_NAME.getClientCredential());
                String secondName = resultSet.getString(ClientCredential.SECOND_NAME.getClientCredential());
                String surname = resultSet.getString(ClientCredential.SURNAME.getClientCredential());
                int accountId = resultSet.getInt(ClientCredential.ACCOUNT_ID.getClientCredential());
                Account account = new AccountDAO().getById(accountId);
                return new Client(id, lgn, psswd, firstName, secondName, surname, account);
            } else {
                throw new UnregistredClientException("Клиент с логином " + lgn + " отсутсвует.");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о клиенте с логином " + lgn, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + ClientQuerier.SELECT_CLIENT_BY_LGN_AND_PSSWD, e);
            return null;
        }  finally {
            dataSourceService.closeConnection();
        }
    }

    /**
     * Метод получения списка всех клиентов
     * @return список всех клиентов
     */
    @Override
    public List<Client> getAll() {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ClientQuerier.SELECT_ALL_CLIENTS)) {
            List<Client> allClients = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(ClientCredential.ID.getClientCredential());
                String firstName = resultSet.getString(ClientCredential.FIRST_NAME.getClientCredential());
                String secondName = resultSet.getString(ClientCredential.SECOND_NAME.getClientCredential());
                String surname = resultSet.getString(ClientCredential.SURNAME.getClientCredential());
                int accountId= resultSet.getInt(ClientCredential.ACCOUNT_ID.getClientCredential());
                AccountDAO accountDAO= new AccountDAO();
                Account account= accountDAO.getById(accountId);
                allClients.add(new Client(id, firstName, secondName, surname));
            }
            return allClients;
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении списка всех клиентов", e);
            return null;
        } catch (SQLException | UnregistredAccountException e) {
            log.error("Ошибка при выполнении запроса " + ClientQuerier.SELECT_ALL_CLIENTS, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
