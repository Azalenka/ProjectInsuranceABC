package projectInsuranceABC.servlets;


import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Product;
import projectInsuranceABC.dao.ProductDAO;
import projectInsuranceABC.enums.Page;
import projectInsuranceABC.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@WebServlet(name = "selectProduct", urlPatterns = "/selectProducts")
public class SelectProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) {
//        String lifeInsurance = httpServletRequest.getParameter("lifeInsurance");
//        String carInsurance = httpServletRequest.getParameter("carInsurance");

//        String pageBasket = Page.BASKET_WITH_PRODUCTS.getPage();
//        ProductDAO productDAO = new ProductDAO();
//        Product product = productDAO.getById(Integer.valueOf(lifeInsurance));
//        List<Product> products = new ArrayList<>();
//        addProduct(product, products);


        String[] selectResult = httpServletRequest.getParameterValues("productName");
        if (selectResult != null && selectResult.length != 0) {

            for (int i = 0; i < selectResult.length; i++) {

            }
        }

/*productName.selectedProperty().addListener(event->{

            if (productName.isSelected())
    product = productDAO.get(productName, price);
        }*/


        httpServletRequest.setAttribute("ProductName", productName);
//        httpServletRequest.setAttribute("Price", price);

        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, pageBasket);


    }

//    private void addProduct(Product product, List<Product> products) {
//        if (product != null) {
//            products.add(product);
      }



