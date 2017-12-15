package ua.com.delivery.persistence.dao;

//як провіти чи дійсно заносить дані
public class Main {
    public static void main(String[] args) {
        IAbstractFactory factory = new AbstractFactory();

        IAdministratorDao administratorDao = factory.createAdminDao();
        ICalculatorDao calculatorDao = factory.createCalculatorDao();
        ICargoPriceDao cargoPriceDao = factory.createCargoDao();
        IDirectionDao directionDao = factory.createDirectionDao();
        IOrderFromWarehouseDao orderFromWarehouseDao = factory.createOrderFromWarehouseDao();
        IOrderToWarehouseDao orderToWarehouseDao = factory.createOrderToWarehouseDao();
        IParcelPriceDao parcelPriceDao = factory.createParcelPriceDao();
        IUserDao userDao = factory.createUserDao();

  /// it's for administrator
/*
        Administrator administrator = new Administrator();
        administrator.setAdminID(2L);
        administrator.setName("Jorik");
        administrator.setUsername("Mypaxa");
        administrator.setPassword("qwert12345");
        administrator.setEmail("pds@gmail.com");
        //чому не можна вказувати з 0
        administrator.setPhone(38043165128L);

        administrator.createAdministrator(administrator);
        administrator.deleteAdministratorByUsername("Mypaxa");
*/

//it's only checking simple connection
//      SimpleConnection.getInstance().getConnection();

//it's for calculator
      /*  Calculator calculator = new Calculator();
        calculator.setCalculatorID(2L);
        calculator.setDirectionID(4);
        calculator.setCargoID(1);
        calculator.setParcelID(2);
        calculator.setDateToDelivery(java.sql.Date.valueOf("2014-02-04"));
        calculator.setDeclaredPrice(300);
        calculator.setWeight(1);
        calculator.setVolume(9);

        calculatorDao.createCalculator(calculator);*/

/*//it's for CargoPrice
        CargoPrice cargoPrice = new CargoPrice();
        cargoPrice.setCargopriceID(11L);
        cargoPrice.setWeight(20);
        cargoPrice.setPrice(90);

//        cargoPriceDao.createCargoPrice(cargoPrice);
//        cargoPriceDao.getListCargoPrices();
        cargoPriceDao.deleteCargoPriceByWeight(20);*/

    }
}
