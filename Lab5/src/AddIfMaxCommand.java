import java.util.LinkedList;

/**
 * Command class that adds element to the collection if it price bigger than other
 */

public class AddIfMaxCommand implements CommandWithAdditionalArgument{
    /**price of a new ticket*/
    private Double price;
    /**collection of tickets*/
    private final LinkedList<Ticket> c;

    /**
     * Constructor with parameter
     * @param c - collection of tickets
     */
    public AddIfMaxCommand(LinkedList<Ticket> c) {this.c = c;}

    /**
     * add element to the collection, if it more than other
     */
    @Override
    public void execute() {
        if (price > c.getLast().getPrice()) c.add(new Ticket(price));
        else System.out.println("Новый элемент не может быть добавлен из-за низкой цены.");
        CommandDecoder cd = new CommandDecoder(c);
        cd.sort(c);
    }

    /**
     * Getting price of ticket to compare with others {@link AddIfMaxCommand#price}
     * @param obj - additional argument
     */
    @Override
    public void addArgument(String obj) {
        price = Double.parseDouble(obj);
    }

    /**
     * @return info about command
     */
    @Override
    public String toString() {
        return "add_if_max <price> : добавить новый элемент в коллекцию, если его значение price превышает значение наибольшего элемента этой коллекции";
    }
}
