public class Car {
    private String manufacturer;
    private String number;
    private int year;
    private String owner;

    public Car(String manufacturer, String number, int year, String owner) {
        this.manufacturer = manufacturer;
        this.number = number;
        this.year = year;
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
