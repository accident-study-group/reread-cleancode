import 'dart:io';

import '../core/base_command.dart';
import '../domain/services/team_service.dart';

class SearchTeam implements BaseCommand {
  final TeamService _teamService;

  SearchTeam(this._teamService);

  @override
  Future<void> call() async {
    try {
      stdout.writeln('검색하시려는 팀 명을 입력해주세요.');
      var teamName = stdin.readLineSync()?.trim() ?? '';
      if (teamName.isEmpty) {
        stderr.writeln('동작 실패: 팀 명을 입력해주세요.');
        return;
      }
      var result = await _teamService.searchTeamByName(teamName);

      if (result == null) {
        stdout.writeln('생성된 팀이 없습니다.');
        stdout.writeln('처음으로 팀을 만들어보세요!');
        stdout.writeln('');
        return;
      }

      stdout.writeln(result);
    } catch (e) {
      stderr.writeln('동작 실패: 이미 있는 팀 명입니다.');
    }
  }
}
