import '../../data/repositories/team_repository.dart';
import '../models/team.dart';
import 'team_service.dart';

class TeamServiceImpl implements TeamService {
  final TeamRepository _teamRepository;

  TeamServiceImpl(this._teamRepository);

  @override
  Future<int> addTeam(String teamName) async {
    return await _teamRepository.insertTeam(teamName);
  }

  @override
  Future<Team?> searchTeamByName(String teamName) async {
    var result = await _teamRepository.getTeamOrNull(teamName);

    if (result != null) {
      return Team(id: result.id!, name: result.name);
    }
    return null;
  }

  @override
  Future<List<Team>> getTeamList() async {
    var result = await _teamRepository.getTeams();
    return result.map((e) => Team.fromEntity(e)).toList();
  }

  @override
  dynamic removeTeam() {
    // TODO: implement removeTeam
    throw UnimplementedError();
  }
}
