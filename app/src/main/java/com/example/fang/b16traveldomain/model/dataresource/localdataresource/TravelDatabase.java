package com.example.fang.b16traveldomain.model.dataresource.localdataresource;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.fang.b16traveldomain.model.Passenger;
import com.example.fang.b16traveldomain.model.TicketInformation;


/**
 * Room database with two related tables
 */
@Database(entities = {TicketInformation.class, Passenger.class},version = 10)
public abstract class TravelDatabase extends RoomDatabase {
    public abstract PassengerDAO passengerDAO();

    public abstract TicketInforDAO ticketInforDAO();

    private static TravelDatabase INSTANCE;

    public static TravelDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    TravelDatabase.class,"b16_travel_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(sRoomDatabaseCallBack)
                    .build();
        }
        return INSTANCE;
    }

    /**
     * Populating the database when it is created, the random data will be put into database,
     * will be erase with data input
     */

    private static RoomDatabase.Callback sRoomDatabaseCallBack = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAysnc(INSTANCE).execute();
        }
    };

    //Adding callback method for population the db

    private static class PopulateDbAysnc extends AsyncTask<Void,Void,Void>{
        private final PassengerDAO passengerDAO;
        private final TicketInforDAO ticketInforDAO;

        public PopulateDbAysnc(TravelDatabase database) {
            this.passengerDAO = database.passengerDAO();
            this.ticketInforDAO = database.ticketInforDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ticketInforDAO.clearTicketInfor();

            Passenger defaultPassenger = new Passenger("0","default","default","default");
            TicketInformation defaultTicketInfor = new TicketInformation();
            String time = "1-1-2019";
            defaultTicketInfor.setOrder_time(time);
            defaultPassenger.setPorderTime(time);
            defaultTicketInfor.addPassanger(defaultPassenger);
            ticketInforDAO.insertTicketInfor(defaultTicketInfor);
            passengerDAO.insert(defaultPassenger);


            return null;
        }
    }


}
