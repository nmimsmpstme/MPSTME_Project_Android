package com.example.aashya.thereadingroom;

import java.util.List;

/**
 * Created by aashya on 27/03/15.
 */
public class wish {

    private long id;
    private String wish;

    public wish(List<wish> wishesByIdWishlist) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getwish() {
        return wish;
    }

    public void setwish(String wish) {
        this.wish = wish;
    }



    // Will be used by the ArrayAdapter in the ListView
    // @Override
    // public String toString() {
    //    return wish;
    //  }


}
