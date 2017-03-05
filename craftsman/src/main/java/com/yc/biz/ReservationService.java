package com.yc.biz;

import java.util.Date;
import java.util.List;

import com.yc.bean.Reservation;
import com.yc.bean.ReservationInfo;


public interface ReservationService {
	 public Reservation getReservation( Integer workerId, Date serviceDate, Integer serviceTime);
	 public int insertReservation(Reservation record);
	 public List<Reservation> getAllReservation(ReservationInfo reservationInfo);
}
