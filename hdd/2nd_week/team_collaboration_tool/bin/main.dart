import 'package:riverpod/riverpod.dart';
import 'package:team_collaboration_tool/commands/add_team.dart';

void main(List<String> args) async {
  final container = ProviderContainer();

  container.read(addTeamProvider).call();
  container.read(addTeamProvider).call();
}
