package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.Calculator;
/**
 * This interface represents a contract for a DAO for the {@link Calculator} model.
 *
 */
public interface ICalculatorDao {
    //create new Calculator
    void createCalculator(Calculator calculator);

}
