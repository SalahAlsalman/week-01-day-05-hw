import java.util.ArrayList;

public class Company implements PayAble {

    ArrayList<PayAble> list;

    public Company() {
        this.list = new ArrayList<>();
    }

    public boolean addPayAble(PayAble payAble) {
        return this.list.add(payAble);
    }

    @Override
    public double computeAmount() {
        double total =0;
        for(PayAble employee : list ) {
            if(employee instanceof FullTimeEmployee) {
                FullTimeEmployee em1 = (FullTimeEmployee) employee;
                total += em1.computeAmount();
            } else if (employee instanceof PartTimeEmployee) {
                PartTimeEmployee pt1 = (PartTimeEmployee) employee;
                total += pt1.computeAmount();
            }
        }
        return total;
    }

    public String toString() {
        String str = "[";
        for(PayAble employee: list) {
                if(employee instanceof FullTimeEmployee) {
                    FullTimeEmployee em1 = (FullTimeEmployee) employee;
                    str += em1.toString();
                } else if (employee instanceof PartTimeEmployee) {
                    PartTimeEmployee pt1 = (PartTimeEmployee) employee;
                    str += pt1.toString();
                }

        }
        return str += "]";
    }

}