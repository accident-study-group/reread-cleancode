import 'package:drift/native.dart';

import 'commands/add_team.dart';
import 'commands/get_teams.dart';
import 'commands/search_team.dart';
import 'data/data_sources/team_dao.dart';
import 'data/repositories/team_repository.dart';
import 'db/database.dart';
import 'domain/services/team_service.dart';

// TODO 현재는 간단하게 관리하지만 나중에는 좀 더 깊이있는 디펜던시 매니저 생성
class DependencyManager {
  late final Database database = Database(NativeDatabase.memory());
  late final TeamDao teamDao = TeamDao(database);
  late final TeamRepository teamRepository = TeamRepositoryImpl(teamDao);
  late final TeamService teamService = TeamServiceImpl(teamRepository);

  late final AddTeam addTeam = AddTeam(teamService);
  late final GetTeams getTeams = GetTeams(teamService);
  late final SearchTeam searchTeam = SearchTeam(teamService);

  DependencyManager._();
}

final dependencyManager = DependencyManager._();
