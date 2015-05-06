package com.example.aashya.thereadingroom;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by aashya on 27/03/15.
 */
public interface wishlistservice {

    wish deleteWish(Integer idWish);

    wish updateWishStatus(Integer idWish, Integer newStatus);

    wish findWishesByIdWishlist(Integer idWishlist);
    wish createWish(Integer idWishlist);
}
