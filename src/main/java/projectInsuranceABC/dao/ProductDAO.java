package projectInsuranceABC.dao;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Product;
import projectInsuranceABC.exceptions.DataSourceServiceException;
import projectInsuranceABC.exceptions.NotFoundProductException;
import projectInsuranceABC.services.DataSourceService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Slf4j
public class ProductDAO implements DAO<Product> {

    private DataSourceService dataSourceService = new DataSourceService();




    public Product get(String product, int price) throws NotFoundProductException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ProductQuerier.SELECT_PRODUCT)) {
            preparedStatement.setString(1, product);
            preparedStatement.setInt(2,price);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

             price = resultSet.getInt("price");
                 return  new Product(product, price);

            } else {
                throw new NotFoundProductException("Продукт"+product+" не найден в базе данных.");
            }
        } catch (SQLException | DataSourceServiceException e)  {
            log.error("Ошибка при выполнении запроса " + ProductQuerier.SELECT_PRODUCT, e);
            return null;
        }
         finally {
            dataSourceService.closeConnection();
        }}



    @Override
    public void insert(Product product) {

    }
}

