package com.company;

//STEP 1. Import required packages
import java.sql.*;

public class Main {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5433/ndb";
    static final String USER = "postgres";
    static final String PASS = "1234567";

    public static void main(String[] argv) {





        Drawer drawer = new Drawer();
        drawer.show();
    }
}
