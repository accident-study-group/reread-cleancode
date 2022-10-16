import 'package:riverpod/riverpod.dart';

import '../../db/database.dart';
import '../data_sources/team_dao.dart';
import 'team_repository_impl.dart';

final teamRepositoryProvider = Provider<TeamRepository>(
  (ref) => TeamRepositoryImpl(
    ref.watch(teamDaoProvider),
  ),
);

abstract class TeamRepository {
  Future<TeamEntity?> getTeamOrNull(String teamName);

  Future<int> insertTeam(String teamName);

  Future<List<TeamEntity>> getTeams();

  deleteTeam();
}
