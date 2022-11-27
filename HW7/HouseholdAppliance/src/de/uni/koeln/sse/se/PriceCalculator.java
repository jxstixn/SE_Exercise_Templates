package de.uni.koeln.sse.se;

public class PriceCalculator implements Visitor {
    private double tmpPrice;

    @Override
    public void visitElectronic(Electronic e) {
        if (e.getFragile()) {
            tmpPrice = (double) e.getWeight() / 10 * 5;
        } else {
            tmpPrice = (double) e.getWeight() / 15 * 5;
        }
    }

    @Override
    public void visitFurniture(Furniture f) {
        tmpPrice = (double) f.getWeight() / 20 * 5;
    }

    @Override
    public void visitGlass(Glass g) {
        int t = g.getTickness();
        switch (t) {
            case 1:
                tmpPrice = (double) g.getLenght() / 100 * 2;
                break;
            case 2:
                tmpPrice = (double) g.getLenght() / 100 * 1.2;
                break;
            case 3:
                tmpPrice = (double) g.getLenght() / 100 * 0.7;
                break;
        }
    }

    public double getPrice(HouseholdItem h) {
        tmpPrice = 0;
        h.accept(this);
        return tmpPrice;
    }
}
