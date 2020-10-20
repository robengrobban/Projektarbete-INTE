package se.su.dsv.inte.projektarbete.quest;

public class Gold {

    private int Quantity;

    public Gold(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void increase(int quantity) {
        this.Quantity += quantity;
    }

    public void decrease(int quantity) {
        this.Quantity -= quantity;
    }


}
