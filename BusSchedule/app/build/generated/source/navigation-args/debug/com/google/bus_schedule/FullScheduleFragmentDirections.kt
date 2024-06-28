package com.google.bus_schedule

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class FullScheduleFragmentDirections private constructor() {
  private data class ActionFullScheduleFragmentToStopScheduleFragment(
    public val stopName: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_fullScheduleFragment_to_stopScheduleFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("stopName", this.stopName)
        return result
      }
  }

  public companion object {
    public fun actionFullScheduleFragmentToStopScheduleFragment(stopName: String): NavDirections =
        ActionFullScheduleFragmentToStopScheduleFragment(stopName)
  }
}
