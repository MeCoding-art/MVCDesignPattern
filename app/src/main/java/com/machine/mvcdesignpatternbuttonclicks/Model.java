package com.machine.mvcdesignpatternbuttonclicks;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    //declaring a list integers
    private List<Integer> list;

    //constructor to initialize the list
    public Model() {
        //reserving the space for list
        list = new ArrayList<>();

        //adding elements into the list
        list.add(0);
        list.add(0);
        list.add(0);
    }

    //adding getter and setter
    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{

        return list.get(the_index);
    }

    //function to make changes in the activity button's
    public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        list.set(the_index, list.get(the_index)+1);
        setChanged();
        notifyObservers();
    }


}
