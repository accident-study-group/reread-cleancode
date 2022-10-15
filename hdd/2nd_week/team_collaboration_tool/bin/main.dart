import 'package:riverpod/riverpod.dart';

import 'commands/get_teams.dart';

void main(List<String> args) async {
  final container = ProviderContainer();

  container.read(getTeamsProvider).call();
}
