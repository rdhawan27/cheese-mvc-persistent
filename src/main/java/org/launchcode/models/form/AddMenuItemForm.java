package org.launchcode.models.form;

import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;

/**
 * Created by anu on 6/27/2017.
 */
public class AddMenuItemForm {
    @NotNull
    private int menuId;
    @NotNull
    private int cheeseId;

    private Menu menu;
    private Iterable<Cheese>cheeses;

    public AddMenuItemForm(){}

    public AddMenuItemForm(Iterable<Cheese>cheeses,Menu menu){
        this.cheeses=cheeses;
        this.menu=menu;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public Menu getMenu() {
        return menu;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setCheeses(Iterable<Cheese> cheeses) {
        this.cheeses = cheeses;
    }
}
