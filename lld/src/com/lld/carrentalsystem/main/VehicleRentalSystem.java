package com.lld.carrentalsystem.main;


import java.util.List;

public class VehicleRentalSystem {

    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.storeList = stores;
        this.userList = users;
    }


    public Store getStore(Location location){
        return storeList.get(0);
    }



    //addUsers

    //remove users


    //add stores

    //remove stores



}
