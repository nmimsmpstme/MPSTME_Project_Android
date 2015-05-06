/**
 * Created by aashya on 21/03/15.
 */

package com.example.aashya.thereadingroom;

public class books {

    //private variables
    int _id;
    String _name;
    String _author;
    String _library;

    // Empty constructor
    public books(){

    }
    // constructor
    public books(int id, String name, String _author, String _library){
        this._id = id;
        this._name = name;
        this._author = _author;
        this._library = _library;
    }

    // constructor
    public books(String name, String _author, String _library){
        this._name = name;
        this._author = _author;
        this._library = _library;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getauthor(){
        return this._author;
    }

    // setting phone number
    public void setauthor(String author){
        this._author = author;
    }

    // getting library
    public String getlibrary(){
        return this._library;
    }

    // setting library
    public void setlibrary(String library){
        this._library = library;
    }

}