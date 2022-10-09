void main() {
  final batteryAmount = BatteryAmount(10055342, max: 23632425);
  final battery = MacBookBattery(batteryAmount);

  print('battery.remainingPercent() = ${battery.remainingPercent()}');
  print('battery.isLow() = ${battery.isLow()}');
  print('battery.isHigh() = ${battery.isHigh()}');
}

abstract class Battery {
  num remainingPercent();

  bool isLow();

  bool isHigh();
}

class MacBookBattery implements Battery {
  final BatteryAmount amount;

  MacBookBattery(this.amount);

  @override
  bool isHigh() {
    return remainingPercent() > 70;
  }

  @override
  bool isLow() {
    return remainingPercent() < 25;
  }

  @override
  num remainingPercent() {
    return (amount.value / (amount.max)) * 100;
  }
}

class BatteryAmount {
  final int value;
  final int max;

  BatteryAmount(this.value, {required this.max}) : assert(max >= value);
}
