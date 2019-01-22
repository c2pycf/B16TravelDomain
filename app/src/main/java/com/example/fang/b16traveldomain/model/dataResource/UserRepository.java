package com.example.fang.b16traveldomain.model.dataResource;

public interface UserRepository {
    void saveUser();

    void saveDate(String date);

    void getUser();

    void getDate();
}
