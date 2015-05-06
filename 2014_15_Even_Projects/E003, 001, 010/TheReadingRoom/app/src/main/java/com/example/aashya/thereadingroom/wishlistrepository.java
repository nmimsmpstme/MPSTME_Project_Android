package com.example.aashya.thereadingroom;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by aashya on 27/03/15.
 */

    import java.util.Collection;
    import java.util.Map;

    public interface wishlistrepository {

        public List<wish> findWishesByIdWishlist(Integer idWishlist);

        public wish createWish(wish wish);

        public wish deleteWish(Integer idWish);

        public wish updateWishStatus(Integer idWish, Integer newStatus);
    }
