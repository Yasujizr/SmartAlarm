package com.mrkostua.mathalarm.tools

import android.app.Fragment
import com.mrkostua.mathalarm.alarmSettings.FragmentOptionSetDeepSleepMusic
import com.mrkostua.mathalarm.alarmSettings.FragmentOptionSetMessage
import com.mrkostua.mathalarm.alarmSettings.mainSettings.AlarmSettingsNames
import com.mrkostua.mathalarm.alarmSettings.optionSetRingtone.FragmentOptionSetRingtone
import com.mrkostua.mathalarm.alarmSettings.optionSetTime.FragmentOptionSetTime

/**
 * @author Kostiantyn on 07.11.2017.
 */

object ConstantValues {
    /**
     * LOG_DEBUG_STATUS true for debug mode, false for production.
     */
    const val LOG_DEBUG_STATUS = true

    val ALARM_RINGTONE_NAMES = arrayOf("ringtone_mechanic_clock", "ringtone_energy", "ringtone_loud", "ringtone_digital_clock")
    const val CUSTOM_ALARM_RINGTONE = "ringtone_energy"

    //actions for alarm receiver
    const val SNOOZE_ACTION = "alarm_snooze"
    const val DISMISS_ACTION = "alarm_dismiss"
    const val START_NEW_ALARM_ACTION = "alarm_start_new"
    const val ALARM_TIMEOUT_MILLISECONDS: Long = 5 * 60 * 1000
    const val DEFAULT_SNOOZE_TIME_MIN = 5

    const val WAKE_LOCK_NOTIFICATION_TIME_KEY = "notificationTimeKey"

    const val NOTIFICATION_CHANNEL_ID = "alarm_kotlin"
    const val NOTIFICATION_CHANEL_NAME = "Smart Alarm"
    const val NOTIFICATION_CHANEL_DESCRIPTION = "Important notifications that to you interaction with alarm, " +
            "and help alarm to be active so you will wake up at proper time."

    const val DAY_IN_MINUTES = 1440

    const val INTENT_KEY_WHICH_FRAGMENT_TO_LOAD_FIRST = "whichFragmentToLoadFirst"
    val alarmSettingsOptionsList: MutableList<Fragment> = ArrayList()

    init {
        alarmSettingsOptionsList.add(AlarmSettingsNames.OPTION_SET_TIME.getKeyValue(), FragmentOptionSetTime())
        alarmSettingsOptionsList.add(AlarmSettingsNames.OPTION_SET_RINGTONE.getKeyValue(), FragmentOptionSetRingtone())
        alarmSettingsOptionsList.add(AlarmSettingsNames.OPTION_SET_MESSAGE.getKeyValue(), FragmentOptionSetMessage())
        alarmSettingsOptionsList.add(AlarmSettingsNames.OPTION_SET_DEEP_SLEEP_MUSIC.getKeyValue(), FragmentOptionSetDeepSleepMusic())
    }
}
