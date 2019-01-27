package com.example.fang.b16traveldomain.model.dataresource;

public interface UserRepository {
    void saveUser();

    void saveDate(String date);

    void getUser();

    String getDate();

    void saveRoute(String route);

    String getRoute();
}
