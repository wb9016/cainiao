package oop;

public class SalaryIncome extends Income{

	// TODO


    public SalaryIncome(double income) {
        super(income);
    }

    @Override
    public double getNum() {
        if (income<5000){
            return 0;
        }else {
            return (income-5000)*0.2;
        }
    }
}
