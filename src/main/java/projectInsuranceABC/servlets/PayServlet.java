package projectInsuranceABC.servlets;

import lombok.extern.slf4j.Slf4j;
import projectInsuranceABC.beans.Client;
import projectInsuranceABC.beans.PayData;
import projectInsuranceABC.dao.AccountDAO;
import projectInsuranceABC.dao.PayDataDAo;
import projectInsuranceABC.enums.Page;
import projectInsuranceABC.exceptions.UnregistredAccountException;
import projectInsuranceABC.exceptions.WithdrawalException;
import projectInsuranceABC.processors.AccountProcessor;
import projectInsuranceABC.utils.ServletUtil;
import projectInsuranceABC.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

@Slf4j
@WebServlet(name = "pay", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {
@Override
    protected  void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
String payTargetCount= httpServletRequest.getParameter("payTargetCount");
String paySum= httpServletRequest.getParameter("paySum");
    PayDataDAo payDataDAo= new PayDataDAo();
     try {
         Client payClient= SessionUtil.getClientFromSession(httpServletRequest.getSession());
         AccountProcessor.withdrawalAccount(payClient.getAccount(), Integer.parseInt(paySum));
         AccountDAO accountDAO = new AccountDAO();
         accountDAO.update(payClient.getAccount());
         PayData payData = new PayData(payClient, payTargetCount, Integer.parseInt(paySum), new Date());
                 payDataDAo.insert(payData);
     } catch (Exception e) {
         ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
     }

}
}
