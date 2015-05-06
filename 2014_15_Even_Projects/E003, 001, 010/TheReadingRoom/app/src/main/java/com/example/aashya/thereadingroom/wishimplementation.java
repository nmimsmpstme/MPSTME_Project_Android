package com.example.aashya.thereadingroom;

/**
 * Created by aashya on 27/03/15.
 */
public class wishimplementation {



    private wishlistrepository wishRepo;


    public wish deleteWish(Integer idWishlist) {
        return wishRepo.deleteWish(idWishlist);
    }


    public wish findWishesByIdWishlist(Integer idWishlist) {
        return new wish(wishRepo.findWishesByIdWishlist(idWishlist));
    }

    public wish createWish(Integer idWishlist, wish wish) {


        if (wish == null) {
            throw new wishlistdoesnotexist();
        }
        wish createdWish = wishRepo.createWish(wish);
        return createdWish;
    }

}
