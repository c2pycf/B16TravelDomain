package com.example.fang.b16traveldomain.seatsavailable

import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation
import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats

interface SeatsAvailableContract {

    interface SeatsAvailableView {
        fun setupSeatAvailableMVP()
        fun showSeatAvailableActivity(seats: Seats, busInformation: BusInformation)
        fun setupSeatsView()
        fun getSeats()
    }

    interface SeatsAvailablePresenter {
        fun findSeats(mbus: BusInformation)
    }
}
