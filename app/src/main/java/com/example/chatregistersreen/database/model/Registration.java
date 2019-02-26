package com.example.chatregistersreen.database.model;

public class Registration {


    public static final String TABLE_NAME = "registration" ;
    public static final String COLUMN_ID = "id" ;
    public static final  String COLUMN_FULLNAME = "fullname";
    public static final  String COLUMN_LOCATION = "location";
    public static final  String COLUMN_EMAIL = "email";
    public static final  String COLUMN_PHONENUMBER = "phonenumber";
    public static final  String COLUMN_PASSWORD = "password";

//    create a private integer variable

    private int id;
    private String fullname;
    private String location;
    private String email;
    private String phonenumber;
    private String Password;

    //SQL COMMAND TO CREATE TABLE
    public static String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + " ("
                    +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COLUMN_FULLNAME + " TEXT ,"
                    +COLUMN_LOCATION + "TEXT ,"
                    +COLUMN_PHONENUMBER + "TEXT ,"
                    +COLUMN_EMAIL + "TEXT ,"
                    +COLUMN_PASSWORD + "TEXT"
                    +")" ;


    public Registration( String fullname, String location, String email, String phonenumber, String password) {
        //this.id = id;
        this.fullname = fullname;
        this.location = location;
        this.email = email;
        this.phonenumber = phonenumber;
        this.Password = password;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation (String location ) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
