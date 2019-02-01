package com.example.fang.b16traveldomain.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SeatsAvailableAdapter extends RecyclerView.Adapter<SeatsAvailableAdapter.SeatViewHolder>  {

    Context context;
    List<Seat> seatList;
    static List<String> seatsReserved;
    BusInformation busInformation;
    List<Double> total;
    ToggleButton[] toggleButtons;
    int index;

    private static final String TAG_SEATS = SeatsAvailableAdapter.class.getSimpleName();

    public SeatsAvailableAdapter(Context context, List<Seat> seatList, BusInformation busInformation) {
        this.context = context;
        this.seatList = seatList;
        this.busInformation = busInformation;
        this.seatsReserved = new ArrayList<>();
        this.total = new ArrayList<>();
        this.toggleButtons= new ToggleButton[10];
    }

    @NonNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_seat_card, viewGroup, false);
        return new SeatViewHolder(view);
    }

    public class SeatViewHolder extends RecyclerView.ViewHolder {

        ToggleButton tb0, tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8, tb9, tb10;
        TextView tvFare, tvSeats;
        ImageButton imageButton;

        public SeatViewHolder(@NonNull View itemView) {
            super(itemView);
            //use butter knife
            tb0 = itemView.findViewById(R.id.tb_seat_0);
            tb1 = itemView.findViewById(R.id.tb_seat_1);
            tb2 = itemView.findViewById(R.id.tb_seat_2);
            tb3 = itemView.findViewById(R.id.tb_seat_3);
            tb4 = itemView.findViewById(R.id.tb_seat_4);
            tb5 = itemView.findViewById(R.id.tb_seat_5);
            tb6 = itemView.findViewById(R.id.tb_seat_6);
            tb7 = itemView.findViewById(R.id.tb_seat_7);
            tb8 = itemView.findViewById(R.id.tb_seat_8);
            tb9 = itemView.findViewById(R.id.tb_seat_9);
            tvFare = itemView.findViewById(R.id.tv_total_seats_fare);
            tvSeats = itemView.findViewById(R.id.tv_seats_selected);
            imageButton = itemView.findViewById(R.id.buttonNext);


            for (int i = 0; i < toggleButtons.length; i++) {
                String tbID = "tb_seat_" + i;
                int resID = itemView.getResources().getIdentifier(tbID, "id", context.getPackageName());
                toggleButtons[i] = itemView.findViewById(resID);
                // Log.e(TAG, "SeatViewHolder: toggles " + tbID + " size " + toggleButtons.length);
                // Log.e(TAG, "SeatViewHolder: toggles resID :  " + resID  );

            }
        }
    }
    @Override
    public void onBindViewHolder(@NonNull final SeatViewHolder seatViewHolder, int i) {

        //create method that call each seat method dynamically
        Object seat = seatList.get(0);
        Method[] methods = seat.getClass().getMethods();
        final List<Method> seats = new ArrayList<>();

        Arrays.sort(methods, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                String s1= o1.getName();
                String s2 = o2.getName();
                return extractInt(s1) - extractInt(s2);
            }
            int extractInt (String s){
                String num = s.replaceAll("\\D", "");
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        for(index =0; index < methods.length  ; index++) {
            if (methods[index].getName().contains("getSeat")) {
               seats.add(methods[index]);
            }
        }

        for (int j = 0; j < seats.size() ; j++) {
           final String seat_no = String.valueOf(j + 1);
           // Log.e(TAG, "onBindViewHolder: seat: at index " + j + " is " + seats.get(j).getName());
            try {
                Object o = seats.get(j).invoke(seat);
               // Log.e(TAG, "onBindViewHolder: at index " + j +" o is " + o );
                if (o.equals("0")){
                  toggleButtons[j].setBackgroundResource(R.drawable.toggle_seat);
                  toggleButtons[j].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                      @Override
                      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                          if(isChecked){
                              //add fare
                              double d = addFare(Double.parseDouble(busInformation.getFare()));
                              seatViewHolder.tvFare.setText(String.valueOf(d));
                              //add seat
                              seatViewHolder.tvSeats.setText(reserveSeat(seat_no));
                          } else if(!isChecked){
                              //remove fare amount
                              double d = removeFare(Double.parseDouble(busInformation.getFare()));
                              seatViewHolder.tvFare.setText(String.valueOf(d));
                              //remove seat
                              seatViewHolder.tvSeats.setText(unreservedSeat(seat_no));

                          }
                      }
                  });
                } else if (o.equals("1")){
                  toggleButtons[j].setBackgroundResource(R.drawable.seat_reserved);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        seatViewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent;
               intent = new Intent(); //context to next activity
                //intent.
               //intent.putExtra("bus",busInformation);
            }
        });

    }//bindholder


    @Override
    public int getItemCount() {
        return seatList.size();
    }


    public double addFare(double f) {
        double sum = 0;
       /* if(fare == 0){
            fare += f;*/
        total.add(f);
        for (double d : total) {
            sum += d;
            Log.e(TAG_SEATS, "onCheckedChanged: " + "fare added" + total.size());
        }
        return sum;

    }

    public double removeFare(double f) {
        double changeTotal = 0;
        total.remove(f);
        if (total.size() != 0) {
            for (double d : total)
                changeTotal += d;
            Log.e(TAG_SEATS, "onCheckedChanged: " + "fare removed" + total.size());
        }
        return changeTotal;
    }

    public String reserveSeat(String s) {
        String seatsSelected = " ";
        seatsReserved.add(s);
        for (String a : seatsReserved) {
            if (seatsReserved.size() == 1) {
                seatsSelected += a;
            } else
                seatsSelected += a + " , ";
        }
        return seatsSelected;
    }

    public String unreservedSeat(String s) {
        String seatsSelected = " ";
        seatsReserved.remove(s);
        if (seatsReserved.size() > 0) {
            for (String a : seatsReserved) {
                if (seatsReserved.size() == 1) {
                    seatsSelected += a;
                } else
                    seatsSelected += a + " , ";
            }
        }
        return seatsSelected;
    }

}
