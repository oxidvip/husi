package io.nekohasekai.sagernet.aidl;

import io.nekohasekai.sagernet.aidl.SpeedDisplayData;
import io.nekohasekai.sagernet.aidl.TrafficData;
import io.nekohasekai.sagernet.aidl.DashboardStatus;

oneway interface ISagerNetServiceCallback {
  void stateChanged(int state, String profileName, String msg);
  void cbSpeedUpdate(in SpeedDisplayData stats);
  void cbTrafficUpdate(in TrafficData stats);
  void cbSelectorUpdate(long id);
  void dashboardStatusUpdate(in DashboardStatus status);
  void clashModeUpdate(in String mode);
}
