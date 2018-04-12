package com.mrkostua.mathalarm.alarmSettings.mainSettings

/**
 * @author Kostiantyn Prysiazhnyi on 3/12/2018.
 */
enum class AlarmSettingsNames {
    OPTION_SET_TIME {
        override fun getKeyValue(): Int = 0

    },
    OPTION_SET_RINGTONE {
        override fun getKeyValue(): Int = 1

    },
    OPTION_SET_MESSAGE {
        override fun getKeyValue(): Int = 2

    },
    OPTION_SET_DEEP_SLEEP_MUSIC {
        override fun getKeyValue(): Int = 3

    },
    WRONG_OPTION {
        override fun getKeyValue(): Int = -1
    };

    abstract fun getKeyValue(): Int

    public fun getAlarmSettingName(keyValue: Int): AlarmSettingsNames {
        return when (keyValue) {
            OPTION_SET_TIME.getKeyValue() -> OPTION_SET_TIME
            OPTION_SET_RINGTONE.getKeyValue() -> OPTION_SET_RINGTONE
            OPTION_SET_MESSAGE.getKeyValue() -> OPTION_SET_MESSAGE
            OPTION_SET_DEEP_SLEEP_MUSIC.getKeyValue() -> OPTION_SET_DEEP_SLEEP_MUSIC
            else -> OPTION_SET_TIME
        }
    }
}