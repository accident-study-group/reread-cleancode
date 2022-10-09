import 'dependency_manager.dart';

void main(List<String> args) async {
  await dependencyManager.getTeams.call();
  await dependencyManager.addTeam.call();
  await dependencyManager.searchTeam.call();
}