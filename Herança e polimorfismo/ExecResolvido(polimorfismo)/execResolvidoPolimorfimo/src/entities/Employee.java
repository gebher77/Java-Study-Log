package entities;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuerPerHour;


    public Employee() {
    }

    public Employee(String name, Integer hours, Double valuerPerHour) {
        this.name = name;
        this.hours = hours;
        this.valuerPerHour = valuerPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValuerPerHour() {
        return valuerPerHour;
    }

    public void setValuerPerHour(Double valuerPerHour) {
        this.valuerPerHour = valuerPerHour;
    }

    //método para calcular pagamento
    public double payment(){
        return hours * valuerPerHour;
    }

}
