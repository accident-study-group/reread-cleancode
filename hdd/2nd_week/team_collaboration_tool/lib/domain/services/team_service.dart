import 'package:riverpod/riverpod.dart';

import '../../data/repositories/team_repository.dart';
import '../models/team.dart';
import 'team_service_impl.dart';

final teamServiceProvider = Provider<TeamService>(
  (ref) => TeamServiceImpl(
    ref.watch(teamRepositoryProvider),
  ),
);

abstract class TeamService {
  Future<int> addTeam(String teamName);

  Future<Team?> searchTeamByName(String teamName);

  dynamic removeTeam();

  Future<List<Team>> getTeamList();
}
