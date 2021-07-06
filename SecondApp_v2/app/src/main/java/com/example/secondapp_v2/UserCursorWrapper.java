package com.example.secondapp_v2;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.secondapp_v2.database.UserDbSchema;
import java.util.UUID;

public class UserCursorWrapper extends CursorWrapper {
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    // Метод который показывает пользователя.
    public User getUser(){
        // Переменные для хранения данных о пользователях
        String uuidString = getString(getColumnIndex(UserDbSchema.Cols.UUID));
        String userName = getString(getColumnIndex(UserDbSchema.Cols.USERNAME));
        String userLastName = getString(getColumnIndex(UserDbSchema.Cols.USERLASTNAME));
        String phone = getString(getColumnIndex(UserDbSchema.Cols.PHONE));
        // Создается пользователь (метод fromString извлекает из строки uuid)
        User user = new User(UUID.fromString(uuidString));
        user.setUserName(userName);
        user.setUserLastName(userLastName);
        user.setPhone(phone);
        return user;
    }
}