package com.example.secondapp_v2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Cоздается объект recyclerView(виджет)
    RecyclerView recyclerView;
    // Создается массив пользователей
    ArrayList<User> users = new ArrayList<>();
    // Создается объект userAdapter
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Обращаемся к ресурсу recyclerView(виджет) по id
        recyclerView = findViewById(R.id.recyclerview);
        // Используем Layout передаем в него активность MaintActivity
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        // Создается цикл на 100 объектов и передается в коллекцию users
        for (int i = 0; i < 100; i++) {
            // Создается новый пользователь
            User user = new User();
            user.setUserName("Пользователь №" + i);
            user.setUserLastName("Фамилия №" + i);
            // Пользователь добавляется в коллекцию
            users.add(user);
        }
        // Реализация Adapter и ViewHolder

        // Adapter нужен для передачи элементов в RecyclerView.
        // Adapter введет подсчет элементов
        // Передается список элементов в объект userAdapter
        userAdapter = new UserAdapter(users);
        // Адаптер передается RecyclerView
        recyclerView.setAdapter(userAdapter);
    }
    // RecyclerView.ViewHolder генерирует элементы списка
    private class UserHolder extends RecyclerView.ViewHolder {
        // Создается объект itemTextView класса TextView
        TextView itemTextView;
        // Создается конструктор (2 аргумента LayoutInflater и ViewGroup)
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            // itemView и текущий layout single_item
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        // Создается метод bind,который связывает параметры в классе UserHolder
        public void bind(String userString) {
            // В itemTextView печатаем текст userString
            itemTextView.setText(userString);
        }
    }
    // Adapter наследует все что есть у RecyclerView.
    // Adapter позволяет переместить элементы списка на экран при помощи RecyclerView(виджет)
    // ViewHolder генерирует элементы списка
    private class UserAdapter extends RecyclerView.Adapter<UserHolder> {
        // Принимается из onCreate созданных пользователей
        ArrayList<User> users;

        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        }
        // 3 метода в Adapter

        // Создается метод для инициализации объектов ViewHolder и ViewGroup
        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            // Создается инфлятор (раздувает макет)
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            // Возвращается созданный элемент в RecyclerView пустым
            return new UserHolder(inflater, viewGroup);
        }

        // Метод использует соответствующие данные и заполняет ими элементы списка
        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            // Достать пользователя по идентификатору и записать в переменную user
            User user = users.get(position);
            // Обратиться к пользователю и сделать из Имени и Фамилии строку
            String userString = user.getUserName() + "\n" + user.getUserLastName();
            // Вызвать метод bind у объекта userHolder для отображения на экране
            userHolder.bind(userString);
        }

        // Этот метод возвращает количество элементов
        @Override
        public int getItemCount() {
            // Возвращается количество созданных элементов
            return users.size();
        }
    }
}