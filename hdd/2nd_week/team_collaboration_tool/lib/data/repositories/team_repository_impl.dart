import '../../db/database.dart';
import '../data_sources/team_dao.dart';
import 'team_repository.dart';

class TeamRepositoryImpl implements TeamRepository {
  final TeamDao teamDao;

  TeamRepositoryImpl(this.teamDao);

  @override
  deleteTeam() {
    throw UnimplementedError();
  }

  @override
  Future<TeamEntity?> getTeamOrNull(String teamName) {
    return teamDao.getTeamOrNull(teamName);
  }

  @override
  Future<int> insertTeam(String teamName) {
    return teamDao.insertTeam(teamName);
  }

  @override
  Future<List<TeamEntity>> getTeams() {
    return teamDao.getTeams();
  }
}
