package com.example.olal.sqiltedbforandroid;

/**
 * Created by olal on 2/28/17.
 */
//the database handler class
public class Student {

    //Private variable

    int _id;
    int _enroll_no;
    String _name;
    String _phone_number;


    //empty constructor

    public Student(){

    }

    //all parameter in constructor

    public Student(int _id, int _enroll_no, String _name, String _phone_number){

        this._id = _id;
        this._name = _name;
        this._enroll_no = _enroll_no;
        this._phone_number = _phone_number;
    }

    //three parameter constructor

    public Student(int _enroll_no, String _phone_number, String _name){

        this._phone_number = _phone_number;
        this._enroll_no = _enroll_no;
        this._name = _name;


    }

    //getters and setters for all fields

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_enroll_no() {
        return _enroll_no;
    }

    public void set_enroll_no(int _enroll_no) {
        this._enroll_no = _enroll_no;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }

}
