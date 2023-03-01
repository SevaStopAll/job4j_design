package ru.job4j.ood.isp.menu;

public class TodoApp {
    private Menu menu;

    public TodoApp(Menu menu) {
        this.menu = menu;
    }

    public boolean addToRoot(String childName, ActionDelegate actionDelegate) {
        return menu.add(Menu.ROOT, childName, actionDelegate);
    }

    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        return menu.add(parentName, childName, actionDelegate);
    }

    public void print() {
        new ConsoleMenuPrinter().print(menu);
    }

    public void act(String itemName) {
        menu.select(itemName).get().getActionDelegate().delegate();
    }
}
