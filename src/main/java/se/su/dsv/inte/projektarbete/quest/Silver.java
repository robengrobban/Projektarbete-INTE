package se.su.dsv.inte.projektarbete.quest;

public class Silver {
    private int Quantity;

    public Silver(int quantity) {
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
