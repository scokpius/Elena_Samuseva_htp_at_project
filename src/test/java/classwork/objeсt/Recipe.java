package classwork.objeсt;

import classwork.objeсt.Ingredient;

public class Recipe {
    public String reciprname;
    public Ingredient[] ingredlist;

    public int preptime;

    public Recipe() {
    }

    public Recipe(String reciprname, Ingredient[] ingredlist, int preptime) {
        this.reciprname = reciprname;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }
}
