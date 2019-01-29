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

import com.example.fang.b16traveldomain.MainActivity;
import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seat;
import com.example.fang.b16traveldomain.passengerinformation.PassengerInformationActivity;
import com.example.fang.b16traveldomain.seatsavailable.SeatsAvailableActivity;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class SeatsAvailableAdapter extends RecyclerView.Adapter<SeatsAvailableAdapter.SeatViewHolder>  {

    Context context;
    List<Seat> seatList;
    static List<String> seatsReserved;
    BusInformation busInformation;
    List<Double> total;
    static private String BUS_INFORMATION_TAG = "bus_infor";
    private static final String TAG_SEATS = SeatsAvailableAdapter.class.getSimpleName();

    public SeatsAvailableAdapter(Context context, List<Seat> seatList, BusInformation busInformation) {
        this.context = context;
        this.seatList = seatList;
        this.busInformation = busInformation;
        this.seatsReserved = new ArrayList<>();
        this.total = new ArrayList<>();
    }

    @NonNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_seat_card, viewGroup, false);
        return new SeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SeatViewHolder seatViewHolder, final int i) {

        //create method that call each seat method dynamically
       /* Object seat = seatList.get(0);
        Method[] methods = seat.getClass().getMethods();

        for( int index =0; index < methods.length; index++){

            if( methods[index].getName().contains( "getSeat")){
                // Do something here
                Log.e(TAG, "onBindViewHolder: " + methods[index].getName());

                Object o = methods[index].invoke(seat);
               *//* if(methods[index].invoke(seat) == null){

                }*//*
         */

        //fare = Double.parseDouble(busInformation.getFare());
        Log.e(TAG, "onBindViewHolder: " + busInformation.getBusId() + " fare is " + busInformation.getFare());

        final String seat1 = seatList.get(i).getSeat1();
        final String seat_no1 = seatViewHolder.tb0.getText().toString();

        final String seat2 = seatList.get(i).getSeat2();
        final String seat_no2 = seatViewHolder.tb1.getText().toString();

        final String seat3 = seatList.get(i).getSeat3();
        final String seat_no3 = seatViewHolder.tb2.getText().toString();

        final String seat4 = seatList.get(i).getSeat4();
        final String seat_no4 = seatViewHolder.tb3.getText().toString();

        final String seat5 = seatList.get(i).getSeat5();
        final String seat_no5 = seatViewHolder.tb4.getText().toString();

        final String seat6 = seatList.get(i).getSeat6();
        final String seat_no6 = seatViewHolder.tb5.getText().toString();

        final String seat7 = seatList.get(i).getSeat7();
        final String seat_no7 = seatViewHolder.tb6.getText().toString();

        final String seat8 = seatList.get(i).getSeat8();
        final String seat_no8 = seatViewHolder.tb7.getText().toString();

        final String seat9 = seatList.get(i).getSeat9();
        final String seat_no9 = seatViewHolder.tb8.getText().toString();

        final String seat10 = seatList.get(i).getSeat10();
        final String seat_no10 = seatViewHolder.tb9.getText().toString();


        //seat1
        if (seat1.equals("1")) {
            seatViewHolder.tb0.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat1.equals("0")) {
            seatViewHolder.tb0.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no1));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");
                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no1));

                    }
                }
            });
        }


        //seat2
        if (seat2.equals("1")) {
            seatViewHolder.tb1.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat2.equals("0")) {
            seatViewHolder.tb1.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no2));

                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");
                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no2));

                    }
                }
            });
        }

        //seat3
        if (seat3.equals("1")) {
            seatViewHolder.tb2.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat3.equals("0")) {
            seatViewHolder.tb2.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no3));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");
                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no3));

                    }
                }
            });
        }

        //seat 4
        if (seat4.equals("1")) {
            seatViewHolder.tb3.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat4.equals("0")) {
            seatViewHolder.tb3.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double f = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(f));

                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no4));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");
                        //remove fare amount
                        double r = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(r));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no4));
                    }
                }
            });
        }

        //seat5
        if (seat5.equals("1")) {
            seatViewHolder.tb4.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat5.equals("0")) {
            seatViewHolder.tb4.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no5));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");

                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no5));

                    }
                }
            });
        }

        //seat6
        if (seat6.equals("1")) {
            seatViewHolder.tb5.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat6.equals("0")) {
            seatViewHolder.tb5.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));

                        //add seat
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no6));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");

                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        //remove seat
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no6));

                    }
                }
            });
        }

        //seat7
        if (seat7.equals("1")) {
            seatViewHolder.tb6.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat7.equals("0")) {
            seatViewHolder.tb6.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));

                        //add seat
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no7));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");

                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        //remove seat
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no7));
                    }
                }
            });
        }
        //seat8
        if (seat8.equals("1")) {
            seatViewHolder.tb7.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat8.equals("0")) {
            seatViewHolder.tb7.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));

                        //add seat
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no8));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");

                        //remove fare amount
                        double d = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));
                        //remove seat
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no8));
                    }
                }
            });
        }
        //seat9
        if (seat9.equals("1")) {
            seatViewHolder.tb8.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat9.equals("0")) {
            seatViewHolder.tb8.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));

                        //reserved selected seat and show seats selected
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no9));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");

                        //remove fare amount
                        double r = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(r));
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no9));
                    }
                }
            });
        }
        //seat10

        if (seat10.equals("1")) {
            seatViewHolder.tb9.setBackgroundResource(R.drawable.seat_reserved);
        } else if (seat10.equals("0")) {
            seatViewHolder.tb9.setBackgroundResource(R.drawable.toggle_seat);
            seatViewHolder.tb9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: True");
                        //add fare
                        double d = addFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(d));

                        //reserved selected seat and show seats selected
                        seatViewHolder.tvSeats.setText(reserveSeat(seat_no10));
                    } else if (!isChecked) {
                        Log.e(TAG_SEATS, "onCheckedChanged: False ");

                        //remove fare amount
                        double r = removeFare(Double.parseDouble(busInformation.getFare()));
                        seatViewHolder.tvFare.setText(String.valueOf(r));
                        //unreserved selected seat and show seats selected
                        seatViewHolder.tvSeats.setText(unreservedSeat(seat_no10));
                    }
                }
            });
        }

        seatViewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent;
               intent = new Intent(context,PassengerInformationActivity.class); //context to next activity
                //intent.
               intent.putExtra(BUS_INFORMATION_TAG,busInformation);
               intent.putStringArrayListExtra("seats",(ArrayList<String>) seatsReserved);
               context.startActivity(intent);

            }
        });

    }//bindholder


    @Override
    public int getItemCount() {
        return seatList.size();
    }

    public class SeatViewHolder extends RecyclerView.ViewHolder {

        ToggleButton tb0, tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8, tb9, tb10;
        TextView tvFare, tvSeats;
        ImageButton imageButton;

        public SeatViewHolder(@NonNull View itemView) {
            super(itemView);
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


          /* for(int i=0 ; i < 10 ; i++){
                String tbID = "tb_seat_" + i;
                int resID = itemView.getResources().getIdentifier(tbID,"id", context.getPackageName());
                toggleButtons[i] = itemView.findViewById(resID);
               Log.e(TAG, "SeatViewHolder: "+ toggleButtons[i].toString() );
            }*/
        }
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
