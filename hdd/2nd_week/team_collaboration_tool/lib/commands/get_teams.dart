import 'dart:io';

import 'package:riverpod/riverpod.dart';

import '../core/base_command.dart';
import '../domain/services/team_service.dart';

final getTeamsProvider =
    Provider<GetTeams>((ref) => GetTeams(ref.watch(teamServiceProvider)));

class GetTeams implements BaseCommand {
  final TeamService _teamService;

  GetTeams(this._teamService);

  @override
  Future<void> call() async {
    var teams = await _teamService.getTeamList();
    stdout.writeln('######현재팀목록######');

    if (teams.isEmpty) {
      stdout.writeln('생성된 팀이 없습니다.');
      stdout.writeln('처음으로 팀을 만들어보세요!');
      stdout.writeln('');
      return;
    }

    stdout.writeln(teams);
    stdout.writeln('');
  }
}
