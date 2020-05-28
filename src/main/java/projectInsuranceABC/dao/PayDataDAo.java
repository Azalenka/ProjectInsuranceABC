package projectInsuranceABC.dao;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.PayData;
import projectInsuranceABC.exceptions.DataSourceServiceException;
import projectInsuranceABC.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Slf4j

public class PayDataDAo implements  DAO<PayData> {


    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(PayData payData) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PayDataQuerier.INSERT_INTO_PAY_DATA_VALUES)){
            preparedStatement.setInt(1, payData.getClient().getId());
            preparedStatement.setString(2, payData.getTargetAccount());
            preparedStatement.setInt(3, payData.getSum());
            preparedStatement.setTimestamp(4, new Timestamp(payData.getDate().getTime()));

            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными оплаты", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными клиента " + PayDataQuerier.INSERT_INTO_PAY_DATA_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public PayData get(String firstParam, String secondParam) throws Exception {
        return null;
    }
}
