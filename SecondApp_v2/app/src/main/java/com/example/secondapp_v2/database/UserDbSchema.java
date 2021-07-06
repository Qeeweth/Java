package com.example.secondapp_v2.database;

public class UserDbSchema {
    public static final class UserTable {
        // Название таблицы БД
        public static final String NAME = "users";
    }

    // Название колонок
    public static final class Cols {
        public static final String UUID = "uuid";
        public static final String USERNAME = "user_name";
        public static final String USERLASTNAME = "user_last_name";
        public static final String PHONE = "phone";
    }
}
