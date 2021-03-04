//all imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //notice javax
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

//class cafe order system
public class CafeOrderSystem{

    //decalring final values for format
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    private static Order currentCustomerOrder = new Order();

    //method add components to pane 
    public static void addComponentsToPane(Container pane){

        Menu tomsMenu = populateMenu();
        //new layout
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
            }
        
        //Declaring ALL labels
        JLabel blankLabel1 = new JLabel("");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 200;
            c.gridx = 0;
            c.gridy = 0;
            pane.add(blankLabel1, c);
        
        //label customer name
        JLabel customerNameLabel = new JLabel("Customer Name: ");
        if (shouldWeightX) {
            c.insets = new Insets(10,10,10,10);
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridx = 1;
            c.gridy = 0;
            pane.add(customerNameLabel, c);
        
        //customer name input
        JTextField customerNameInput = new JTextField();
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 200;
            c.gridx = 2;
            c.gridy = 0;
            pane.add(customerNameInput, c);
        
        //label table ID
        JLabel tableIDLabel = new JLabel("Table ID: ");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridx = 3;
            c.gridy = 0;
            pane.add(tableIDLabel, c);
        
        //text field table id
        JTextField tableIDInput = new JTextField();
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 100;
            c.gridx = 4;
            c.gridy = 0;
            pane.add(tableIDInput, c);

        //label category label
        JLabel categoryLabel = new JLabel("Category: ");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 200;
            c.gridx = 0;
            c.gridy = 1;
            pane.add(categoryLabel, c);

        //lable itemlabel
        JLabel itemLabel = new JLabel("Item: ");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridx = 1;
            c.gridy = 1;
            pane.add(itemLabel, c);

        //label item description
        JLabel itemDescriptionLabel = new JLabel("Description: ");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridx = 3;
            c.gridy = 1;
            pane.add(itemDescriptionLabel, c);    
        
        //defaults list model for category scroll
        
        DefaultListModel categoryModel = new DefaultListModel();
        JList categoryList = new JList(categoryModel);
        JScrollPane categoryScroll = new JScrollPane(categoryList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipady = 70;
            c.gridx = 0;
            c.gridy = 2;
            pane.add(categoryScroll, c);

        //DFM for item scroll

        DefaultListModel itemModel = new DefaultListModel();
        JList itemList = new JList(itemModel);
        JScrollPane itemScroll = new JScrollPane(itemList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridwidth = 2;
            c.gridx = 1;
            c.gridy = 2;
            c.ipady = 300;
            pane.add(itemScroll, c);   
        
        //text are display description
        JTextArea displayDescription = new JTextArea();
        displayDescription.setEnabled(false);
        displayDescription.setLineWrap(true);
        displayDescription.setWrapStyleWord(true);
        
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridwidth = 2;
            c.gridx = 3;
            c.gridy = 2;
            c.ipady = 100;
            pane.add(displayDescription, c);

        //label quantity label
        JLabel quantityLabel = new JLabel("Quantity: ");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 3;
            c.ipady = 0;
            pane.add(quantityLabel, c);
        
        //text field quantity input
        JTextField quantityInput = new JTextField();
        if (shouldWeightX) {
            c.weightx = .1;
            }
            c.ipadx = 0;
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 3;
            pane.add(quantityInput, c);

        //button quantity button
        JButton quantityButton = new JButton("Add");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 3;
            pane.add(quantityButton, c);

        //label summary label
        JLabel orderSummaryLabel = new JLabel("Order: ");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipadx = 0;
            c.gridx = 0;
            c.gridy = 4;
            pane.add(orderSummaryLabel, c);

        //text area summary text area
        JTextArea orderSummaryTextArea = new JTextArea();
        orderSummaryTextArea.setEnabled(false);
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.gridwidth = 5;
            c.ipady = 100;
            c.ipadx = 0;
            c.gridx = 0;
            c.gridy = 5;
            pane.add(orderSummaryTextArea, c);
            
        //button submit order
        JButton submitOrder = new JButton("Submit");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.gridwidth = 1;
            c.ipady = 0;
            c.ipadx = 0;
            c.gridx = 3;
            c.gridy = 6;
            pane.add(submitOrder, c);
        
        //button reset order
        JButton resetOrder = new JButton("Reset");
        if (shouldWeightX) {
            c.weightx = 0;
            }
            c.ipady = 0;
            c.ipadx = 0;
            c.gridx = 4;
            c.gridy = 6;
            pane.add(resetOrder, c); 
            
            //logic for table id action listener

            tableIDInput.addActionListener
            (new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    String tableNumber = "";
                    String customerName = "";
                    if(event.getSource() == tableIDInput){
    
                        customerName = customerNameInput.getText();
                        tableNumber = tableIDInput.getText();

                        if(customerName.equals("")){
                            JOptionPane.showMessageDialog(customerNameInput,"No name entered!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        if(tableNumber.equals("")){
                            JOptionPane.showMessageDialog(tableIDInput,"No table ID entered!", "Error", JOptionPane.ERROR_MESSAGE);
                        }else{
                            try{
                                int tableIntNumber = Integer.parseInt(tableIDInput.getText());
                                currentCustomerOrder = createCustomerOrder(customerName, tableNumber);
                                categoryModel.removeAllElements();
                                for(MenuCategory m: tomsMenu.getMenuCategories()){
                                    categoryModel.addElement(m.getCategoryName());
                                }
                            }
                            catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(tableIDInput,e.getMessage() + " Table number can only contain numbers", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }
                }
            }
        });

        //logic for list selection model csateogry selection
       ListSelectionModel categorySelection = categoryList.getSelectionModel();
       categorySelection.addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting()){
                        int userSelection = categoryList.getSelectedIndex();
                            if(userSelection >= 0) {
                            ArrayList<MenuCategory> categoryArray = tomsMenu.getMenuCategories();
                            MenuCategory selectedCategory = categoryArray.get(userSelection);
                            itemModel.removeAllElements();

                            for(MenuItem m: selectedCategory.getMenuCategory()){
                                //itemModel.addElement(m.getMenuItemName());
                            itemModel.addElement(String.format("%s", m.toString()));
                            }
                        }
                    }
                }  
            
            });

            //logic for list selection model for menu item section
            ListSelectionModel menuItemSelection = itemList.getSelectionModel();
            menuItemSelection.addListSelectionListener(
                new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event){
                        if(!event.getValueIsAdjusting()){
                            int userSelection = categoryList.getSelectedIndex();
                            if(userSelection >= 0){
                                ArrayList<MenuCategory> categoryArray = tomsMenu.getMenuCategories();
                                MenuCategory selectedCategory = categoryArray.get(userSelection);

                                int itemSelection = itemList.getSelectedIndex();
                                if(itemSelection < 0){
                                    displayDescription.setText("");
                                }else{
                                    MenuItem selectedMenuItem = selectedCategory.getMenuCategory().get(itemSelection);
                                    displayDescription.setText("");
                                    displayDescription.setText(selectedMenuItem.getItemDescription());
                                }
                            }
                        }
                    }  
                
                });

                //action listener for quantity button press
                quantityButton.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent event){
                           if(event.getSource() == quantityButton){
                               String quantityString = quantityInput.getText();
                               
                               if(quantityString.equals("")){
                                JOptionPane.showMessageDialog(quantityInput,"No quantity entered!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                //try catch block for error checking
                                try{
                                    int quantityInt = Integer.parseInt(quantityString);
                                    int userSelection = categoryList.getSelectedIndex();
                                    ArrayList<MenuCategory> categoryArray = tomsMenu.getMenuCategories();
                                    MenuCategory selectedCategory = categoryArray.get(userSelection);
                                    int itemSelection = itemList.getSelectedIndex();
                                    MenuItem selectedMenuItem = selectedCategory.getMenuCategory().get(itemSelection);
                                    currentCustomerOrder.addOrderItem(selectedMenuItem, quantityString);
                                    orderSummaryTextArea.setText(currentCustomerOrder.toString());
                                    quantityInput.setText("");

                                    System.out.println(currentCustomerOrder.getBillTotal());
                                }catch(NumberFormatException e){
                                    JOptionPane.showMessageDialog(quantityInput,e.getMessage() + " Quantity can only contain numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                           } 
                        }
                    }
                );
                //reset order action listener
                resetOrder.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent event){
                            if(event.getSource() == resetOrder){
                                
                               currentCustomerOrder = new Order();
                                displayDescription.setText("");
                                customerNameInput.setText("");
                                tableIDInput.setText("");
                                quantityInput.setText("");
                                orderSummaryTextArea.setText("");
                                try{
                                    itemModel.removeAllElements();
                                }
                                catch(IndexOutOfBoundsException e){
                                    itemModel.removeAllElements();
                                }
                                
                                try{
                                    categoryModel.removeAllElements();
                                }
                                catch(IndexOutOfBoundsException e){
                                    categoryModel.removeAllElements();
                                }
                
                                JOptionPane.showMessageDialog(resetOrder,"System is reset", "System Reset", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                );
                //submit order action listener
                submitOrder.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent event){
                            if(event.getSource() == submitOrder){
                                try{
                                    String fileName = customerNameInput.getText() + "_" + tableIDInput.getText() + ".txt";
                                    File textFile = new File(fileName);
                                    if(textFile.createNewFile()){
                                        FileWriter writeFile = new FileWriter(fileName);
                                        writeFile.write("Customer Name: " + customerNameInput.getText() + ";" + " Table ID: " + tableIDInput.getText() + "\n\n");
                                        writeFile.write(currentCustomerOrder.toString());
                                        writeFile.close();
                                        JOptionPane.showMessageDialog(submitOrder,"The customers order is saved.", "Saved Order", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }catch(IOException ex){
                                    JOptionPane.showMessageDialog(submitOrder,ex.getMessage() + "An error has occured.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                );

    }

    //create and show method (displays OOP prinnciples present)
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Cafe Order System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        frame.setSize(1000,700);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    //main method
    public static void main(String [] args){
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
    }

    //Method listing
    //populate menu method
    public static Menu populateMenu(){

        //Creating all objects of the products
        //Pizzas
        MenuItem tropicanaPizza = new MenuItem("Tropicana Pizza",
            "Ham and pineapple served on a tomato base with mozzarella cheese.", "10.0", "10.0", false, false);
        MenuItem tropicanaPizzaNM = new MenuItem("Tropicana Pizza (NM)",
            "Ham and pineapple served on a tomato base with mozzarella cheese.", "13.0", "10.0", false, false);
        MenuItem bbqMeatLoversPizza = new MenuItem("BBQ Meat Lovers Pizza",
            "Beef, bacon, ham, pepperoni, spanish onion, cherry tomatoes, and mozzarella cheese.","16.0", "16.0", false, false);
        MenuItem bbqMeatLoversPizzaNM = new MenuItem("BBQ Meat Lovers Pizza (NM)",
            "Beef, bacon, ham, pepperoni, spanish onion, cherry tomatoes, and mozzarella cheese.","19.0", "16.0", false, false);
        MenuItem pepperoniPizza = new MenuItem("Pepperoni Pizza",
            "Tomato base, chilli flakes, pepperoni, spinach, and mozzarella cheese.","9.0", "9.0", false, false);
        MenuItem pepperoniPizzaNM = new MenuItem("Pepperoni Pizza (NM)",
            "Tomato base, chilli flakes, pepperoni, spinach, and mozzarella cheese.","12.0", "9.0", false, false);
        MenuItem chickenMushroomBriePizza = new MenuItem("Chicken, Mushroom, & Brie Pizza",
            "Tomato base, chicken, mushroom, spinach, brie, and mozzarella cheese.","14.0", "14.0", false, false);
        MenuItem chickenMushroomBriePizzaNM = new MenuItem("Chicken, Mushroom, & Brie Pizza (NM)",
            "Tomato base, chicken, mushroom, spinach, brie, and mozzarella cheese.","17.0", "14.0", false, false);
        MenuItem garlicPizza = new MenuItem("Garlic Pizza",
            "Confit garlic, mozarrella cheese, rosemary topped with smoked salt.","8.0", "8.0", true, false);
        MenuItem garlicPizzaNM = new MenuItem("Garlic Pizza (NM)",
            "Confit garlic, mozarrella cheese, rosemary topped with smoked salt.","11.0", "8.0", true, false);
        MenuItem slowRoastedLambPizza = new MenuItem("Slow-Roasted Lamb Pizza",
            "Tomato base with slow-roasted lamb, rocket, sumac, tzatziki, and mozzarrella cheese.","12.0", "12.0", false, false);
        MenuItem slowRoastedLambPizzaNM = new MenuItem("Slow-Roasted Lamb Pizza (NM)",
            "Tomato base with slow-roasted lamb, rocket, sumac, tzatziki, and mozzarrella cheese.","15.0", "12.0", false, false);
        MenuItem greenPizza = new MenuItem("Green Pizza",
            "Basil pesto base topped with rocket, broccoli, green olives, and bocconcini.","12.0", "12.0", true, false);
        MenuItem greenPizzaNM = new MenuItem("Green Pizza (NM)",
            "Basil pesto base topped with rocket, broccoli, green olives, and bocconcini.","15.0", "12.0", true, false);

        //Burgers
        MenuItem wagyuBurger = new MenuItem("Wagyu Burger",
            "Wagyu beef, bacon, tomato, mesculin, beetroot, and aioli on a lightly toasted brioche bun, served with chips",
            "16.5", "16.5", false, false);
         MenuItem wagyuBurgerNM = new MenuItem("Wagyu Burger (NM)",
            "Wagyu beef, bacon, tomato, mesculin, beetroot, and aioli on a lightly toasted brioche bun, served with chips",
            "19.5", "16.5", false, false);
        MenuItem cheeseBurger = new MenuItem("Cheeseburger",
            "Milk bun topped with a beef patty, cheese, tomato, and mustard served with chips.","10.0", "10.0", false, false);
        MenuItem cheeseBurgerNM = new MenuItem("Cheeseburger (NM)",
            "Milk bun topped with a beef patty, cheese, tomato, and mustard served with chips.","13.0", "10.0", false, false);
        MenuItem halloumiBurger = new MenuItem("Halloumi Burger",
            "Milk bun topped with rocket, halloumi, egg and tomato relish, served with chips.","10.0", "10.0", true, false);
        MenuItem halloumiBurgerNM = new MenuItem("Halloumi Burger (NM)",
            "Milk bun topped with rocket, halloumi, egg and tomato relish, served with chips.","13.0", "10.0", true, false);
        MenuItem steakSandwich = new MenuItem("Steak Sandwich",
            "120g rib fillet steak with caramelised onion, lettuce, cheese, tomato, beetroot, and barbeque sauce on a toasted sandwich ciabatta, served with chips."
            ,"18.5", "18.5", false, false);
        MenuItem steakSandwichNM = new MenuItem("Steak Sandwich (NM)",
            "120g rib fillet steak with caramelised onion, lettuce, cheese, tomato, beetroot, and barbeque sauce on a toasted sandwich ciabatta, served with chips."
            ,"21.5", "18.5", false, false);
        MenuItem chickenWrap = new MenuItem("Chicken Wrap",
            "Southern chocken tenders wrapped in soft tortilla with sweet chilli aioli, lettuce, cheese, tomato, and carrot, served with chips"
            ,"9.9", "9.9", false, false);
        MenuItem chickenWrapNM = new MenuItem("Chicken Wrap (NM)",
            "Southern chocken tenders wrapped in soft tortilla with sweet chilli aioli, lettuce, cheese, tomato, and carrot, served with chips"
            ,"12.9", "9.9", false, false);

        //Sides
        MenuItem sweetPotatoFries = new MenuItem("Sweet Potato Fries (Bowl)",
            "Served with tomato relish","6.5", "6.5", true, false);
        MenuItem sweetPotatoFriesNM = new MenuItem("Sweet Potato Fries (Bowl) (NM)",
            "Served with tomato relish","9.5", "6.5", true, false);
        MenuItem chips = new MenuItem("Chips (Bowl)",
            "Served with aioli, tomato sauce and barbeque sauce","5.0", "5.0", true, false);
        MenuItem chipsNM = new MenuItem("Chips (Bowl) (NM)",
            "Served with aioli, tomato sauce and barbeque sauce","8.0", "5.0", true, false);
        MenuItem wedges = new MenuItem("Wedges (Bowl)",
            "Served with sweet chilli sauce and sour cream","6.5", "6.5", true, false);
        MenuItem wedgesNM = new MenuItem("Wedges (Bowl) (NM)",
            "Served with sweet chilli sauce and sour cream","9.5", "6.5", true, false);
        MenuItem sideSalad = new MenuItem("Side Salad",
            "","5.0", "5.0", true, false);
        MenuItem sideSaladNM = new MenuItem("Side Salad (NM)",
            "","8.0", "5.0", true, false);

        //Create categories

        MenuCategory pizzas = new MenuCategory("Pizza");
        MenuCategory burgers = new MenuCategory("Burgers");
        MenuCategory sides = new MenuCategory("Add Sides");

        //adding pizzas
        pizzas.addMenuItem(tropicanaPizza);
        pizzas.addMenuItem(tropicanaPizzaNM);
        pizzas.addMenuItem(bbqMeatLoversPizza);
        pizzas.addMenuItem(bbqMeatLoversPizzaNM);
        pizzas.addMenuItem(pepperoniPizza);
        pizzas.addMenuItem(pepperoniPizzaNM);
        pizzas.addMenuItem(chickenMushroomBriePizza);
        pizzas.addMenuItem(chickenMushroomBriePizzaNM);
        pizzas.addMenuItem(garlicPizza);
        pizzas.addMenuItem(garlicPizzaNM);
        pizzas.addMenuItem(slowRoastedLambPizza);
        pizzas.addMenuItem(slowRoastedLambPizzaNM);
        pizzas.addMenuItem(greenPizza);
        pizzas.addMenuItem(greenPizzaNM);

        //adding burgers
        burgers.addMenuItem(wagyuBurger);
        burgers.addMenuItem(wagyuBurgerNM);
        burgers.addMenuItem(cheeseBurger);
        burgers.addMenuItem(cheeseBurgerNM);
        burgers.addMenuItem(halloumiBurger);
        burgers.addMenuItem(halloumiBurgerNM);
        burgers.addMenuItem(steakSandwich);
        burgers.addMenuItem(steakSandwichNM);
        burgers.addMenuItem(chickenWrap);
        burgers.addMenuItem(chickenWrapNM);

        //adding sides
        sides.addMenuItem(sweetPotatoFries);
        sides.addMenuItem(sweetPotatoFriesNM);
        sides.addMenuItem(chips);
        sides.addMenuItem(chipsNM);
        sides.addMenuItem(wedges);
        sides.addMenuItem(wedgesNM);
        sides.addMenuItem(sideSalad);
        sides.addMenuItem(sideSaladNM);
        
        Menu tomsMenu = new Menu("Tom's Restaurant");
        tomsMenu.addMenuCategory(pizzas);
        tomsMenu.addMenuCategory(burgers);
        tomsMenu.addMenuCategory(sides);
        return tomsMenu;
    }
    //method create customer order
    public static Order createCustomerOrder(String customerName, String tableNumber){
        Order newOrder = new Order(customerName, tableNumber);
        return newOrder;
    }

}

//class menu item
class MenuItem{

    //declared variables
    String menuItemName;
    String itemDescription;
    String itemPriceSingle;
    String itemPriceMeal;
    Boolean isVegetarian, isGlutenFree;

    //menu item constructor passing all values for menu
    public MenuItem(String menuItemName, String itemDescription, String itemPriceSingle,
        String itemPriceMeal, Boolean isVegetarian, Boolean isGlutenFree){

        this.menuItemName = menuItemName;
        this.itemDescription = itemDescription;
        this.itemPriceSingle = itemPriceSingle;
        this.itemPriceMeal = itemPriceMeal;
        this.isVegetarian = isVegetarian;
        this.isGlutenFree = isGlutenFree;

    }

    //method get menu item name
    public String getMenuItemName(){
        return menuItemName;
    }

    //method get item description
    public String getItemDescription(){
        return itemDescription;
    }

    //method get item price single
    public String getItemPriceSingle(){
        return itemPriceSingle;
    }

    //method get item price meal
    public String getItemPriceMeal(){
        return itemPriceMeal;
    }

    //method is vegetarian 
    public Boolean getVegetarian(){
        return isVegetarian;
    }

    //method is gluten free
    public Boolean getGlutenFree(){
        return isGlutenFree;
    }

    //method set menu item name 
    public void setMenuItemName(String menuItemName){
        this.menuItemName = menuItemName;
    }

    //method set item description
    public void setItemDescription(String itemDescription){
        this.itemDescription = itemDescription;
    }

    //method set item price singe
    public void setItemPricingSingle(String itemPriceSingle){
        this.itemPriceSingle = itemPriceSingle;
    }

    //method set item price meal
    public void setItemPricingMeal(String itemPriceMeal){
        this.itemPriceMeal = itemPriceMeal;
    }

    //method set is vegetarian
    public void setIsVegetarian(Boolean isVegetarian){
        this.isVegetarian = isVegetarian;
    }

    //method set is gluten free
    public void setIsGlutenFree(Boolean isGlutenFree){
        this.isGlutenFree = isGlutenFree;
    }

    //toString override
    @Override
    public String toString() {
        return getMenuItemName() + "\t" + "$" + getItemPriceSingle();
    }

}

//class menu category
class MenuCategory{

    //declared variables and categoryList array list
    ArrayList<MenuItem> categoryList;
    String categoryName;
    
    //menu csategory constructor
    public MenuCategory(String categoryName){
        this.categoryName = categoryName;
        categoryList = new ArrayList<MenuItem>();
    }

    //method add menu item 
    public void addMenuItem(MenuItem menuItem){
        categoryList.add(menuItem);
    }

    //method get menu category
    public ArrayList<MenuItem> getMenuCategory(){
        return categoryList;
    }

    //methof get category name
    public String getCategoryName(){
        return categoryName;
    }

    //toString override
    @Override
    public String toString() {

        String categoryItems = "";

        for (MenuItem menuItem : categoryList) {
            categoryItems = categoryItems + menuItem.getMenuItemName() + "\t" + "$" + menuItem.getItemPriceSingle() + "\n";
        }

        return categoryItems;
    }

}

//class menu
class Menu{

    //declaring variables
    String restaurantName;
    ArrayList<MenuCategory> menuCategories;

    //constructor menu
    public Menu(String restaurantName){
        this.restaurantName = restaurantName;
        menuCategories = new ArrayList<MenuCategory>();
    }

    //method add menu category
    public void addMenuCategory(MenuCategory menuCategory){
        menuCategories.add(menuCategory);
    }

    //method get menu categories
    public ArrayList<MenuCategory> getMenuCategories(){
        return menuCategories;
    }

    //override toString
    @Override
    public String toString() {
        
        String menuCategoryList = "";

        for (MenuCategory menuCategory : menuCategories) {
            menuCategoryList = menuCategoryList + menuCategory.getCategoryName() + "\n";
        }

        return menuCategoryList;
    }
}

//class order
class Order{

    //decalred variables
    String customerName;
    String tableID;
    ArrayList<MenuItem> orderItems;
    ArrayList<String> orderQuantities;
    ArrayList<String> orderPrices;
    String billTotal;

    //empty constructor order
    public Order(){

    }

    //constructor order filling table id and cname
    public Order(String customerName, String tableID){
        this.customerName = customerName;
        this.tableID = tableID;
        orderItems = new ArrayList<MenuItem>();
        orderQuantities = new ArrayList<String>();
        orderPrices = new ArrayList<String>();
        billTotal = "0";
    }

    //method get customer name
    public String getCustomerName(){
        return customerName;
    }

    //method get table id 
    public String getTableID(){
        return tableID;
    }

    //method get order items 
    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }

    //method get order quantities
    public ArrayList<String> getOrderQuantities(){
        return orderQuantities;
    }

    //method get order prices
    public ArrayList<String> getOrderPrices(){
        return orderPrices;
    }

    //method get bill total
    public String getBillTotal(){
        return billTotal;
    }

    //method set bill total
    public void setBillTotal(String billTotal){
        this.billTotal = billTotal;
    }

    //method add order item
    public void addOrderItem(MenuItem menuItem, String orderQuantity){
        orderItems.add(menuItem);
        orderQuantities.add(orderQuantity);

        double price;
        int quantity;
        double currentBillValue;

        try{
            price = Double.parseDouble(menuItem.getItemPriceSingle());
            quantity = Integer.parseInt(orderQuantity);
            orderPrices.add(Double.toString(price * quantity));
            currentBillValue = Double.parseDouble(getBillTotal());
            currentBillValue = currentBillValue + (price * quantity);
            setBillTotal(Double.toString(currentBillValue));
        }catch(NumberFormatException e){

        }  
    }  
    
    //toString override in order class
    @Override
    public String toString(){

        ArrayList<String> orderQuantities = getOrderQuantities();
        ArrayList<String> orderPrices = getOrderPrices();
        int counter = 0;
        String orderPrint = "";

        for(MenuItem m: getOrderItems()){
            if(m.isVegetarian){
            orderPrint = orderPrint + m.getMenuItemName() + "\t\t" + "Quantity: "
                + orderQuantities.get(counter) + "  $" + orderPrices.get(counter) + "\t" + "Vegetarian" + "\n";
            }else{
                orderPrint = orderPrint + m.getMenuItemName() + "\t\t" + "Quantity: "
                + orderQuantities.get(counter) + "  $" + orderPrices.get(counter) + "\n";
            }
            counter = counter + 1;
        }

        orderPrint = orderPrint + "\n\n" + "----------------------" + "\n" + "Total price: $" + getBillTotal();

        return orderPrint;
    }
}

