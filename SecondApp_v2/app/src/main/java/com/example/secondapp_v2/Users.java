package com.example.secondapp_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import com.example.secondapp_v2.database.UserBaseHelper;
import com.example.secondapp_v2.database.UserDbSchema;
import java.util.ArrayList;
import java.util.List;

public class Users {
    private ArrayList<User> userList;
    private SQLiteDatabase database;
    private Context context;

    public Users(Context context) {
        this.context = context.getApplicationContext();
        // Создается объект UserBaseHelper (отвечает за таблицы), это объект класса, который отвечает за создание таблицы,
        this.database = new UserBaseHelper(context).getWritableDatabase();
    }
    // Метод добавляет данные в БД
    public void addUser(User user) {
        // Выбор колонки в которую будет добавляться значение
        ContentValues values = getContentValues(user);
        // Переменная для БД
        database.insert(UserDbSchema.UserTable.NAME, null, values);
    }
    // Метод возвращает ContentValues
    private static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        // Подбираем колонки и свойства объекта user.
        values.put(UserDbSchema.Cols.UUID, user.getUuid().toString());
        values.put(UserDbSchema.Cols.USERNAME, user.getUserName());
        values.put(UserDbSchema.Cols.USERLASTNAME, user.getUserLastName());
        values.put(UserDbSchema.Cols.PHONE, user.getPhone());
        // Возврат values
        return values;
    }
    // Метод для чтения данных из БД в виде курсора
    private UserCursorWrapper queryUsers() {
        Cursor cursor = database.query(UserDbSchema.UserTable.NAME, null, null, null, null, null, null);
        return new UserCursorWrapper(cursor);
    }
    // Метод, который возвращает список пользователей
    public ArrayList<User> getUserList() {
        // Инициализация пустого списка
        this.userList = new ArrayList<User>();
        // Считывает значения из БД
        UserCursorWrapper cursorWrapper = queryUsers();
        try {
            // MoveToFirst перемещает курсор на первую запись таблицы БД
            cursorWrapper.moveToFirst();
            // Циклично считываются значения до окончания символов
            // Считывается isAfterLast,если курсор не после последнего
            while (!cursorWrapper.isAfterLast()) {
                User user = cursorWrapper.getUser();
                // Сохранение пользователя в коллекцию userList
                userList.add(user);
                // Сдвиг курсора на следующую позицию
                cursorWrapper.moveToNext();
            }
        } finally {
            cursorWrapper.close();
        }
        // Возврат списка пользователей
        return userList;
    }

}

