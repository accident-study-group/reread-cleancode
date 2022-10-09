void main() {
  final batteryAmount = BatteryAmount(10055342, max: 23632425);
  final battery = MacBookBattery(batteryAmount);

  print('battery.remainingPercent = ${battery.remainingPercent}');
  print('battery.isHigh = ${battery.isHigh}');
  print('battery.isLow = ${battery.isLow}');
}

abstract class Battery {
  num get remainingPercent;

  bool get isHigh;

  bool get isLow;
}

class MacBookBattery implements Battery {
  final BatteryAmount amount;

  MacBookBattery(this.amount);

  @override
  num get remainingPercent => (amount.value / (amount.max)) * 100;

  @override
  bool get isHigh => remainingPercent > 70;

  @override
  bool get isLow => remainingPercent < 25;
}

class BatteryAmount {
  final int value;
  final int max;

  BatteryAmount(this.value, {required this.max}) : assert(max >= value);
}
