package entities;

public class OutsourcedEmployee extends Employee {

    private Double additionalCharge;

    public OutsourcedEmployee() {
        super();
    }

    public OutsourcedEmployee(String name, Integer hours, Double valuerPerHour, Double additionalCharge) {
        super(name, hours, valuerPerHour);
        this.additionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    //Método de calcular pagamento sobrescrito
    @Override
    public double payment() {
        return super.payment() + additionalCharge * 1.1;
    }
}
