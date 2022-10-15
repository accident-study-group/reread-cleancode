import 'package:riverpod/riverpod.dart';

import '../../db/database.dart';
import 'team_dao_impl.dart';

final teamDaoProvider = Provider<TeamDao>(
  (ref) => TeamDaoImpl(
    ref.watch(databaseProvider),
  ),
);

abstract class TeamDao {
  Future<TeamEntity?> getTeamOrNull(String name);

  Future<int> insertTeam(String name);

  Future<List<TeamEntity>> getTeams();
}
