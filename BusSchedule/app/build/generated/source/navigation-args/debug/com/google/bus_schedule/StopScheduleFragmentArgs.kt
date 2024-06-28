package com.google.bus_schedule

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class StopScheduleFragmentArgs(
  public val stopName: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("stopName", this.stopName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("stopName", this.stopName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): StopScheduleFragmentArgs {
      bundle.setClassLoader(StopScheduleFragmentArgs::class.java.classLoader)
      val __stopName : String?
      if (bundle.containsKey("stopName")) {
        __stopName = bundle.getString("stopName")
        if (__stopName == null) {
          throw IllegalArgumentException("Argument \"stopName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"stopName\" is missing and does not have an android:defaultValue")
      }
      return StopScheduleFragmentArgs(__stopName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): StopScheduleFragmentArgs {
      val __stopName : String?
      if (savedStateHandle.contains("stopName")) {
        __stopName = savedStateHandle["stopName"]
        if (__stopName == null) {
          throw IllegalArgumentException("Argument \"stopName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"stopName\" is missing and does not have an android:defaultValue")
      }
      return StopScheduleFragmentArgs(__stopName)
    }
  }
}
