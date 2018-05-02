package com.mrkostua.mathalarm.alarms.mathAlarm.mainAlarm

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.mrkostua.mathalarm.data.AlarmDataHelper
import com.mrkostua.mathalarm.tools.AlarmTools
import com.mrkostua.mathalarm.tools.ShowLogs
import java.util.*
import javax.inject.Inject

/**
 * @author Kostiantyn Prysiazhnyi on 3/21/2018.
 */
//TODO write test for this class
class MainAlarmViewModel @Inject constructor(private val dataHelper: AlarmDataHelper) : ViewModel() {
    private val TAG = this.javaClass.simpleName
    private val calendar = Calendar.getInstance()
    private val time = dataHelper.getTimeFromSP()

    val alarmTime = ObservableField<String>() //no sens in using observable (just practicing)
    val isDarkTime = ObservableBoolean()

    val alarmHour = AlarmTools.getReadableHour(time.first)
    val alarmMinute = AlarmTools.getReadableMinute(time.second)
    val alarmRingtone = dataHelper.getRingtoneFromSP()
    val alarmMessage = dataHelper.getTextMessageFromSP()
    val alarmDeepWakeUp = dataHelper.getDeepWakeUpStateFromSP()

    init {
        start()
    }

    private fun start() {
        alarmTime.set(AlarmTools.getReadableTime(time.first, time.second))
        calendar.timeInMillis = System.currentTimeMillis()
        setDayOrNight()
    }

    private fun setDayOrNight() {
        isDarkTime.set(calendar.get(Calendar.HOUR_OF_DAY) !in 6 until 20)
        ShowLogs.log(TAG, "setDayOrNight : " + isDarkTime.get())

    }

    fun getCurrentDayOfWeek(): Int {
        return calendar.get(Calendar.DAY_OF_WEEK) - 1

    }

    fun isFirstAlarmCreation() = dataHelper.isFirstAlarmSaving()

    fun getAlarmDataObject() = dataHelper.getAlarmDataObject()
}